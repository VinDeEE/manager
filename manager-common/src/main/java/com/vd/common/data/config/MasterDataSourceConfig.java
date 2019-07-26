package com.vd.common.data.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * erp主库
 */
@Configuration
@MapperScan(basePackages = { "com.vd.common.data.mapper.master" }, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

	// @Value("${spring.datasource.master.url}")
	// private String url;
	// @Value("${spring.datasource.master.username}")
	// private String username;
	// @Value("${spring.datasource.master.password}")
	// private String password;
	// @Value("${spring.datasource.master.driverClassName}")
	// private String driverClassName;
	// @Value("${spring.datasource.master.initialSize}")
	// private Integer initialSize;
	// @Value("${spring.datasource.master.minIdle}")
	// private Integer minIdle;
	// @Value("${spring.datasource.master.maxActive}")
	// private Integer maxActive;
	// @Value("${spring.datasource.master.maxWait}")
	// private Integer maxWait;
	// @Value("${spring.datasource.master.timeBetweenEvictionRunsMillis}")
	// private Integer timeBetweenEvictionRunsMillis;
	// @Value("${spring.datasource.master.minEvictableIdleTimeMillis}")
	// private Integer minEvictableIdleTimeMillis;
	// @Value("${spring.datasource.master.validationQuery}")
	// private String validationQuery;
	// @Value("${spring.datasource.master.testWhileIdle}")
	// private boolean testWhileIdle;
	// @Value("${spring.datasource.master.testOnBorrow}")
	// private boolean testOnBorrow;
	// @Value("${spring.datasource.master.testOnReturn}")
	// private boolean testOnReturn;
	// @Value("${spring.datasource.master.poolPreparedStatements}")
	// private boolean poolPreparedStatements;
	// @Value("${spring.datasource.master.maxOpenPreparedStatements}")
	// private Integer maxOpenPreparedStatements;
	// @Value("${spring.datasource.master.filters}")
	// private String filters;
	// @Value("${spring.datasource.master.connectionProperties}")
	// private String connectionProperties;

	/**
	 * 数据源
	 *
	 * @return
	 * @throws SQLException
	 */
	@Bean(name = "masterDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource dataSource() throws SQLException {
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
	 *
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));

		// // 配置分页
		// PageHelper pageHelper = new PageHelper();
		// Properties properties = new Properties();
		// properties.setProperty("reasonable", "true");
		// properties.setProperty("supportMethodsArguments", "true");
		// properties.setProperty("returnPageInfo", "check");
		// properties.setProperty("params", "count=countSql");
		// pageHelper.setProperties(properties);
		//
		// // 设置插件
		// sqlSessionFactoryBean.setPlugins(new Interceptor[]);

		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 事务管理
	 *
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "masterDataSourceTransactionManager")
	@Primary
	public DataSourceTransactionManager masterDataSourceTransactionManager(
			@Qualifier("masterDataSource") DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

}
