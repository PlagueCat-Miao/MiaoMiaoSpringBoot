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

@RestController
public class UseGson {

    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    @RequestMapping("/UseGson")
    public String useGson() {
        LinkedHashMap<String,Object> hashMap = new LinkedHashMap<>();
        hashMap.put("1",1);hashMap.put("A","a");
        System.out.println(gson.toJson(hashMap));
        ArrayList<String> arrays = new ArrayList();
        arrays.add("!");arrays.add("@");arrays.add("#");arrays.add("$");
        hashMap.put("arrays",arrays);
        String str = gson.toJson(hashMap);
        System.out.println(str);
        LinkedHashMap<String,Object> obj = gson.fromJson(str,LinkedHashMap.class);
        obj.put("1",2);
        ArrayList<Integer> objArray = new ObjectMapper().convertValue(obj.get("arrays"), ArrayList.class);
        objArray.set(0,4) ;
        obj.put("arrays",objArray);
        return gson.toJson(obj);
    }
}
