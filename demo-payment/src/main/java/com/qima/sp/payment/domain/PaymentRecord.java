package com.qima.sp.payment.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qima.sp.common.enums.PaymentGateway;
import com.qima.sp.common.enums.PaymentStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Chris
 * @date 2021/12/13 11:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_payment_record")
public class PaymentRecord implements Serializable {
    private static final long serialVersionUID = 5016727390164908327L;

    private Long id;
    private Long orderId;
    private PaymentGateway paymentGateway;
    private BigDecimal amountPaid;
    private String payer;
    private LocalDateTime paymentDate;
    private PaymentStatus status;
}
