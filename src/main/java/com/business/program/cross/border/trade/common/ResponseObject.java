package com.business.program.cross.border.trade.common;




import com.business.program.cross.border.trade.common.enums.CommonStatus;
import com.business.program.cross.border.trade.exception.BizErrorMessage;
import com.business.program.cross.border.trade.exception.BizException;
import com.business.program.cross.border.trade.exception.SeriousErrorMessage;
import lombok.*;

import java.util.Optional;
import java.util.function.Function;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseObject<T> {

    private static final String SUCCESS = "success";

    private String msg;

    private String code;

    private T data;

    public static <T> ResponseObject<T> success() {

        return ResponseObject.<T>builder()
                .msg(SUCCESS)
                .code(CommonStatus.SUCCESS.getCode())
               .build();
    }
    public   boolean judgeSuccess(){
        return CommonStatus.SUCCESS.getCode().equals(this.code);
    }

    public static <R,T>  ResponseObject<T> success(R source, Function<R, T> method) {

        return ResponseObject.<T>builder()
                .msg(SUCCESS)
                .code(CommonStatus.SUCCESS.getCode())
                .data(method.apply(source))
                .build();
    }

    public static <T> ResponseObject<T> success(T data) {

        return ResponseObject.<T>builder()
                .msg(SUCCESS)
                .code(CommonStatus.SUCCESS.getCode())
                .data(data)
                .build();
    }

    public static <T> ResponseObject<T> fail(BizException bizException) {

        return ResponseObject.<T>builder()
                .msg(bizException.getMessage())
                .code(String.valueOf(Optional.ofNullable(bizException.getCode()).map(String::valueOf)
                        .orElse(BizErrorMessage.BUSINESS_ERROR.getIntCode())))
                .build();
    }

    public static <T> ResponseObject<T> fail(Exception exception) {

        return ResponseObject.<T>builder()
                .msg("服务器开小差了，稍后再试吧~")
                .code(String.valueOf(Integer.parseInt(SeriousErrorMessage.INTERNAL_ERROR.getCode())))
                .build();
    }

    public static <T> ResponseObject<T> fail() {

        return ResponseObject.<T>builder()
                .msg(SeriousErrorMessage.INTERNAL_ERROR.getMsg())
                .code(String.valueOf(Integer.parseInt(SeriousErrorMessage.INTERNAL_ERROR.getCode())))
                .build();
    }

    public static <T> ResponseObject<T> fail(String code, String errMsg) {

        return ResponseObject.<T>builder()
                .msg(errMsg)
                .code(code)
                .build();
    }
}
