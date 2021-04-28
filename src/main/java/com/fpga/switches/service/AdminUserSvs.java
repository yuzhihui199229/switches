package com.fpga.switches.service;

import com.fpga.switches.dao.AdminUserDao;
import com.fpga.switches.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminUserSvs {
    @Autowired
    private AdminUserDao adminUserDao;

    public AdminUser login(Map<String, Object> map) {
        return adminUserDao.login(map);
    }
}
