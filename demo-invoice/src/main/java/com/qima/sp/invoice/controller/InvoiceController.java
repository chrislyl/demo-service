package com.qima.sp.invoice.controller;

import com.qima.sp.common.utils.R;
import com.qima.sp.invoice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 * @date 2021/12/12 20:03
 */
@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{id}")
    public R getById(@PathVariable Long id) {
        return R.ok(invoiceService.getById(id));
    }
}
