package org.vinci.codesmith.core.conf

import org.vinci.codesmith.core.jdbc.VinciDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

/**
 * Created by XizeTian on 2016/12/19.
 */
@Configuration
class DataSourceConfig {
    @Bean
    DataSource dataSource() {
        return new VinciDataSource();
    }
}
