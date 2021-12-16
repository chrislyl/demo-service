package com.qima.sp.product.mapper;

import com.qima.sp.product.domain.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Yulong
 * @date 2021/12/8 18:05
 */
@Slf4j
@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void testSelectById() {
        Category category = categoryMapper.selectById(1);
        Assertions.assertNotNull(category);
        log.debug(category.toString());
    }
}
