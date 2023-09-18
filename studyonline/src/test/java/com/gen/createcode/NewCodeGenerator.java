package com.gen.createcode;

import cn.hutool.setting.Setting;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * description: NewCodeGenerator
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-05 00:21
 * version: 1.0
 */


public class NewCodeGenerator {
    @Test
    public void run() {
        String projectRootDir = System.getProperty("user.dir");
        Setting setting = new Setting("gencode.setting");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/amybatisdemo?serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author(setting.get("author"))// 设置作者 baomidou 默认值:作者
                            .enableSwagger() // 开启 swagger 模式 默认值:false
                            .fileOverride() // 覆盖已生成文件 默认值:false
                            .disableOpenDir()//禁止打开输出目录 默认值:true
                            .commentDate("yyyy-MM-dd")// 注释日期
                            .dateType(DateType.ONLY_DATE)//定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录 /opt/baomidou/ 默认值: windows:D:// linux or mac : /tmp
//                            .outputDir("D:\\aaa01\\studyonline\\genterator_code\\java"); // 指定输出目录 /opt/baomidou/ 默认值: windows:D:// linux or mac : /tmp
                    //System.getProperty("user.dir")为你当前模块的绝对路径
                })

                .packageConfig(builder -> {
                    builder.parent(setting.get("packageParent")) // 父包模块名 默认值:com.baomidou
                            .controller("controller")//Controller 包名 默认值:controller
                            .entity("models.entity")//Entity 包名 默认值:entity
                            .service("service")//Service 包名 默认值:service
                            .mapper("mapper")//Mapper 包名 默认值:mapper
                            .xml("mapper.mapping")
                            .moduleName(setting.get("moduleName"));// 设置父包模块名 默认值:无
                            //.pathInfo(Collections.singletonMap(OutputFile.xml,"D:\\aaa01\\studyonline\\genterator_code\\mapper")); // 设置mapperXml生成路径
                    //默认存放在mapper的xml下
                })

                .strategyConfig(builder -> {
//                    builder.addInclude(setting.get("tableName")) // 设置需要生成的表名 可边长参数“user”, “user1”
                    builder.addInclude("t_course") // 设置需要生成的表名 可边长参数“user”, “user1”
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .serviceBuilder()//service策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()// 实体类策略配置
                            .idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
                            .addTableFills(new Column("gmt_create", FieldFill.INSERT)) // 自动填充配置
                            .addTableFills(new Property("gmtModified", FieldFill.INSERT_UPDATE))
                            .enableLombok() //开启lombok
                            .logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()// 属性加上注解说明
                            .controllerBuilder() //controller 策略配置
                            .formatFileName("%sController")
                            .enableRestStyle() // 开启RestController注解
                            .mapperBuilder()// mapper策略配置
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()//@mapper注解开启
                            .formatXmlFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .injectionConfig(consumer -> {
                    Map<String, String> customFile = new HashMap<>();
                    // DTO
//                    customFile.put("Param.java", "/templates/param.java.ftl");
//                    customFile.put("PageParam.java","/templates/pageParam.java.ftl");
//                    customFile.put("VO.java","/templates/vo.java.ftl");
                    // consumer.fileOverride();
                    Map<String,Object> customMap = new HashMap<>();
                    customMap.put("g",setting);
//                    customMap.put("Param.javaFileOverride",setting.get("paramFileOverride"));
//                    customMap.put("PageParam.javaFileOverride",setting.get("pageParamFileOverride"));
//                    customMap.put("VO.javaFileOverride",setting.get("voFileOverride"));
                    consumer.customMap(customMap);
                    consumer.customFile(customFile);
                })
                .execute();

    }
}


