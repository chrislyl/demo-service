package com.qima.sp.invoice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.invoice.domain.Invoice;
import com.qima.sp.invoice.mapper.InvoiceMapper;
import com.qima.sp.invoice.service.InvoiceService;
import org.springframework.stereotype.Service;

/**
 * @author chris
 * @date 2021/12/12 20:02
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {
}
