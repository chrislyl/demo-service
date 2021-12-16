package com.qima.sp.order.controller;

import com.qima.sp.common.utils.R;
import com.qima.sp.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 * @date 2021/12/12 19:48
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/details/{id}")
    public R orderDetails(@PathVariable Long id) {
        return R.ok("order", orderService.orderDetails(id));
    }
}
