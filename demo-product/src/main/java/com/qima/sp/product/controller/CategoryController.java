package com.qima.sp.product.controller;

import com.qima.sp.common.utils.R;
import com.qima.sp.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yulong
 * @date 2021/12/8 17:42
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(categoryService.getById(id));
    }

    @GetMapping("/list/tree")
    public R listTree() {
        return R.ok(categoryService.getTreeList());
    }
}
