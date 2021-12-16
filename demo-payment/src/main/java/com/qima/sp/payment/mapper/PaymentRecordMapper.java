package com.qima.sp.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qima.sp.payment.domain.PaymentRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chris
 * @date 2021/12/13 11:32
 */
@Mapper
public interface PaymentRecordMapper extends BaseMapper<PaymentRecord> {
}
