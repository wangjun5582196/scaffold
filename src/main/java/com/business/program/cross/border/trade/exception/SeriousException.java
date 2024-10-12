package com.business.program.cross.border.trade.exception;

import lombok.Getter;

@Getter
public class SeriousException extends RuntimeException {

    private String code;

    private String desc;

    private Object data;

    public SeriousException() {
        super();
    }

    public SeriousException(String msg) {
        super(msg);
        this.desc = msg;
    }

    public SeriousException(String code, String msg) {
        super(msg);
        this.code = code;
        this.desc = msg;
    }

    public SeriousException(Integer code, String msg){
        super(msg);
        this.code = String.valueOf(code);
        this.desc = msg;
    }

    public SeriousException(String code, String msg, String desc) {
        super(msg);
        this.code = code;
        this.desc = desc;
    }

    public SeriousException(String code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.desc = msg;
        this.data = data;
    }

    public SeriousException(String code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
        this.desc = msg;
    }

    public SeriousException(SeriousErrorMessage bizError){
        super(bizError.getMsg());
        this.code = bizError.getCode();
        this.desc = bizError.getMsg();
    }

    public SeriousException(SeriousErrorMessage bizError, String message){
        super(message);
        this.code = bizError.getCode();
        this.desc = message;
    }

}
