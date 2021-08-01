package com.chengzhi.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

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

    @GetMapping("/getMap")
    public Map<String,String> getMap() {
        return Collections.singletonMap("id","100");
    }

    @GetMapping("/getObj2")
    //@RequestParam,如果不加参数会抛出异常，否则会传入null
    public Person getObj2(@RequestParam String name) {
        Person person = new Person(name, 100);
        return person;
    }

    @PostMapping ("/postObj")
    //@RequestParam,如果不加参数会抛出异常，否则会传入null
    public Person postObj(@RequestBody String name) {
        Person person = new Person(name, 100);
        return person;
    }

    @GetMapping("/getObj")
    public Person getObj(String name) {
        Person person = new Person("程智", 100);
        return person;
    }
    @Autowired
    HealthStatusService hsrv;
    @GetMapping("/health")
    public String getHi(@RequestParam("status") Boolean status){
        hsrv.setStatus(status);
        return hsrv.getStatus();
    }
}
