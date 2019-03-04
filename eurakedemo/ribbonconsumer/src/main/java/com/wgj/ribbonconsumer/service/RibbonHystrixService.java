package com.wgj.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wgj.ribbonconsumer.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "selectListFC")
    public List<User> selectList(Integer p, Integer n){
        String url="http://service1/user/selectList?p="+p+"&n="+n;
        List<User> list=restTemplate.getForObject(url,List.class);
        return list;
    }


    public List<User> selectListFC(Integer p, Integer n){
        log.info("发生异常，进入回调方法");
        String url="http://service1/user/selectList?p="+p+"&n="+n;
        List<User> list=restTemplate.getForObject(url,List.class);
        return list;
    }
 }
