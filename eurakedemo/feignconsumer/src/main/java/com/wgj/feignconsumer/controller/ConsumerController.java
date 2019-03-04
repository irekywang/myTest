package com.wgj.feignconsumer.controller;

import com.wgj.feignconsumer.client.UserClient;
import com.wgj.feignconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feign")
public class ConsumerController {
    @Autowired
    private UserClient userClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //http://localhost:8764/feign/list?p=2&n=10
    @RequestMapping("/list")
    public List<User> getList(Integer p, Integer n){
        //获取负载均衡选择的服务
        ServiceInstance serviceInstance=loadBalancerClient.choose("service1");
        System.out.println("服务端口==================》》》"+serviceInstance.getPort());
        return userClient.selectList(p,n);
    }
}
