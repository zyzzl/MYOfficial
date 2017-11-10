package official.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
@Slf4j
public class MybatisConfig implements TransactionManagementConfigurer {

    @Autowired
    private DruidDBConfig druidDBConfig;

    @Autowired
    DataSource dataSource;

    /**
     * 声明其为Bean实例
     * 在同样的DataSource中，首先使用被标注的DataSource
     */
    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidDBConfig.getUrl());
        datasource.setUsername(druidDBConfig.getUsername());
        datasource.setPassword(druidDBConfig.getPassword());
        datasource.setDriverClassName(druidDBConfig.getDriverClassName());

        // configuration
        datasource.setInitialSize(druidDBConfig.getInitialSize());
        datasource.setMinIdle(druidDBConfig.getMinIdle());
        datasource.setMaxActive(druidDBConfig.getMaxActive());
        datasource.setMaxWait(druidDBConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidDBConfig
                .getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidDBConfig
                .getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidDBConfig.getValidationQuery());
        datasource.setTestWhileIdle(druidDBConfig.isTestWhileIdle());
        datasource.setTestOnBorrow(druidDBConfig.isTestOnBorrow());
        datasource.setTestOnReturn(druidDBConfig.isTestOnReturn());
        datasource.setPoolPreparedStatements(druidDBConfig
                .isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(druidDBConfig
                .getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(druidDBConfig.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(druidDBConfig
                .getConnectionProperties());

        return datasource;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        log.debug("> transactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("jdbc.settings={}", druidDBConfig);
    }

}