package com.qima.sp.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qima.sp.payment.domain.PaymentRecord;

import java.util.List;

/**
 * @author Chris
 * @date 2021/12/13 11:35
 */
public interface PaymentRecordService extends IService<PaymentRecord> {

    List<PaymentRecord> getByOrderId(Long orderId);
}
