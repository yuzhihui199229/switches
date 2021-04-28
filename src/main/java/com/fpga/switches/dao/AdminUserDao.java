package com.fpga.switches.dao;

import com.fpga.switches.pojo.AdminUser;

import java.util.Map;

public interface AdminUserDao {
    AdminUser login(Map<String, Object> map);
}
