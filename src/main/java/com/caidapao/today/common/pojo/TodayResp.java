package com.caidapao.today.common.pojo;

/**
 * Created by caidapao on 2019/7/14
 * Time 12:40
 * address https://today.caidapao.com
 */
public class TodayResp {

    private boolean isSuccess;

    private String code;

    private String msg;

    private Object data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
