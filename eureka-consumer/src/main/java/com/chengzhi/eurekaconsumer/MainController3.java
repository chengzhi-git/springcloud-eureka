package com.chengzhi.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * @Author:chengzhi
 * @Date:2021/7/28 00:00
 * @Description
 */
@RestController
public class MainController3 {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getClient10")
    public Object getClient10() {
        //自动处理URL
        String url = "http://provider/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return respStr;
    }

    @GetMapping("/getClient11")
    public Object getClient11() {
        //自动处理URL
        String url = "http://provider/getMap";
        Map map = restTemplate.getForObject(url, Map.class);
        System.out.println("map" + map);
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return map;
    }

    @GetMapping("/getClient12")
    public Object getClient12() {
        //自动处理URL
        String url = "http://provider/getObj";
        Person person = restTemplate.getForObject(url, Person.class);
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return person;
    }
    @GetMapping("/getClient13")
    public Object getClient13() {
        //自动处理URL
        String url = "http://provider/getObj2?name={33333333}";
        Person person = restTemplate.getForObject(url, Person.class,"程智666");
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return person;
    }

    @GetMapping("/getClient14")
    public Object getClient14() {
        //自动处理URL
        String url = "http://provider/getObj2?name={name}";
        Map<String, String> map = Collections.singletonMap("name","chengzhi" );
        Person person = restTemplate.getForObject(url, Person.class,map);
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return person;
    }

    @GetMapping("/getClient15")
    public Object getClient15() {
        //自动处理URL
        String url = "http://provider/postObj";
        Person person = restTemplate.postForObject(url,"chengzhi123",Person.class);
        //ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //System.out.println(forEntity);
        return person;
    }
}
