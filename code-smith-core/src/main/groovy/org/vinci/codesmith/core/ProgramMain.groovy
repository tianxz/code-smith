package org.vinci.codesmith.core

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.vinci.codesmith.core.code.BuitInFactory
import org.vinci.codesmith.core.utils.SpringUtil

/**
 * Created by XizeTian on 2016/12/16.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ComponentScan
class ProgramMain implements CommandLineRunner {

    static void main(String... args) {
        SpringApplication.run(ProgramMain.class, args)
    }

    ProgramMain(ApplicationContext context) {
        SpringUtil.context = context
    }

    @Override
    void run(String... args) throws Exception {

    }

    @Bean
    BuitInFactory buitInFactory() {
        return new BuitInFactory()
    }
}