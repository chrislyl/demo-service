package com.qima.sp.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.product.domain.Category;
import com.qima.sp.product.mapper.CategoryMapper;
import com.qima.sp.product.service.CategoryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    /**
     * Task 2:
     * <ol>
     * <li>test the usage of recursive</li>
     * <li>Using lambda expression and stream proficiently</li>
     * </ol>
     */
    public List<Category> getTreeList() {
        // TODO: Task 2
        // query all
        List<Category> categories = this.baseMapper.selectList(null);
        // filter out root-level(parentId=0) categories and recursively query sub-categories
        return categories.stream()
                .filter(c -> c.getParentId() == 0)
                .peek(c -> c.setChildren(getChildren(c, categories)))
                .sorted(Comparator.comparing(Category::getSort))
                .collect(Collectors.toList());
    }

    /**
     * recursive query
     */
    private List<Category> getChildren(Category category, List<Category> categories) {
        return categories.stream()
                .filter(c -> Objects.equals(c.getParentId(), category.getId()))
                .peek(c -> c.setChildren(getChildren(c, categories)))
                .sorted(Comparator.comparing(Category::getSort))
                .collect(Collectors.toList());
    }
}
