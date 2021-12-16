package com.qima.sp.product.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qima.sp.common.enums.CategoryStatusEnum;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yulong
 * @date 2021/12/8 11:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 6107018713880358956L;

    @TableId
    private Long id;
    private Long parentId;
    private String name;
    private Long sort;
    private CategoryStatusEnum status;

    @TableField(exist = false)
    private List<Category> children = List.of();
}
