package com.qima.sp.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qima.sp.product.domain.Category;

import java.util.List;

/**
 * @author Yulong
 * @date 2021/12/8 17:40
 */
public interface CategoryService extends IService<Category> {

    List<Category> getTreeList();
}
