package com.qima.sp.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qima.sp.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chris
 * @date 2021/12/12 19:45
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
