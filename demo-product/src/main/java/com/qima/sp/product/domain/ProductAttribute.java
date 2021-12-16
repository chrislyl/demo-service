package com.qima.sp.product.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * @author chris
 * @date 2021/12/12 22:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_product_attribute")
public class ProductAttribute implements Serializable {
    private static final long serialVersionUID = -7361965702865548542L;

    @TableId
    private Long id;
    private Long productId;
    private String attrName;
    private String attrValue;
    private Integer attrSort;
}
