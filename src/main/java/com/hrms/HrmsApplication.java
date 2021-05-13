package com.hrms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);

    }
    //ModelMapper Data Transfer Object'i Entity türüne çevirmek için.
    @Bean
    public ModelMapper modelMapper(){
    return new ModelMapper();
    }



}
