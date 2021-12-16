package com.qima.sp.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Yulong
 * @date 2021/12/8 17:34
 */
@EnableCaching
@MapperScan("com.qima.sp.product.mapper")
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.qima.sp"})
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
