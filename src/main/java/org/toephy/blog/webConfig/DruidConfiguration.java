package org.toephy.blog.webConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Toephy on 2017.4.5 16:33
 */
@Configuration
public class DruidConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize?:0}")
    private int initialSize;

    @Value("${spring.datasource.minIdle?:0}")
    private int minIdle;

    @Value("${spring.datasource.maxActive?:8}")
    private int maxActive;

    @Value("${spring.datasource.maxWait?:-1}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis?:30000}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis?:1800000}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery:#{null}}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle?:#{false}}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow?:#{false}}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn?:#{false}}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements?:#{false}}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize?:10}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters?:#{null}}")
    private String filters;

    @Value("${spring.datasource.connectionProperties?:#{null}}")
    private String connectionProperties;

    @Value("${spring.datasource.useGlobalDataSourceStat?:#{false}}")
    private boolean useGlobalDataSourceStat;

    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource druidDataSource() {
        System.out.println("=======================================");
        System.out.println("init druidDataSource...");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            System.out.println("druid configuration initialization filter");
        }
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        System.out.println("=======================================");
        return dataSource;
    }

}
