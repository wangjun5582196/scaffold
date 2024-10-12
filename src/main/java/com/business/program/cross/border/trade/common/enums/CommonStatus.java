package com.business.program.cross.border.trade.common.enums;

public  enum CommonStatus implements Status {
    SUCCESS("0", "success"),

    FAIL("-1", "fail"),
;

    private final String code;
    private final String reason;

    private CommonStatus(String statusCode, String reasonPhrase) {
        this.code = statusCode;
        this.reason = reasonPhrase;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.reason;
    }

}
