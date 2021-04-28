package com.fpga.switches.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.fpga.switches.netty.NettyClient;
import com.fpga.switches.netty.NettyClientHandler;
import com.fpga.switches.pojo.Result;
import com.fpga.switches.pojo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/tcp")
@Slf4j
public class TcpController {
    @Autowired
    private NettyClient nettyClient;

    /*查询MOD寄存器配置信息请求，新增MOD寄存器配置信息，删除MOD寄存器配置信息请求，修改MOD寄存器配置信息*/
    @PostMapping("/mod/{msgType}")
    public Result mod(@PathVariable int msgType, @RequestBody Map<String, Object> map) {
        map.put("msgType", msgType);
        nettyClient.sendMsg(JSONObject.toJSONString(map));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = (String) NettyClientHandler.map.get("msg");
        NettyClientHandler.map.keySet().removeIf(key -> key.equals("msg"));
        if (msg != null && msg.startsWith("{")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            Result result = new Result();
            if ("0".equals(jsonObject.get("rtnCode"))) {
                result.setCode(StatusCode.OK);
            } else {
                result.setCode(StatusCode.ERROR);
            }
            if (jsonObject.get("data") != null) {
                result.setData(jsonObject.get("data"));
            }
            result.setMsg((String) jsonObject.get("result"));
            return result;
        } else {
            return new Result(StatusCode.ERROR, msg);
        }
    }

    /*查询UOE配置信息请求，修改UOE配置信息请求*/
    @PostMapping("/uoe/{msgType}")
    public Result uoe(@PathVariable int msgType, @RequestBody Map<String, Object> map) {
        map.put("msgType", msgType);
        nettyClient.sendMsg(JSONObject.toJSONString(map));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = (String) NettyClientHandler.map.get("msg");
        NettyClientHandler.map.keySet().removeIf(key -> key.equals("msg"));
        if (msg != null && msg.startsWith("{")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            Result result = new Result();
            if ("0".equals(jsonObject.get("rtnCode"))) {
                result.setCode(StatusCode.OK);
            } else {
                result.setCode(StatusCode.ERROR);
            }
            if (jsonObject.get("data") != null) {
                result.setData(jsonObject.get("data"));
            }
            result.setMsg((String) jsonObject.get("result"));
            return result;
        } else {
            return new Result(StatusCode.ERROR, msg);
        }
    }

    /*查询UOE配置信息请求，修改UOE配置信息请求*/
    @PostMapping("/mutilcastInfo/{msgType}")
    public Result mutilcastInfo(@PathVariable int msgType, @RequestBody Map<String, Object> map) {
        map.put("msgType", msgType);
        nettyClient.sendMsg(JSONObject.toJSONString(map));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = (String) NettyClientHandler.map.get("msg");
        NettyClientHandler.map.keySet().removeIf(key -> key.equals("msg"));
        if (msg != null && msg.startsWith("{")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            Result result = new Result();
            if ("0".equals(jsonObject.get("rtnCode"))) {
                result.setCode(StatusCode.OK);
            } else {
                result.setCode(StatusCode.ERROR);
            }
            if (jsonObject.get("data") != null) {
                result.setData(jsonObject.get("data"));
            }
            result.setMsg((String) jsonObject.get("result"));
            return result;
        } else {
            return new Result(StatusCode.ERROR, msg);
        }
    }

    @PostMapping("/sPortInfo/{msgType}")
    public Result sPortInfo(@PathVariable int msgType, @RequestBody Map<String, Object> map) {
        map.put("msgType", msgType);
        nettyClient.sendMsg(JSONObject.toJSONString(map));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = (String) NettyClientHandler.map.get("msg");
        NettyClientHandler.map.keySet().removeIf(key -> key.equals("msg"));
        if (msg != null && msg.startsWith("{")) {
            JSONObject jsonObject = JSONObject.parseObject(msg);
            Result result = new Result();
            if ("0".equals(jsonObject.get("rtnCode"))) {
                result.setCode(StatusCode.OK);
            } else {
                result.setCode(StatusCode.ERROR);
            }
            if (jsonObject.get("data") != null) {
                result.setData(jsonObject.get("data"));
            }
            result.setMsg((String) jsonObject.get("result"));
            return result;
        } else {
            return new Result(StatusCode.ERROR, msg);
        }
    }
}
