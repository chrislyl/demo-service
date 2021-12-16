package com.qima.sp.payment.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chris
 * @date 2021/12/13 22:40
 */
@Slf4j
@SpringBootTest
public class PaymentRecordServiceTests {

    @Autowired
    PaymentRecordService paymentRecordService;

    @Test
    public void testGetByOrderId() {
        paymentRecordService.getByOrderId(1L).forEach(p -> log.debug(p.toString()));
    }
}
