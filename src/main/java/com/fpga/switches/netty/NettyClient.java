package com.fpga.switches.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class NettyClient {

    private EventLoopGroup group = new NioEventLoopGroup();

    @Value("${netty.port}")
    private Integer port;

    @Value("${netty.host}")
    private String host;

    @Autowired
    private NettyClientInitializer nettyClientInitializer;

    private SocketChannel socketChannel;

    /**
     * 发送消息
     */
    public void sendMsg(String s) {
        log.info("向server发送的参数：{}", s);
        socketChannel.writeAndFlush(s);
    }

    @PostConstruct
    public void start() {
        doConnect(new Bootstrap(), group);
    }

    public void doConnect(Bootstrap bootstrap, EventLoopGroup eventLoopGroup) {
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(nettyClientInitializer);
        ChannelFuture future = bootstrap.connect();
        //客户端断线重连逻辑
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                log.info("连接Netty服务端成功");
            } else {
                log.info("连接失败，进行断线重连");
                future1.channel().eventLoop().schedule(() -> start(), 15, TimeUnit.SECONDS);
            }
        });
        socketChannel = (SocketChannel) future.channel();
    }

}
