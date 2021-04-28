package com.fpga.switches.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * result实体类
 */
@Data
public class Result {
    private int code;    //返回码
    private String msg;     //返回信息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;    //返回数据

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result() {
    }
}
