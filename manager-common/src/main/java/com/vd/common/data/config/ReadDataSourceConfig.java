package com.vd.common.data.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * erp只读库
 */
@Configuration
@MapperScan(basePackages = {"com.vd.common.data.mapper.read"},
        sqlSessionFactoryRef = "readSqlSessionFactory")
public class ReadDataSourceConfig {

//    @Value("${spring.datasource.read.url}")
//    private String url;
//    @Value("${spring.datasource.read.username}")
//    private String username;
//    @Value("${spring.datasource.read.password}")
//    private String password;
//    @Value("${spring.datasource.read.driverClassName}")
//    private String driverClassName;
//    @Value("${spring.datasource.read.initialSize}")
//    private Integer initialSize;
//    @Value("${spring.datasource.read.minIdle}")
//    private Integer minIdle;
//    @Value("${spring.datasource.read.maxActive}")
//    private Integer maxActive;
//    @Value("${spring.datasource.read.maxWait}")
//    private Integer maxWait;
//    @Value("${spring.datasource.read.timeBetweenEvictionRunsMillis}")
//    private Integer timeBetweenEvictionRunsMillis;
//    @Value("${spring.datasource.read.minEvictableIdleTimeMillis}")
//    private Integer minEvictableIdleTimeMillis;
//    @Value("${spring.datasource.read.validationQuery}")
//    private String validationQuery;
//    @Value("${spring.datasource.read.testWhileIdle}")
//    private boolean testWhileIdle;
//    @Value("${spring.datasource.read.testOnBorrow}")
//    private boolean testOnBorrow;
//    @Value("${spring.datasource.read.testOnReturn}")
//    private boolean testOnReturn;
//    @Value("${spring.datasource.read.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//    @Value("${spring.datasource.read.maxOpenPreparedStatements}")
//    private Integer maxOpenPreparedStatements;
//    @Value("${spring.datasource.read.filters}")
//    private String filters;
//    @Value("${spring.datasource.read.connectionProperties}")
//    private String connectionProperties;

    /**
     * 数据源
     * @return
     * @throws SQLException
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource dataSource()throws SQLException{
        HikariDataSource hikariDataSource = new HikariDataSource();
        Properties properties = new Properties();
        properties.setProperty("cachePrepStmts", "true");
        properties.setProperty("prepStmtCacheSize","250");
        properties.setProperty("prepStmtCacheSqlLimit","2048");
        properties.setProperty("useServerPrepStmts","true");
        hikariDataSource.setDataSourceProperties(properties);

        return hikariDataSource;
    }

    /**
     * sqlSession工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "readSqlSessionFactory")
    public SqlSessionFactory readSqlSessionFactory(
            @Qualifier("readDataSource") DataSource dataSource
    ) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        // 配置分页
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        // 设置插件
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]);

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "readDataSourceTransactionManager")
    public DataSourceTransactionManager readDataSourceTransactionManager(
            @Qualifier("readDataSource") DataSource dataSource
    ){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
