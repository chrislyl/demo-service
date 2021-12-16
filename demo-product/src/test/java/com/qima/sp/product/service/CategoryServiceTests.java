package com.qima.sp.product.service;

import com.qima.sp.product.domain.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Yulong
 * @date 2021/12/8 18:05
 */
@Slf4j
@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    CategoryService categoryService;

    @Test
    public void testSelectById() {
        Category category = categoryService.getById(1);
        Assertions.assertNotNull(category);
        log.debug(category.toString());
    }

    @Test
    public void testGetTreeList() {
        List<Category> treeList = categoryService.getTreeList();
        log.debug(treeList.toString());
    }
}
