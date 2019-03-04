package com.wgj.feignconsumer.fallback;

import com.wgj.feignconsumer.client.UserClient;
import com.wgj.feignconsumer.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Slf4j
public class FeignHystrixService implements UserClient {
    @Override
    public List<User> selectList(Integer p, Integer n) {
        log.info("异常进入回调");
        List<User> list=new ArrayList<User>();
        User user=new User();
        user.setEmail("abc@ee");
        user.setId(0);
        user.setPassword("111111");
        list.add(user);
        return list;
    }
}
