package com.qima.sp.invoice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qima.sp.invoice.domain.Invoice;
import com.qima.sp.invoice.mapper.InvoiceMapper;
import com.qima.sp.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author chris
 * @date 2021/12/12 20:02
 */
@Slf4j
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

    @Override
    public Invoice getById(Serializable id) {
        try {
            // simulate business time spent
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.debug(e.getMessage(), e);
        }
        return super.getById(id);
    }
}
