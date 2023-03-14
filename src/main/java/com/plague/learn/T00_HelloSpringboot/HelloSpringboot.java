package com.plague.learn.T00_HelloSpringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打印接口
 */
@RestController
public class HelloSpringboot {

    /**
     * get接口 打印hello
     * @return
     */
    @RequestMapping("/hello")
    public String say() {
        //终端打印
        System.out.println("Hello springboot");
        //页面返回
        return "hello,this is a springboot demo！~";
    }

    /**
     * get接口 登录
     * @param username 输入用户名
     * @param password 输入密码
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
        String result= "username:"+username+",password:"+password;
        //终端打印
        System.out.println(result);
        //页面返回
        return(result);
    }

}

