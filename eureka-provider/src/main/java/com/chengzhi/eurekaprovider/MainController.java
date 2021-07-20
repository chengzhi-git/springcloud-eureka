package com.chengzhi.eurekaprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chengzhi
 * @Date:2021/7/20 23:40
 * @Description
 */
@RestController
public class MainController {
    @GetMapping("getHi")
    public String getHi(){
        return "Hi";
    }
}
