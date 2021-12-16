package com.qima.sp.payment.controller;

import com.qima.sp.common.utils.R;
import com.qima.sp.payment.service.PaymentRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chris
 * @date 2021/12/13 11:37
 */
@RestController
@RequestMapping("/payment-record")
@RequiredArgsConstructor
public class PaymentRecordController {

    private final PaymentRecordService paymentRecordService;

    @GetMapping("/list-by-order/{orderId}")
    public R getByOrderId(@PathVariable Long orderId) {
        return R.ok(paymentRecordService.getByOrderId(orderId));
    }
}
