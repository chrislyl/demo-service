package com.qima.sp.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Chris
 * @date 2021/12/13 15:09
 */
@Slf4j
@SpringBootTest
public class ProductAttributeMapperTests {

    @Autowired
    ProductAttributeMapper productAttributeMapper;

    @Test
    public void testSelectList() {
        productAttributeMapper.selectList(null).forEach(pa -> log.debug(pa.toString()));
    }
}
