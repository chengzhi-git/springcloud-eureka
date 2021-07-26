package com.chengzhi.eurekaconsumer;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:chengzhi
 * @Date:2021/7/24 11:21
 * @Description
 */
@RestController
public class MainController2 {

    @Autowired
    DiscoveryClient client;

    @Resource
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/getClient6")
    public String getClient6(){
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        return "xxoo";
    }

    @GetMapping("/getClient7")
    public Object getClient7(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        System.out.println("instance:" + instances);
        //随机
        int nextInt = new Random().nextInt(instances.size());

        //轮询
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.getAndIncrement();
        instances.get(i % instances.size());
        //权重
        for (ServiceInstance serviceInstance : instances) {
        //   int quanzhong =  serviceInstance.getMetadata(); 权重1-9
        }

        // ServiceInstance instance = lb.choose("provider");
        ServiceInstance instance = instances.get(nextInt);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        return respStr;
    }

    @GetMapping("/getClient8")
    public Object getClient8(){
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        return respStr;
    }

    @GetMapping("/getClient9")
    public Object getClient9(){
        //自动处理URL
        String url = "http://provider/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        return respStr;
    }
}
