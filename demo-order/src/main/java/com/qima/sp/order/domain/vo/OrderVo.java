package com.qima.sp.order.domain.vo;

import com.qima.sp.common.enums.OrderStatusEnum;
import com.qima.sp.common.enums.ServiceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Chris
 * @date 2021/12/13 18:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo implements Serializable {
    private static final long serialVersionUID = 7570491905406786002L;

    private Long id;
    private String orderNo;
    private LocalDateTime bookingDate;
    private BigDecimal totalAmount;
    private ServiceTypeEnum serviceType;
    private OrderStatusEnum status;

    private Object products;
    private Object paymentRecords;
    private Object invoice;
}
