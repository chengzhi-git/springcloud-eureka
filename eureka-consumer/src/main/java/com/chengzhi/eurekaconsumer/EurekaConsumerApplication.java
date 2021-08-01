package com.chengzhi.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    //http请求优点：1.平台无关2.可插拔3.无状态，dubbo有状态，解决网络不可靠4.性能上来说，dubbo高得多，提高可用性，AP，牺牲一致性C
    //springcloud解决了网络不可靠（eureka网络抖动，仍让保留节点）
    RestTemplate getRestTemplet() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule() {
//        //return new RetryRule();
//        return new RandomRule();
//    }
}
