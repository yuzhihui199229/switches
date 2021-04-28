package com.fpga.switches.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 读取json文件，并将json转化为Map返回
 */
public class ReadJsonFileUtil {
 
    public static Map<String,Object> getMap(){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        try {
            //路径
            ClassPathResource classPathResource = new ClassPathResource("dict.json");
            //读取文件信息
            String str = IOUtils.toString(new InputStreamReader(classPathResource.getInputStream(), StandardCharsets.UTF_8));
            //转换为Map对象
            map = JSONObject.parseObject(str, LinkedHashMap.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}