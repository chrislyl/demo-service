package com.qima.sp.invoice.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author chris
 * @date 2021/12/12 19:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_invoice")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 6483831962319806331L;

    private Long id;
    private String invoiceNo;
    private LocalDate issueDate;
    private BigDecimal totalAmount;
    private String currency;
}
