package com.plague.learn.T01_StaticAndComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoUtil {

    @Autowired
    static OtherUtil otherUtil;

    public static String demoString = "参数";
    public static String show() {

        return "OtherUtil"+otherUtil.getGson().toJson(new DemoVO());
    }
}
class DemoVO
{
    String name = "DemoVO";
    int age = 4;
}
