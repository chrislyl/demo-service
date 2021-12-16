package com.qima.sp.product.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yulong
 * @date 2021/12/8 11:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_product")
public class Product implements Serializable {
    private static final long serialVersionUID = -4292285678905051980L;

    @TableId
    private Long id;
    private Long orderId;
    private Long categoryId;
    private String name;
    private int quantity;

    @TableField(exist = false)
    private Category category;
    @TableField(exist = false)
    private List<ProductAttribute> attributes;
}
