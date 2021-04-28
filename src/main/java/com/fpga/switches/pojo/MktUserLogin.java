package com.fpga.switches.pojo;

import lombok.Data;

@Data
public class MktUserLogin {
    private Integer id;//id
    private String userName;//用户名
    private String loginTime;//日期
    private String subscribeType;//订阅方式
    private Integer subscribeDataType;//订阅数据类型
    private String subscribeSecType;//订阅股票代码信息
}
