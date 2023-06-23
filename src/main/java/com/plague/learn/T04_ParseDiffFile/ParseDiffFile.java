package com.plague.learn.T04_ParseDiffFile;

import org.assertj.core.util.diff.DiffUtils;
import org.assertj.core.util.diff.Patch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ParseDiffFile {


    /**
     * java项目目标路径
     */

    private static String originalFilePath = "F:\\codeworkbase\\java\\github.com\\PlagueCat-Miao\\MiaoMiaoSpringBoot\\src\\main\\java\\com\\plague\\learn\\T04_ParseDiffFile\\testo.txt";
    private static String revisedFilePath = "F:\\codeworkbase\\java\\github.com\\PlagueCat-Miao\\MiaoMiaoSpringBoot\\src\\main\\java\\com\\plague\\learn\\T04_ParseDiffFile\\testr.txt";

    @RequestMapping("/parseDiff")
    public String makeTrain() {

        List<String> orgLines = FileRead(originalFilePath);
        List<String> revLines = FileRead(revisedFilePath);

        Patch<String> patch = DiffUtils.diff(orgLines, revLines);
        System.out.println(patch);

        return patch.toString();
    }

    /**
     * 获取文件内容 read
     *
     * @param pathStr 文件路径
     */
    private List<String> FileRead(String pathStr) {
        Path path = Paths.get(pathStr);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (Exception e) {
            return null;
        }
    }


}
