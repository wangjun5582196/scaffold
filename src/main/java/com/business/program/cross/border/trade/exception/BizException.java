package com.business.program.cross.border.trade.exception;

import lombok.Getter;


@Getter
public class BizException extends RuntimeException {

    private String code;

    private String desc;

    private Object data;

    public BizException() {
        super();
    }

    public BizException(String msg) {
        super(msg);
        this.code = BizErrorMessage.BUSINESS_ERROR.getCode();
        this.desc = msg;
    }

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.desc = msg;
    }

    public BizException(Integer code,String msg){
        super(msg);
        this.code = String.valueOf(code);
        this.desc = msg;
    }

    public BizException(String code, String msg, String desc) {
        super(msg);
        this.code = code;
        this.desc = desc;
    }

    public BizException(String code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.desc = msg;
        this.data = data;
    }

    public BizException(String code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
        this.desc = msg;
    }

    public BizException(BizErrorMessage bizError){
        super(bizError.getMsg());
        this.code = bizError.getCode();
        this.desc = bizError.getMsg();
    }

    public BizException(BizErrorMessage bizError,String message){
        super(message);
        this.code = bizError.getCode();
        this.desc = message;
    }

}
