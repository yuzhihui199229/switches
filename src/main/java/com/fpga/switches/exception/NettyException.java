package com.fpga.switches.exception;

import lombok.Data;

@Data
public class NettyException extends Exception{
    private String code;

    public NettyException(String message, String code) {
        super(message);
        this.code = code;
    }
}
