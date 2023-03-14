package com.plague.learn.T01_StaticAndComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Autowired 成员
 */
@Component
public class DemoUtil {
    /**
     * 静态 Autowired 成员
     */
    @Autowired
    static OtherUtil otherUtil;

    /**
     * 静态 String 成员
     */
    public static String demoString = "参数";

    /**
     * 静态访问方法
     */
    public static String show() {

        return "OtherUtil" + otherUtil.getGson().toJson(new DemoVO());
    }
}

/**
 * 数据类
 */
class DemoVO {
    /**
     * 姓名
     */
    String name = "DemoVO";
    /**
     * 岁数
     */
    int age = 4;
}
