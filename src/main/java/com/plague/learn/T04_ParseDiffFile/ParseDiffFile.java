package com.plague.learn.T04_ParseDiffFile;


import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Chunk;
import com.github.difflib.patch.Patch;
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
        System.out.println("喵喵patch:");
        List<AbstractDelta<String>> deltas = patch.getDeltas();
        deltas.forEach(delta -> {
            System.out.println(delta.getType());
            switch (delta.getType()) {
                case INSERT:
                    //新增
                    System.out.println("新增");
                    Chunk<String> insert = delta.getTarget();
                    int position = insert.getPosition();
                    System.out.println("+ " + (position + 1) + " " + insert.getLines());
                    break;
                case CHANGE:
                    //修改
                    System.out.println("修改");
                    Chunk<String> source = delta.getSource();
                    Chunk<String> target1 = delta.getTarget();
                    System.out.println("\n- " + (source.getPosition() + 1) + " " + source.getLines() + "\n+ " + "" + (target1.getPosition() + 1) + " " + target1.getLines());
                    break;
                case DELETE:
                    //删除
                    System.out.println("删除");
                    Chunk<String> delete = delta.getSource();
                    System.out.println("- " + (delete.getPosition() + 1) + " " + delete.getLines());
                    break;
                case EQUAL:
                    System.out.println("无变化");
                    break;
            }
        });


        System.out.println("喵喵+-diff:");
        List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("原文件.txt", "对比修改后文件.txt", orgLines, patch, 0);
        for (String diff : unifiedDiff) {
            System.out.println(diff);
        }

        return unifiedDiff.toString();
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

    /**
     * {@link com.plague.learn.T04_ParseDiffFile.ParseDiffFile#FileRead(String,int)}
     */
    private List<String> FileRead(String pathStr, int maxLen) {
        Path path = Paths.get(pathStr);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines.subList(0, maxLen);
        } catch (Exception e) {
            return null;
        }
    }

}
