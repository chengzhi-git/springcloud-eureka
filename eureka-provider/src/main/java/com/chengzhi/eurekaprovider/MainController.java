package com.chengzhi.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chengzhi
 * @Date:2021/7/20 23:40
 * @Description
 */
@RestController
public class MainController {

    @Value("${server.port}")
    String port;
    @GetMapping("/getHi")
    public String getHi() {
        return "Hi,我的port是：" + port;
    }

    @Autowired
    HealthStatusService hsrv;
    @GetMapping("/health")
    public String getHi(@RequestParam("status") Boolean status){
        hsrv.setStatus(status);
        return hsrv.getStatus();
    }
}
