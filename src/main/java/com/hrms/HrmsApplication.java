package com.hrms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);

    }

    //ModelMapper Data Transfer Object'i Entity türüne çevirmek için.
    //
    @Bean
    public ModelMapper modelMapper() {
       ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;

    }
    //Swagger
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hrms"))
//                .build();
//    }


}
