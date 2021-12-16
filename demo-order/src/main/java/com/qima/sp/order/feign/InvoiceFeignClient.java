package com.qima.sp.order.feign;

import com.qima.sp.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Chris
 * @date 2021/12/13 18:52
 */
@FeignClient("qima-invoice")
public interface InvoiceFeignClient {

    @GetMapping("/invoice/{invoiceId}")
    R getById(@PathVariable("invoiceId") Long invoiceId);
}
