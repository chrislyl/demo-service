package com.qima.sp.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qima.sp.order.domain.Order;
import com.qima.sp.order.domain.vo.OrderVo;
import org.springframework.stereotype.Service;

/**
 * @author chris
 * @date 2021/12/12 19:46
 */
@Service
public interface OrderService extends IService<Order> {

    OrderVo orderDetails(Long orderId);
}
