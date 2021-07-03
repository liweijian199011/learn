package com.jack.learn;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * <p>
 *      代码生成器配置信息
 * </p>
 *
 * @author jack
 * @since 2021/7/3 下午6:55
 */
public class GeneratorConfig {

    /**
     * 以下五项是datasource的连接信息
     */
    public static final String DATASOURCE_URL = "jdbc:mysql://localhost/test";

    public static final String DATASOURCE_USERNAME = "root";

    public static final String DATASOURCE_PASSWORD = "root";

    public static final String DATASOURCE_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final DbType DB_TYPE = DbType.MYSQL;

    /**
     * 生成类的作者
     */
    public static final String AUTHOR = "jack";

    /**
     * 需要生成代码的库表的列表
     */
    public static final String[] TABLE_LIST = {"User"};

    /**
     * 以下几项是包的路径信息，其中后面几项的路径是相对于parent路径的相对路径
     */
    public static final String PARENT_PACKAGE = "com.jack.learn";

    public static final String CONTROLLER_PACKAGE = "controller";

    public static final String SERVICE_PACKAGE = "service";

    public static final String SERVICE_IMPL_PACKAGE = "service.impl";

    public static final String MAPPER_PACKAGE = "dao.mapper";

    public static final String DOMAIN_PACKAGE = "dao.domain";

    /**
     * mapper xml目录的绝对路径
     */
    public static final String MAPPER_XML_PATH = "/Users/jack/IdeaProjects/learn/src/main/resources/mapper";

    /**
     * 生成mapper xml文件模板的相对路径
     */
    public static final String MAPPER_XML_TEMPLATE_PATH = "/templates/myMapper.xml.vm";


    /**
     * mapper目录的绝对路径
     */
    public static final String MAPPER_PATH = "/Users/jack/IdeaProjects/learn/src/main/java/com/jack/learn/dao/mapper";

    /**
     * 生成mapper文件模板的相对路径
     */
    public static final String MAPPER_TEMPLATE_PATH = "/templates/myMapper.java.vm";
}
