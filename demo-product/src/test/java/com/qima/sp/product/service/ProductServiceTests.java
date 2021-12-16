package com.qima.sp.product.service;

import com.qima.sp.product.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Chris
 * @date 2021/12/13 15:14
 */
@Slf4j
@SpringBootTest
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void testGetByOrderId() {
        List<Product> products = productService.getByOrderId(1L);
        products.forEach(p -> log.debug(p.toString()));
    }
}
