package com.usoft.suntg.utils;

/**
 * Created by ConcaSun on 2019/4/16.
 */
public class MyBatisTestRuntimeException extends RuntimeException {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MyBatisTestRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public MyBatisTestRuntimeException(String message) {
        this(-1, message);
    }

}
