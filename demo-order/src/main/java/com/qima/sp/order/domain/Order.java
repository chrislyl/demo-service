package com.qima.sp.order.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qima.sp.common.enums.OrderStatusEnum;
import com.qima.sp.common.enums.ServiceTypeEnum;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author chris
 * @date 2021/12/11 1:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 6612029892368326178L;

    @TableId
    private Long id;
    private String orderNo;
    private LocalDateTime bookingDate;
    private BigDecimal totalAmount;
    private ServiceTypeEnum serviceType;
    private OrderStatusEnum status;

    private Long invoiceId;
}
