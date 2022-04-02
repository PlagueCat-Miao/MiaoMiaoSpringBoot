package com.plague.learn.T01_StaticAndComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticAndComponent {

    @Autowired
    DemoUtil demoUtil;

    @RequestMapping("/StaticAndComponent")
    public String staticAndComponent() {
        String show = demoUtil.show();


        System.out.println(show);
        return show;
    }



}

