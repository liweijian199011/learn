package com.jack.learn;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MpGeneratorUtil {

    @Test
    public void generator() {

        // 数据源配置
        DataSourceConfig dataSourceConfig = datasourceConfig();

        // 代码生成全局配置
        GlobalConfig globalConfig = getGlobalConfig();

        // 策略配置
        StrategyConfig strategy = strategyConfig();

        // 包配置
        PackageConfig packageConfig = packageConfig();

        // 自定义配置
        InjectionConfig injectionConfig = injectionConfig();

        //设置模版
        TemplateConfig templateConfig = new TemplateConfig()
            .setMapper(GeneratorConfig.MAPPER_TEMPLATE_PATH)
//        tc.setService(Config.SERVICE_TEMPLATE);
//        tc.setServiceImpl(Config.SERVICE_IMPL_TEMPLATE);
//        tc.setController(Config.CONTROLLER_TEMPLATE);
//        tc.setEntity(Config.ENTITY_TEMPLATE);
            //已自定义xml模版以及输出路径，故这里写null,不然默认会在mapper目录下生成一个xml
            .setXml(null);

        AutoGenerator mpg = new AutoGenerator();
        mpg.setDataSource(dataSourceConfig)
                .setGlobalConfig(globalConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategy)
                .setCfg(injectionConfig)
                .setTemplate(templateConfig)
                .execute();
    }


    /**
     * 数据源配置
     *
     * @return 数据源配置信息
     */
    private static DataSourceConfig datasourceConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriverName(GeneratorConfig.DATASOURCE_DRIVER)
                .setUrl(GeneratorConfig.DATASOURCE_URL)
                .setDbType(GeneratorConfig.DB_TYPE)
                .setUsername(GeneratorConfig.DATASOURCE_USERNAME)
                .setPassword(GeneratorConfig.DATASOURCE_PASSWORD);
        return config;
    }

    /**
     * 生成代码全局配置
     *
     * @return 全局配置
     */
    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 测试下运行获取的路径是模块下的位置，所以需要加../
        File file = new File("");
        gc.setOutputDir(file.getAbsolutePath() + "/src/main/java")
                .setFileOverride(true)
                .setActiveRecord(true)
                .setAuthor(GeneratorConfig.AUTHOR)
                .setEntityName("%sDO")
                .setMapperName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setSwagger2(true);
        return gc;
    }

    /**
     * 策略配置对象
     *
     * @return StrategyConfig
     */
    private static StrategyConfig strategyConfig() {

        return new StrategyConfig()
                // 全局大写命名
                .setCapitalMode(true)
                // 不跳过视图
                .setSkipView(false)
                //.setDbColumnUnderline(true)
                // 表名生成策略，使用驼峰格式
                .setNaming(NamingStrategy.underline_to_camel)
                // 字段名使用驼峰格式
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 要生成对象的库表列表，使用数组
                .setInclude(GeneratorConfig.TABLE_LIST)
                // 排除生成的表
                //.setExclude(new String[]{"test"})
                // entity支持lombok注解
                .setEntityLombokModel(true)
                // 实体类上面添加lombok @Accessor注解进行builder模式
                .setChainModel(true)
                // entity是否生成字段常量（默认 false 可通过常量名获取数据库字段名  3.x支持lambda表达式
                .setEntityColumnConstant(false)
                // 逻辑删除属性名称
//                .setLogicDeleteFieldName("")
                // 表的自动填充字段
//                .setTableFillList(tableFills)
                // 是否为RestController
                .setRestControllerStyle(true)
                // 将库表字段中的注释生成属性注释
                .setEntityTableFieldAnnotationEnable(true)
                // 将库表中带有is的字段名将is去掉
                .setEntityBooleanColumnRemoveIsPrefix(true)
                ;
    }

    /**
     * 包配置对象
     *
     * @return PackageConfig
     */
    private static PackageConfig packageConfig() {
        return new PackageConfig()
                .setParent(GeneratorConfig.PARENT_PACKAGE)
                .setController(GeneratorConfig.CONTROLLER_PACKAGE)
                .setEntity(GeneratorConfig.DOMAIN_PACKAGE)
                .setMapper(GeneratorConfig.MAPPER_PACKAGE)
                .setService(GeneratorConfig.SERVICE_PACKAGE)
                .setServiceImpl(GeneratorConfig.SERVICE_IMPL_PACKAGE)
                ;
    }

    /**
     * 自定义配置对象
     *
     * @return InjectionConfig
     */
    private static InjectionConfig injectionConfig() {
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 模板生成mapper xml的配置
        if (StringUtils.isNotBlank(GeneratorConfig.MAPPER_XML_PATH) || StringUtils.isNotBlank(GeneratorConfig.MAPPER_XML_TEMPLATE_PATH)) {
            // 自定义xml配置
            fileOutConfigList.add(new FileOutConfig(GeneratorConfig.MAPPER_XML_TEMPLATE_PATH) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return GeneratorConfig.MAPPER_XML_PATH + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            });
        }

        // 模板生成mapper类的配置
        if (StringUtils.isNotBlank(GeneratorConfig.MAPPER_PATH) || StringUtils.isNotBlank(GeneratorConfig.MAPPER_TEMPLATE_PATH)) {
            // 自定义xml配置
            fileOutConfigList.add(new FileOutConfig(GeneratorConfig.MAPPER_TEMPLATE_PATH) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return GeneratorConfig.MAPPER_PATH + "/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
                }
            });
        }

        // 注入自定义配置参数，在模板文件中可以使用这些变量
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                // map中可以添加自定义的配置参数
                map.put("domainPackage", GeneratorConfig.PARENT_PACKAGE + "." + GeneratorConfig.DOMAIN_PACKAGE);
                this.setMap(map);
            }
        };
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
    }
}
