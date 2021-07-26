package com.chengzhi.eurekaconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:chengzhi
 *
 * @Date:2021/7/24 11:21
 * @Description
 */
@RestController
public class MainController {

    @Autowired
    DiscoveryClient client;

    @Resource
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;
    @GetMapping("getHi")
    public String getHi(){
        return "Hi";
    }

    @GetMapping("/client1")
    public String getClient(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "Hi";
    }
    @GetMapping("getClient2")
    public Object getInstance(){
        return client.getInstances("provider");
    }
    @GetMapping("getClient3")
    public String getClient3(){
        List<ServiceInstance> instances = client.getInstances("provider");
        for (ServiceInstance instance : instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }
        return "xxoo";
    }

    @GetMapping("getClient4")
    public String getClient4(){
        //List<InstanceInfo> instances = client2.getInstancesById("localhost:provider:80");
        List<InstanceInfo> instances = client2.getInstancesByVipAddress("provider", false);
        for (InstanceInfo ins : instances) {
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }
        if(instances.size() > 0){
            InstanceInfo instance = instances.get(0);
            if(instance.getStatus() == InstanceInfo.InstanceStatus.UP){
                String url = "http://" + instance.getHostName() + ":" + instance.getPort() + "/getHi";

                System.out.println("url:" + url);

                RestTemplate restTemplate = new RestTemplate();
                String respStr = restTemplate.getForObject(url, String.class);
                System.out.println("respStr::" + respStr);
            }
        }
        return "xxoo";
    }

    @GetMapping("getClient5")
    public String getClient5(){
        ServiceInstance instance = lb.choose("provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
        RestTemplate restTemplate = new RestTemplate();
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr::" + respStr);
        return "xxoo";
    }
}
