package com.hadoop.hbase.etl_1.constants;

/**
 * 全局常量
 * 
 * @author
 *
 */
public class GlobalConstants {
    /**
     * 天的毫秒
     */
    public static final int DAY_OF_MILLISECONDS = 86400000;
    /**
     * 定义的运行时间变量名
     */
    public static final String RUNNING_DATE_PARAMES = "RUNNING_DATE";
    public static final String RUNNING_EVENT_PARAMES = "RUNNING_EVENT";
    /**
     * 默认
     */
    public static final String DEFAULT_VALUE = "unknown";
    /**
     * 维度信息表中指定全部�?
     */
    public static final String VALUE_OF_ALL = "all";

    /**
     * 定义的output collector的前�?
     */
    public static final String OUTPUT_COLLECTOR_KEY_PREFIX = "collector_";

    /**
     * 指定连接表配置为report
     */
    public static final String WAREHOUSE_OF_REPORT = "report";

    /**
     * 批量执行的key
     */
    public static final String JDBC_BATCH_NUMBER = "mysql.batch.number";

    /**
     * 默认批量大小
     */
    public static final String DEFAULT_JDBC_BATCH_NUMBER = "500";

    /**
     * driver 名称
     */
    public static final String JDBC_DRIVER = "mysql.%s.driver";

    /**
     * JDBC URL
     */
    public static final String JDBC_URL = "mysql.%s.url";

    /**
     * username名称
     */
    public static final String JDBC_USERNAME = "mysql.%s.username";

    /**
     * password名称
     */
    public static final String JDBC_PASSWORD = "mysql.%s.password";

}
