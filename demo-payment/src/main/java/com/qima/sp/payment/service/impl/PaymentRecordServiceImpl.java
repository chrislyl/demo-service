package com.qima.sp.payment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.payment.domain.PaymentRecord;
import com.qima.sp.payment.mapper.PaymentRecordMapper;
import com.qima.sp.payment.service.PaymentRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chris
 * @date 2021/12/13 11:36
 */
@Service
public class PaymentRecordServiceImpl extends ServiceImpl<PaymentRecordMapper, PaymentRecord> implements PaymentRecordService {

    @Override
    public List<PaymentRecord> getByOrderId(Long orderId) {
        return this.baseMapper.selectList(Wrappers.<PaymentRecord>lambdaQuery().eq(PaymentRecord::getOrderId, orderId));
    }
}
