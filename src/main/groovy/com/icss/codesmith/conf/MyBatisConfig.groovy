package com.icss.codesmith.conf

import org.apache.ibatis.session.Configuration as MybatisConfiguration
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

/**
 * Created by XizeTian on 2016/12/16.
 */
@Configuration
public class MyBatisConfig {
    @Autowired
    ConfigurableApplicationContext ctx;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.mapUnderscoreToCamelCase = true

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.configuration = configuration
        sqlSessionFactoryBean.dataSource = dataSource

        return sqlSessionFactoryBean.getObject()
    }
}
