package com.edutech.progressive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class BankSafeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BankSafeApplication.class)
                .web(WebApplicationType.NONE)   // ✅ IMPORTANT
                .run(args);

        System.out.println("Welcome to BankSafe Project!");
    }
}