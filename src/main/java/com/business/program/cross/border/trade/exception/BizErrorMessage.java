package com.business.program.cross.border.trade.exception;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum BizErrorMessage {

    /**
     * 业务异常
     */
    BUSINESS_ERROR("1025000", "业务异常"),


    /**
     * 无效参数
     */
    INVALID_PARAM("1022011", "无效参数"),

    /**
     * 没有操作权限
     */
    ACCESS_DENIED("1022004", "没有操作权限"),

    /**
     * 没有数据权限
     */
    DATA_DENIED("1022005", "没有数据权限"),

    /**
     * 密码错误
     */
    MULTIPLE_LOGIN_FAILURES("1022007", "密码错误"),

    /**
     * 账号锁定
     */
    PWD_LOCK("1022012", "账号锁定"),


    /**
     * 客户端错误
     */
    WRONG_REQUEST("1024000", "客户端错误"),


    /**
     * 账户禁用
     */
    ACCOUNT_DISABLE("1026002", "账户禁用"),


    ;


    private final String code;
    private final String msg;

    private BizErrorMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getIntCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    private static final Map<String, BizErrorMessage> MAP = new HashMap<>(Stream.of(values()).collect(Collectors.toMap(BizErrorMessage::getCode, Function.identity())));

    public static BizErrorMessage getMessageByCode(String strValue) {
        return MAP.get(strValue);
    }
}
