package com.qima.sp.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.product.domain.Category;
import com.qima.sp.product.mapper.CategoryMapper;
import com.qima.sp.product.service.CategoryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yulong
 * @date 2021/12/8 17:40
 */
@Service
@CacheConfig(cacheNames = "category", cacheManager = "caffeineCacheManager")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Cacheable(key = "#id")
    @Override
    public Category getById(Serializable id) {
        return super.getById(id);
    }

    public List<Category> getTreeList() {
        // TODO: Task 2
        return List.of();
    }
}
