package com.fpga.switches;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fpga.switches.dao")
public class SwitchesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwitchesApplication.class, args);
    }

}
