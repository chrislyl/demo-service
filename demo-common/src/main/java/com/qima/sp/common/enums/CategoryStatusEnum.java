package com.qima.sp.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Yulong
 * @date 2021/12/8 11:38
 */
public enum CategoryStatusEnum {

    ACTIVE(0, "Activated"),
    INACTIVE(1, "Terminated");

    @EnumValue
    private int code;
    private String desc;

    CategoryStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
