package com.qima.sp.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chris
 * @date 2021/12/12 20:06
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.qima.sp"})
public class InvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
    }
}
