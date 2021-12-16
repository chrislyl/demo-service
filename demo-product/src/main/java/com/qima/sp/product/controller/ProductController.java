package com.qima.sp.product.controller;

import com.qima.sp.common.utils.R;
import com.qima.sp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 * @date 2021/12/11 1:40
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/order/{orderId}")
    public R getDetailsByOrderId(@PathVariable Long orderId) {
        return R.ok(productService.getByOrderId(orderId));
    }
}
