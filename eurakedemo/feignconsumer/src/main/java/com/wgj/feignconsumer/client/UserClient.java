package com.wgj.feignconsumer.client;

import com.wgj.feignconsumer.entity.User;
import com.wgj.feignconsumer.fallback.FeignHystrixService;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 外部接口
 */
@FeignClient(name="service1",fallback = FeignHystrixService.class)
public interface UserClient {

    @RequestMapping("/user/selectList")
    List<User> selectList(@RequestParam(value = "p") Integer p,
                          @RequestParam(value = "n") Integer n);
}
