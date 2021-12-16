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
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

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
    private final ThreadPoolTaskExecutor taskExecutor;

    /**
     * Task 3:
     * <ol>
     * <li>How to configure thread pool in SpringBoot, see {@link com.qima.sp.common.core.config.ThreadPoolConfig}</li>
     * <li>How to use CompletableFuture</li>
     * <li>Using lambda expression and stream proficiently</li>
     * </ol>
     */
    @Override
    public OrderVo orderDetails(Long orderId) {
        // TODO: Task 3
        OrderVo orderVo = new OrderVo();

        CompletableFuture<Order> orderFuture = CompletableFuture.supplyAsync(() -> {
            // order info
            Order order = this.getById(orderId);
            BeanUtils.copyProperties(order, orderVo);
            return order;
        }, taskExecutor);

        CompletableFuture<Void> invoiceFuture = orderFuture.thenAcceptAsync((order) -> {
            // invoice info
            R r = invoiceFeignClient.getById(order.getInvoiceId());
            orderVo.setInvoice(r.getData());
        }, taskExecutor);

        CompletableFuture<Void> productFuture = CompletableFuture.runAsync(() -> {
            // product, category, product attribute
            R r = productFeignClient.getDetailsByOrderId(orderId);
            orderVo.setProducts(r.getData());
        }, taskExecutor);

        CompletableFuture<Void> paymentFuture = CompletableFuture.runAsync(() -> {
            // payment info
            R r = paymentFeignClient.getPaymentRecordsByOrderId(orderId);
            orderVo.setPaymentRecords(r.getData());
        }, taskExecutor);

        CompletableFuture.allOf(invoiceFuture, productFuture, paymentFuture).join();

        return orderVo;
    }
}
