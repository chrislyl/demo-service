package com.qima.sp.order.feign;

import com.qima.sp.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chris
 * @date 2021/12/13 0:18
 */
@FeignClient("qima-product")
public interface ProductFeignClient {

    @GetMapping("/product/order/{orderId}")
    R getDetailsByOrderId(@PathVariable("orderId") Long orderId);
}
