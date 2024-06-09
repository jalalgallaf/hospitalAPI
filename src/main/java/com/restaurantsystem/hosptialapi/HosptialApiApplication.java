package com.restaurantsystem.hosptialapi;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication()

public class HosptialApiApplication {


    public static void main(String[] args) {

        SpringApplication.run(HosptialApiApplication.class, args);
    }



}
