package com.icss.codesmith

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by XizeTian on 2016/12/16.
 */
@SpringBootApplication
@EnableAutoConfiguration
class ProgramMain implements CommandLineRunner {
    static void main(String... args) {
        SpringApplication.run(ProgramMain.class, args);
    }

    @Override
    void run(String... args) throws Exception {

    }
}
