package com.lingyi.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lingyi")
@MapperScan(basePackages = "com.lingyi.dao")
public class BryantStartServer {

    public static void main(String[] args) {
        SpringApplication.run(BryantStartServer.class, args);
    }

}
