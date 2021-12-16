package com.qima.sp.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qima.sp.product.domain.Product;

import java.util.List;

/**
 * @author chris
 * @date 2021/12/11 1:35
 */
public interface ProductService extends IService<Product> {

    List<Product> getByOrderId(Long orderId);
}
