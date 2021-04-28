package com.fpga.switches.pojo;

public enum PushType {
    NOTALL("0","原码行情只推送行情数据"),ALL("1","原码行情推送所有数据");

    PushType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
