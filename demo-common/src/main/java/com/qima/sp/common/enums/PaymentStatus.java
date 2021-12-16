package com.qima.sp.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author Chris
 * @date 2021/12/13 11:24
 */
public enum PaymentStatus {
    COMPLETED(0, "Payment Successful"),
    FAILED(1, "Payment Failed"),
    DELETED(2, "Deleted");

    @EnumValue
    private int code;
    private String desc;

    PaymentStatus(int code, String desc) {
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
