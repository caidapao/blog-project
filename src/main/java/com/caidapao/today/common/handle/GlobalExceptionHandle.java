package com.caidapao.today.common.handle;

import com.caidapao.today.common.exception.TodayException;
import com.caidapao.today.common.pojo.TodayResp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caidapao on 2019/7/14
 * Time 12:39
 * address https://today.caidapao.com
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 当抛出MyException时，会被此方法拦截。直接返回RespJson
     * @param e 异常对象
     */
    @ExceptionHandler(value = TodayException.class)
    @ResponseBody
    public TodayResp handleMyException(TodayException e){
        TodayResp respJson = new TodayResp();
        respJson.setCode(e.getCode());
        respJson.setMsg(e.getErrorMsg());
        return respJson;
    }
}
