package com.fpga.switches.dao;

import com.fpga.switches.pojo.MktUserLogin;

import java.util.List;
import java.util.Map;

public interface MktUserLoginDao {
    List<MktUserLogin> getMktUserLogin(Map<String, Object> map);
}
