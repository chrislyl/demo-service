package com.qima.sp.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qima.sp.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chris
 * @date 2021/12/11 1:34
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> selectByOrderId(Long orderId);
}
