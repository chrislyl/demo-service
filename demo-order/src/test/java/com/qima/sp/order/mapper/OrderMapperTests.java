package com.qima.sp.order.mapper;

import com.qima.sp.common.enums.OrderStatusEnum;
import com.qima.sp.common.enums.ServiceTypeEnum;
import com.qima.sp.order.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Chris
 * @date 2021/12/13 15:41
 */
@Slf4j
@SpringBootTest
public class OrderMapperTests {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testInsertOne() {
        Order order = Order.builder()
                .orderNo("O-2100001")
                .bookingDate(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(199.45))
                .serviceType(ServiceTypeEnum.INSPECTION)
                .status(OrderStatusEnum.FINISHED)
                .invoiceId(1L)
                .build();
        orderMapper.insert(order);
    }

    @Test
    public void testSelectById() {
        Order order = orderMapper.selectById(1L);
        log.debug(order.toString());
    }
}
