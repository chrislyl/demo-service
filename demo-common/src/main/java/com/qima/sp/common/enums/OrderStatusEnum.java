package com.qima.sp.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Chris
 * @date 2021/12/13 11:53
 */
public enum OrderStatusEnum {
    WAITING_FOR_VALIDATION(20, "Waiting for Validation"),
    FINISHED(60, "Finished"),
    CANCELLED(70, "Cancelled"),
    SERVICE_CUT(80, "Service Cut");

    @EnumValue
    private int code;
    private String desc;

    OrderStatusEnum(int code, String desc) {
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
