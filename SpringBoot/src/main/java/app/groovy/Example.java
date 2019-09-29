package app.groovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Example {

    public static void main(String[] args) {

        SpringApplication.run(Example.class, args);
    }
}
