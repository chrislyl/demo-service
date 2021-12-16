package com.qima.sp.payment.mapper;

import com.qima.sp.common.enums.PaymentGateway;
import com.qima.sp.common.enums.PaymentStatus;
import com.qima.sp.payment.domain.PaymentRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author chris
 * @date 2021/12/13 22:12
 */
@Slf4j
@SpringBootTest
public class PaymentRecordMapperTests {

    @Autowired
    PaymentRecordMapper paymentRecordMapper;

    @Test
    public void testInsertOne() {
        PaymentRecord p = PaymentRecord.builder()
                .id(1L)
                .orderId(1L)
                .paymentGateway(PaymentGateway.ADYEN)
                .amountPaid(BigDecimal.valueOf(99.99))
                .payer("Steve Jobs")
                .paymentDate(LocalDateTime.now())
                .status(PaymentStatus.COMPLETED)
                .build();
        PaymentRecord p1 = PaymentRecord.builder()
                .id(2L)
                .orderId(1L)
                .paymentGateway(PaymentGateway.PAYPAL)
                .amountPaid(BigDecimal.valueOf(100.01))
                .payer("Bill Gates")
                .paymentDate(LocalDateTime.now())
                .status(PaymentStatus.COMPLETED)
                .build();
        PaymentRecord p2 = PaymentRecord.builder()
                .id(3L)
                .orderId(1L)
                .paymentGateway(PaymentGateway.ALIPAY)
                .amountPaid(BigDecimal.valueOf(109.00))
                .payer("Zhang San")
                .paymentDate(LocalDateTime.now())
                .status(PaymentStatus.COMPLETED)
                .build();
        paymentRecordMapper.insert(p);
    }

    @Test
    public void testSelectAll() {
        paymentRecordMapper.selectList(null).forEach(p -> log.debug(p.toString()));
    }
}
