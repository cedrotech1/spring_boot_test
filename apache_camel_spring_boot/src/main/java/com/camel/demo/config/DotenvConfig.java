package com.camel.demo.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvConfig {

    @jakarta.annotation.PostConstruct
    public void loadEnvVariables() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
            System.out.println("Loaded " + entry.getKey() + "=" + entry.getValue());  // Add logging for debugging
        });
    }
}

