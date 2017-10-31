package org.vinci.codesmith.core

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.vinci.codesmith.core.code.BuitInFactory
import org.vinci.codesmith.core.utils.SpringUtil

/**
 * Created by XizeTian on 2016/12/16.
 */
@SpringBootApplication
@EnableAutoConfiguration
class ProgramMain implements CommandLineRunner {
    ProgramMain(ApplicationContext context) {
        SpringUtil.context = context
    }

    static void main(String... args) {
        SpringApplication.run(ProgramMain.class, args)
    }

    @Override
    void run(String... args) throws Exception {

    }

    @Bean
    BuitInFactory buitInFactory() {
        return new BuitInFactory()
    }
}