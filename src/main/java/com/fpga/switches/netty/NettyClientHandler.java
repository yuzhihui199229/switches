package com.fpga.switches.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    public static Map<String, Object> map = new HashMap<>();

    @Autowired
    private NettyClient nettyClient;
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            log.info(ctx.channel().remoteAddress() + "，超时类型：" + event.state());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * 处理断开重连
     */
    @SuppressWarnings("static-access")
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("与服务器连接断开，尝试重新连接...");
        final EventLoop eventLoop = ctx.channel().eventLoop();
        // 立即重连
        nettyClient.start();
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端Active:{}", ctx.read());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("客户端收到消息: {}", msg.toString());
//        log.info(""+msg.toString().getBytes().length);
        String s = msg.toString();
        map.put("msg", msg.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info(cause.getMessage());
    }
}