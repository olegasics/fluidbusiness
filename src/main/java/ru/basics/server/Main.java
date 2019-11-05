package ru.basics.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication
//@EnableJpaRepositories("ru.basics.database.dao")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
