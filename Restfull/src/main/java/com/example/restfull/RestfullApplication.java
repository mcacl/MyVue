package com.example.restfull;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan(value = "com.example.restfull.dao")
@SpringBootApplication
public class RestfullApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RestfullApplication.class, args);
    }
}
