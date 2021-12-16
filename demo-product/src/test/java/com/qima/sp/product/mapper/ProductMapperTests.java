package com.qima.sp.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Chris
 * @date 2021/12/13 15:07
 */
@Slf4j
@SpringBootTest
public class ProductMapperTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void testSelectList() {
        productMapper.selectList(null).forEach(p -> log.debug(p.toString()));
    }
}
