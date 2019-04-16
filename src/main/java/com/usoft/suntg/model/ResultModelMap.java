package com.usoft.suntg.model;

/**
 * Created by ConcaSun on 2019/4/16.
 */
public class ResultModelMap {
    private boolean success;
    private int code;
    private String errorMessage;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultModelMap success(Object data) {
        ResultModelMap resultModelMap = new ResultModelMap();
        resultModelMap.setSuccess(true);
        resultModelMap.setData(data);
        resultModelMap.setCode(1);
        return resultModelMap;
    }

    public static ResultModelMap error(int code, String errorMessage) {
        ResultModelMap resultModelMap = new ResultModelMap();
        resultModelMap.setSuccess(false);
        resultModelMap.setCode(code);
        resultModelMap.setErrorMessage(errorMessage);
        return resultModelMap;
    }
}
