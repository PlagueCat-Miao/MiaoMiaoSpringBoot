package com.plague.learn.T01_StaticAndComponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class OtherUtil {
    private static String otherString = "另外参数";

    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    public static Gson getGson() {
        return gson;
    }
    public static String show() {
        OtherVO vo= new OtherVO();
        return "另外方法"+gson.toJson(vo);
    }

}
class OtherVO
{
    String name = "OtherVO";
    int age = 16;
}
