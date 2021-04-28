package com.fpga.switches.service;

import com.fpga.switches.dao.MktUserLoginDao;
import com.fpga.switches.pojo.MktUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

@Service
public class MktUserLoginSvs {
    @Autowired
    private MktUserLoginDao mktUserLoginDao;

    public List<MktUserLogin> getMktUserLogin(Map<String, Object> map) {
        return mktUserLoginDao.getMktUserLogin(map);
    }
}
