package org.vinci.codesmith.conf

import org.vinci.codesmith.template.engine.impl.FreemarkerEngine
import org.vinci.codesmith.template.engine.impl.VelocityEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

/**
 * Created by XizeTian on 2017/10/25.
 */
@Configuration
class TemplateEngineConfig {
    @Bean
    @Primary
    FreemarkerEngine freemarkerEngine() {
        return new FreemarkerEngine()
    }

    @Bean
    VelocityEngine velocityEngine() {
        return new VelocityEngine()
    }
}
