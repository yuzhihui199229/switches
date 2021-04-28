package com.fpga.switches.pojo;

import lombok.Data;

@Data
public class MessageProtocol {
    private int len;
    private byte[] content;
}
