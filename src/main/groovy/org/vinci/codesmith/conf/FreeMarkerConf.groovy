package org.vinci.codesmith.conf

import freemarker.template.TemplateExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by XizeTian on 2017/3/3.
 */
@Configuration
class FreeMarkerConf {
    @Bean
    freemarker.template.Configuration configuration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23)
        cfg.setClassForTemplateLoading(this.getClass(), "/template")
        cfg.setDefaultEncoding("UTF-8")
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
        cfg.setLogTemplateExceptions(false)
        return cfg
    }
}