package com.wgj.ribbonconsumer.controller;

import com.wgj.ribbonconsumer.entity.User;
import com.wgj.ribbonconsumer.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("ribbon")
public class ConsumerController {
    @Autowired
    private RestTemplate  restTemplate;

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @Autowired
    private LoadBalancerClient  loadBalancerClient;


    //http://localhost:8765/ribbon/list?p=2&n=10
    @RequestMapping("list")
    public List<User> selectList(Integer p,Integer n){
        //获取负载均衡选择的服务
        ServiceInstance serviceInstance=loadBalancerClient.choose("service1");
        System.out.println("服务端口==================》》》"+serviceInstance.getPort());
        String url="http://service1/user/selectList?p="+p+"&n="+n;
        List<User> list=restTemplate.getForObject(url,List.class);
        return list;
    }

    //http://localhost:8765/ribbon/hystrixList?p=2&n=10
    @RequestMapping("hystrixList")
    public List<User> hystrixList(Integer p,Integer n){
        return  ribbonHystrixService.selectList(p,n);

    }
}
