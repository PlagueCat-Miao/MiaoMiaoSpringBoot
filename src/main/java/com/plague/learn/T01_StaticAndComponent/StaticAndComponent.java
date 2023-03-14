package com.plague.learn.T01_StaticAndComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问静态数据测试
 */
@RestController
public class StaticAndComponent {

    /**
     * Autowired成员
     */
    @Autowired
    DemoUtil demoUtil;

    /**
     * get接口 访问静态数据测试
     * @return
     */
    @RequestMapping("/StaticAndComponent")
    public String staticAndComponent() {
        String show = demoUtil.show();
        //终端打印
        System.out.println(show);
        //页面返回
        return show;
    }



}

