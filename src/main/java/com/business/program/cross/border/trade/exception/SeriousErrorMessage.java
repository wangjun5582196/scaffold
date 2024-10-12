package com.business.program.cross.border.trade.exception;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum SeriousErrorMessage {

    /**
     * 内部异常
     */
    INTERNAL_ERROR("1025000", "内部异常"),

    /**
     * 并发事务冲突
     */
    CONCURRENT_TRANSACTION_CONFLICT("1022001", "并发事务冲突"),

    /**
     * 重复操作
     */
    REPEATED_OPERATION("1022003", "重复的操作"),

    /**
     * 唯一字段重复
     */
    DUPLICATED("1022002", "唯一字段重复"),

    UNSUPPORTED_TYPE("DBUtilErrorCode-12", "不支持的数据库类型"),

    ;


    private final String code;
    private final String msg;

    private SeriousErrorMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return this.code;
    }

    public Integer getIntCode() {
        return Integer.parseInt(this.code);
    }

    public String getMsg(){
        return this.msg;
    }

    private static final Map<String, SeriousErrorMessage> MAP = new HashMap<>(Stream.of(values()).collect(Collectors.toMap(SeriousErrorMessage::getCode, Function.identity())));

    public static SeriousErrorMessage getMessageByCode(String strValue) {
        return MAP.get(strValue);
    }

}
