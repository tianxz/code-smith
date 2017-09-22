package com.icss.codesmith.conf

import com.alibaba.druid.pool.DruidDataSource
import com.icss.codesmith.jdbc.IcssDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

/**
 * Created by XizeTian on 2016/12/19.
 */
@Configuration
class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return new IcssDataSource();
    }
}
