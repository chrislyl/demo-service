package com.qima.sp.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.product.domain.Product;
import com.qima.sp.product.mapper.CategoryMapper;
import com.qima.sp.product.mapper.ProductAttributeMapper;
import com.qima.sp.product.mapper.ProductMapper;
import com.qima.sp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chris
 * @date 2021/12/11 1:36
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final CategoryMapper categoryMapper;
    private final ProductAttributeMapper productAttributeMapper;

    /**
     * Task 1:
     * <ol>
     * <li>Code efficiency (worst to query database one by one)</li>
     * <li>require one SQL to query the data of all related tables</li>
     * </ol>
     */
    @Override
    public List<Product> getByOrderId(Long orderId) {
        // TODO: Task 1
        // optimize this implementation to improve query efficiency
        // require one SQL to query the data of all related tables
//        return this.baseMapper.selectList(Wrappers.<Product>lambdaQuery().eq(Product::getOrderId, orderId))
//                .stream()
//                .peek(p -> {
//                    p.setCategory(categoryMapper.selectById(p.getCategoryId()));
//                    p.setAttributes(productAttributeMapper.selectList(null));
//                })
//                .collect(Collectors.toList());
        return this.baseMapper.selectByOrderId(orderId);
    }
}
