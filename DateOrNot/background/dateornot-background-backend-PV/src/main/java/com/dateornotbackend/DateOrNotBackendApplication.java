package com.dateornotbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.dateornotbackend.mapper"})
public class DateOrNotBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DateOrNotBackendApplication.class, args);
    }

}
