package com.fpga.switches.dao;

import com.fpga.switches.pojo.MktUser;

import java.util.List;
import java.util.Map;

public interface MktUserDao {
    List<MktUser> getMktUser(Map<String, Object> map);

    int getPort(Map<String, Object> map);

    int getUser(Map<String, Object> map);

    int istMktUser(Map<String, Object> map);

    int delMktUser(Map<String, Object> map);

    int uptMktUser(Map<String, Object> map);
}
