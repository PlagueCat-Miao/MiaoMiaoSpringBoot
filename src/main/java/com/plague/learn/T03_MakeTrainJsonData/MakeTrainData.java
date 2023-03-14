package com.plague.learn.T03_MakeTrainJsonData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MakeTrainData {

    /**
     * 获取Gson
     */
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    @RequestMapping("/makeTrain")
    public String makeTrain() {
        //获取文件夹下文件
        List<Path> javaFileNames = null;
        try (Stream<Path> paths = Files.walk(Paths.get(workPath))) {
            List<Path> fileNames = paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (Path path : fileNames) {
                if (path.endsWith(".java")) {
                    javaFileNames.add(path);
                }
            }
        } catch (IOException e) {
            return "转换失败" + e.getMessage();
        }

        //训练文件路径
        String trainDataFile = workPath + "train.json";
        for (Path path : javaFileNames) {
            String text = FileRead(path);
            LinkedHashMap trainDataMap = new LinkedHashMap<>();
            trainDataMap.put("code", text);
            //json序列化
            String trainDataJsonStr = gson.toJson(trainDataMap);
            // 文件内容扩张append
            FileAppend(trainDataFile, trainDataJsonStr);
        }
        return "转换成功";
    }

    /**
     * 文件内容扩张 append
     *
     * @param path 文件路径
     * @param text 文件内容
     */
    private void FileAppend(String path, String text) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(text + "\r\n");
            writer.close();
        } catch (Exception e) {
            return;
        }

    }

    /**
     * 获取文件内容 read
     *
     * @param path 文件路径
     */
    private String FileRead(Path path) {
        String text = "";
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                text += line;
            }
        } catch (Exception e) {
            return text;
        }
        return text;
    }
}
