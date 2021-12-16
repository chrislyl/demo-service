package com.qima.sp.common.utils;

import org.apache.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * the data object returned by the RESTful API
 *
 * @author Yulong
 * @date 2021/12/10 10:10
 */
public class R extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = -6148750579805762579L;

    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "message";
    public static final String KEY_DATA = "data";

    public R() {
        put(KEY_CODE, HttpStatus.SC_OK);
        put(KEY_MSG, "request succeeded");
    }

    public static R ok() {
        return new R();
    }

    public static R ok(Object data) {
        R ok = R.ok();
        ok.put(KEY_DATA, data);
        return ok;
    }

    public Object getData() {
        return this.get(KEY_DATA);
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(String dataKey, Object data) {
        R ok = ok();
        ok.put(dataKey, data);
        return ok;
    }
}
