package com.haromnycloud.generate;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Usage: 代码生成工具 todo 更多动态配置或者读取配置文件
 * @Author: gjq
 * @Date: 2019/3/21 4:35 PM
 */
public class CodeGenerate {

    public static void main(String[] args) {
        GenerateConfig generateConfig = new GenerateConfig()
                .setAuthor(scanner("author"))
                .setProjectName(scanner("项目名"))
                .setOnly_entity_flag("1".equals(scanner("是否只生成实体，1只生成实体")))
                .setTableName(scanner("表名").split(","));
        generate(generateConfig);
    }

    /**
     * 代码生成具体逻辑
     *
     * @param config
     */
    public static void generate(GenerateConfig config) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/" + config.projectName;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(config.author);
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(config.jdbcUrl);
//        dsc.setSchemaName("");
        dsc.setDriverName(config.driverName);
        dsc.setUsername(config.username);
        dsc.setPassword(config.password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(config.moduleName);
        pc.setParent(config.basePackage+"."+config.projectName);
        pc.setEntity("adapter.outbound.database.entity");
        pc.setMapper("adapter.outbound.database.mapper");
        pc.setService("domain.service");
        pc.setServiceImpl("domain.service.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>(2);
//        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/java/" + "com/harmonycloud/"+config.projectName+"/adapter/outbound/database/dataobject/"
//                        + tableInfo.getEntityName()  + StringPool.DOT_JAVA;
//            }
//        });
//        // mapper
//        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/java/" + BASE_PACKAGE_PATH + pc.getModuleName()
//                        + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
//            }
//        });
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        if (config.only_entity_flag) {
            templateConfig.setService(null);
            templateConfig.setMapper(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setXml(null);
        }
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setInclude(config.tableName);
        strategy.setEntityBuilderModel(true);
        // 排除通用字段
//        strategy.setSuperEntityColumns("id", "is_deleted", "gmt_create", "creator", "gmt_modified", "modifier"
//                                        ,"ID", "IS_DELETED", "GMT_CREATE", "CREATOR", "GMT_MODIFIED", "MODIFIER");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 读取控制台输入内容
     *
     * @param tip 提示
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}

class GenerateConfig {
    String author;
    String projectName;
    String moduleName;
    String[] tableName;
    // 仅更新实体
    boolean only_entity_flag;
    String basePackage = "com.harmonycloud";
    String username = "USERROLE";
    String password = "USERROLE";
    String driverName = "oracle.jdbc.OracleDriver";
    String jdbcUrl = "jdbc:oracle:thin:@10.1.10.131:30089:XE";

    public GenerateConfig setAuthor(String author) {
        this.author = author;
        return this;
    }

    public GenerateConfig setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public GenerateConfig setTableName(String[] tableName) {
        this.tableName = tableName;
        return this;
    }

    public GenerateConfig setBasePackage(String basePackage) {
        this.basePackage = basePackage;
        return this;
    }

    public GenerateConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public GenerateConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public GenerateConfig setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public GenerateConfig setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        return this;
    }

    public GenerateConfig setOnly_entity_flag(boolean only_entity_flag) {
        this.only_entity_flag = only_entity_flag;
        return this;
    }

    public GenerateConfig setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }
}