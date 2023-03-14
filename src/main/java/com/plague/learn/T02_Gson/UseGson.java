package com.plague.learn.T02_Gson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 测试Gson
 */
@RestController
public class UseGson {

    /**
     * 获取Gson
     */
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    /**
     * 测试Gson处理LinkedHashMap
     * @return
     */
    @RequestMapping("/UseGson")
    public String useGson() {
        //创建测试map
        LinkedHashMap<String,Object> hashMap = new LinkedHashMap<>();
        hashMap.put("1",1);hashMap.put("A","a");
        //终端打印
        System.out.println(gson.toJson(hashMap));
        ArrayList<String> arrays = new ArrayList();
        arrays.add("!");arrays.add("@");arrays.add("#");arrays.add("$");
        hashMap.put("arrays",arrays);
        //json序列化
        String str = gson.toJson(hashMap);
        System.out.println(str);
        LinkedHashMap<String,Object> obj = gson.fromJson(str,LinkedHashMap.class);
        obj.put("1",2);
        //json反序列化
        ArrayList<Integer> objArray = new ObjectMapper().convertValue(obj.get("arrays"), ArrayList.class);
        objArray.set(0,4) ;
        obj.put("arrays",objArray);
        //页面返回
        return gson.toJson(obj);
    }
}
