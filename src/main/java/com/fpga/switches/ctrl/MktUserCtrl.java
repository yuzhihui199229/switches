package com.fpga.switches.ctrl;

import com.fpga.switches.pojo.MktUser;
import com.fpga.switches.pojo.Result;
import com.fpga.switches.pojo.StatusCode;
import com.fpga.switches.service.MktUserSvs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/mktUser")
public class MktUserCtrl {
    @Autowired
    private MktUserSvs mktUserSvs;

    @PostMapping("/getMktUser")
    public Result getMktUser(@RequestBody Map<String, Object> map) {
        List<MktUser> list = mktUserSvs.getMktUser(map);
        if (list != null)
            return new Result(StatusCode.OK, "查询成功", list);
        return new Result(StatusCode.ERROR, "查询失败");
    }

    @PostMapping("/istMktUser")
    public Result istMktUser(@RequestBody Map<String, Object> map) {
        if (map.get("userName")==null||map.get("userName")=="") {
            return new Result(StatusCode.ERROR, "添加失败,用户名不能为空");
        }
        if (map.get("marketPassword") == null||map.get("marketPassword") == "") {
            return new Result(StatusCode.ERROR, "添加失败,密码不能为空");
        }
        if (map.get("pushType") == null||map.get("pushType") == "") {
            return new Result(StatusCode.ERROR, "添加失败,推送配置不能为空");
        }
        if (map.get("switchPort") == null||map.get("switchPort") == "") {
            return new Result(StatusCode.ERROR, "添加失败,端口不能为空");
        }
        if (Integer.parseInt((String)map.get("switchPort"))>=40) {
            return new Result(StatusCode.ERROR, "添加失败,端口上限应为40");
        }
        int portCnt = mktUserSvs.getPort(map);
        if (portCnt>0) {
            return new Result(StatusCode.ERROR, "添加失败,该端口已配置");
        }
        int usercnt = mktUserSvs.getUser(map);
        if (usercnt > 0) {
            return new Result(StatusCode.ERROR, "添加失败,该用户已配置");
        }
        int i = mktUserSvs.istMktUser(map);
        if (i > 0)
            return new Result(StatusCode.OK, "添加成功");
        return new Result(StatusCode.ERROR, "添加失败");
    }

    @PostMapping("/delMktUser")
    public Result delMktUser(@RequestBody Map<String, Object> map) {
        int i = mktUserSvs.delMktUser(map);
        if (i > 0)
            return new Result(StatusCode.OK, "删除成功");
        return new Result(StatusCode.ERROR, "删除失败");
    }

    @PostMapping("/uptMktUser")
    public Result uptMktUser(@RequestBody Map<String, Object> map) {
        if (Integer.parseInt((String)map.get("switchPort"))>=40) {
            return new Result(StatusCode.ERROR, "修改失败,端口上限应为40");
        }
        int i = mktUserSvs.uptMktUser(map);
        if (i > 0)
            return new Result(StatusCode.OK, "修改成功");
        return new Result(StatusCode.ERROR, "修改失败");
    }
}
