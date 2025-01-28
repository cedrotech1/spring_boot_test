package com.rabit.rabit;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.rabit.rabit")
public class RabitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabitApplication.class, args);
    }


}
