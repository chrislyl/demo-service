package com.qima.sp.invoice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qima.sp.invoice.domain.Invoice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chris
 * @date 2021/12/12 20:00
 */
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {
}
