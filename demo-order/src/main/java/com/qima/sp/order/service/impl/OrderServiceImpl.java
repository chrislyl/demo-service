package com.qima.sp.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.common.utils.R;
import com.qima.sp.order.domain.Order;
import com.qima.sp.order.domain.vo.OrderVo;
import com.qima.sp.order.feign.InvoiceFeignClient;
import com.qima.sp.order.feign.PaymentFeignClient;
import com.qima.sp.order.feign.ProductFeignClient;
import com.qima.sp.order.mapper.OrderMapper;
import com.qima.sp.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author chris
 * @date 2021/12/12 19:47
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final ProductFeignClient productFeignClient;
    private final InvoiceFeignClient invoiceFeignClient;
    private final PaymentFeignClient paymentFeignClient;

    @Override
    public OrderVo orderDetails(Long orderId) {
        // TODO: Task 3
        OrderVo orderVo = new OrderVo();
        // order info
        Order order = this.getById(orderId);
        BeanUtils.copyProperties(order, orderVo);
        // product info
        R r = productFeignClient.getDetailsByOrderId(orderId);
        orderVo.setProducts(r.getData());
        // invoice info
        r = invoiceFeignClient.getById(order.getInvoiceId());
        orderVo.setInvoice(r.getData());
        // payment info
        r = paymentFeignClient.getPaymentRecordsByOrderId(orderId);
        orderVo.setPaymentRecords(r.getData());
        return orderVo;
    }
}
