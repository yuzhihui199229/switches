package com.fpga.switches.ctrl;

import com.fpga.switches.pojo.MktUserLogin;
import com.fpga.switches.pojo.Result;
import com.fpga.switches.pojo.StatusCode;
import com.fpga.switches.service.MktUserLoginSvs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/mktUserLogin")
public class MktUserLoginCtrl {
    @Autowired
    private MktUserLoginSvs mktUserLoginSvs;

    @PostMapping("/getMktUserLogin")
    public Result getMktUserLogin(@RequestBody Map<String, Object> map) {
        List<MktUserLogin> list = mktUserLoginSvs.getMktUserLogin(map);
        if (list != null) {
            for (MktUserLogin mktUserLogin : list) {
                if (mktUserLogin.getSubscribeSecType() != null) {
                    String subscribeSecTypeStr = mktUserLogin.getSubscribeSecType();
                    String[] split = subscribeSecTypeStr.split(",");
                    if (split.length >= 2) {
                        String s = split[1];
                        int i = Integer.parseInt(s);
                        StringBuilder sb = new StringBuilder();
                        sb.append(split[0]);
                        sb.append(":");
                        if (i == 127) {
                            sb.append("所有类型");
                        } else {
                            if ((i & 0x01) == 1) {
                                sb.append("指数快照 ");
                            }
                            if ((i & 0x02) == 2) {
                                sb.append("五档行情快照(Level1) ");
                            }
                            if ((i & 0x04) == 4) {
                                sb.append("十档行情快照(Level2) ");
                            }
                            if ((i & 0x08) == 8) {
                                sb.append("逐笔委托 ");
                            }
                            if ((i & 0x10) == 16) {
                                sb.append("逐笔成交 ");
                            }
                            if ((i & 0x20) == 32) {
                                sb.append("委托队列 ");
                            }
                            if ((i & 0x40) == 64) {
                                sb.append("期权 ");
                            }
                        }
                        String s1 = sb.toString();
                        mktUserLogin.setSubscribeSecType(s1);
                    }
                }
            }
            return new Result(StatusCode.OK, "查询成功", list);
        }
        return new Result(StatusCode.ERROR, "查询失败");
    }
}
