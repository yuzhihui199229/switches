package com.fpga.switches.ctrl;

import com.fpga.switches.pojo.AdminUser;
import com.fpga.switches.pojo.Result;
import com.fpga.switches.pojo.StatusCode;
import com.fpga.switches.service.AdminUserSvs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/adminUser")
public class AdminUserCtrl {
    @Autowired
    private AdminUserSvs adminUserSvs;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> map) {
        AdminUser adminUser = adminUserSvs.login(map);
        if (adminUser!=null)
            return new Result(StatusCode.OK, "登陆成功");
        return new Result(StatusCode.ERROR, "登陆失败");
    }
}
