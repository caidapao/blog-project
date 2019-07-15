package com.caidapao.today.common.exception;

import com.caidapao.today.common.pojo.ErrorCode;

/**
 * Created by caidapao on 2019/7/14
 * Time 12:38
 * address http://today.caidapao.com
 */
public class TodayException extends RuntimeException{
    private String code;

    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public TodayException(String code, String msg, Object... params) {
        this.code = code;
        this.errorMsg = (params != null && params.length > 0) ? String.format(msg, params) : msg;
    }

    public TodayException(ErrorCode errorCode, Object... params) {
        this.code = errorCode.getCode();
        this.errorMsg = (params != null && params.length > 0) ? String.format(errorCode.getErrorMsg(), params) : errorCode.getErrorMsg();
    }
}
