package com.fpga.switches.service;

import com.fpga.switches.dao.MktUserDao;
import com.fpga.switches.pojo.MktUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MktUserSvs {
    @Autowired
    private MktUserDao mktUserDao;

    public List<MktUser> getMktUser(Map<String, Object> map) {
        return mktUserDao.getMktUser(map);
    }

    public int getPort(Map<String, Object> map) {
        return mktUserDao.getPort(map);
    }

    public int getUser(Map<String, Object> map) {
        return mktUserDao.getUser(map);
    }

    public int istMktUser(Map<String, Object> map) {
        return mktUserDao.istMktUser(map);
    }

    public int delMktUser(Map<String, Object> map) {
        return mktUserDao.delMktUser(map);
    }

    public int uptMktUser(Map<String, Object> map) {
        return mktUserDao.uptMktUser(map);
    }
}
