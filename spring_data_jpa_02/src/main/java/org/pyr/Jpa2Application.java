package org.pyr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.pyr.repositories")
public class Jpa2Application {
    public static void main(String[] args) {
        SpringApplication.run(Jpa2Application.class, args);
    }
}
