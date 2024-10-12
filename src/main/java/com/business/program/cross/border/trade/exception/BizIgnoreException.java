package com.business.program.cross.border.trade.exception;

import lombok.Getter;


@Getter
public class BizIgnoreException extends BizException {


    public BizIgnoreException() {
        super();
    }

    public BizIgnoreException(String msg) {
        super(msg);
    }

    public BizIgnoreException(String code, String msg) {
        super(code,msg);
    }

    public BizIgnoreException(Integer code,String msg){
        super(code, msg);
    }

    public BizIgnoreException(String code, String msg, String desc) {
        super(code, msg, desc);
    }

    public BizIgnoreException(String code, String msg, Object data) {
        super(code, msg, data);
    }

    public BizIgnoreException(String code, String msg, Throwable e) {
        super(code, msg, e);
    }

    public BizIgnoreException(BizErrorMessage bizError){
       super(bizError);
    }

    public BizIgnoreException(BizErrorMessage bizError,String message){
        super(bizError, message);
    }
}
