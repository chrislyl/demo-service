package com.qima.sp.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chris
 * @date 2021/12/12 21:03
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qima.sp"})
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.qima.sp.payment.mapper"})
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
