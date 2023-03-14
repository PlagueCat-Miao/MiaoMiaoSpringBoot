package com.plague.learn.T01_StaticAndComponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

/**
 * 静态 Autowired 成员
 */
@Component
public class OtherUtil {

    /**
     * 静态 String 成员
     */
    private static String otherString = "另外参数";

    /**
     * 静态 String 成员
     */
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    /**
     *  静态访问方法
     * @return
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     *  静态访问方法
     * @return
     */
    public static String show() {
        OtherVO vo= new OtherVO();
        return "另外方法"+gson.toJson(vo);
    }

}

/**
 * 数据类
 */
class OtherVO
{
    /**
     * 姓名
     */
    String name = "OtherVO";
    /**
     * 岁数
     */
    int age = 16;
}
