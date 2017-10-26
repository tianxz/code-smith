package org.vinci.codesmith.core.conf

import org.apache.velocity.app.Velocity
import org.apache.velocity.app.VelocityEngine
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by XizeTian on 2017/10/25.
 */
@Configuration
class VelocityConfig {
    @Bean
    VelocityEngine velocityEngine() {
        Velocity.setProperty(Velocity.INPUT_ENCODING, "UTF-8")
        Velocity.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8")

        VelocityEngine ve = new VelocityEngine()
        ve.setProperty("resource.loader", "class")
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader")
        ve.init()

        return ve
    }
}
