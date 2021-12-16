package com.qima.sp.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chris
 * @date 2021/12/11 1:51
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qima.sp"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.qima.sp.order.feign")
@MapperScan("com.qima.sp.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
