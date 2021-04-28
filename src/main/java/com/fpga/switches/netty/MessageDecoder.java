package com.fpga.switches.netty;

import com.fpga.switches.pojo.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageDecoder extends ReplayingDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //需要将二朝向字节码->MessageProtocol封装成messageProtocol对象
        MessageProtocol messageProtocol = new MessageProtocol();
        int len = in.readInt();
        byte[] content = new byte[len - 32];
        in.readBytes(content);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
        ctx.pipeline().fireChannelRead(out);
    }
}
