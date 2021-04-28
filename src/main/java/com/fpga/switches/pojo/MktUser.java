package com.fpga.switches.pojo;

import lombok.Data;

@Data
public class MktUser {
    private Integer id;
    private String userName;
    private String marketPassword;
    private Integer switchPort;
    private String pushType;
}
