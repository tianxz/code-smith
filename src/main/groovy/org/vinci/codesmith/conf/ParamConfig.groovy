package org.vinci.codesmith.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by XizeTian on 2016/12/20.
 */
@Configuration
class ParamConfig {
    @Bean
    Properties sysProp() {
        Properties properties = new Properties()
        return properties
    }
}
