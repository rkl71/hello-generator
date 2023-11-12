package com.hanyang.generator;

import com.hanyang.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("jiusi");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerator(mainTemplateConfig);
    }


    public static void doGenerator(Object model) throws TemplateException, IOException {

        // 1. 静态文件生成
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "hello-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 2. 生成动态文件
        String dynamicInputPath = projectPath + File.separator + "hello-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/hanyang/acm/MainTemplate.java";
        DynamicGenerator.doGenerator(dynamicInputPath, dynamicOutputPath, model);
    }
}
