package com.neoteric.mug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MugApplication {

    @SuppressWarnings("squid:S2095")
    public static void main(String[] args) {
        SpringApplication.run(MugApplication.class, args);
    }
}
