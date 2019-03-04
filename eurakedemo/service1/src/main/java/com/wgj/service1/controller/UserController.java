package com.wgj.service1.controller;

import com.github.pagehelper.PageHelper;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.wgj.service1.entity.User;
import com.wgj.service1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2018-12-27 16:21:54
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("selectList")
    public List<User> selectList(Integer p, Integer n) {
        PageHelper.startPage(p,n);
        List<User> list=userService.selectList();
        log.info("请求成功");
        return list;
    }

    @GetMapping("getUrl")
    public Integer  getUrl(HttpServletRequest req, HttpServletResponse res) {
        int port=req.getLocalPort();
        return port;
    }



}