package com.business.program.cross.border.trade.common.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;


@Data
@NoArgsConstructor
public class PageDTO<T> {

    private Long pages;


    private Long size;


    private Long current;


    private Collection<T> records;


    private Long total;

    /**
     * SQL查询时, 作为 OFFSET 参数
     */
    @JSONField(serialize = false, deserialize = false)
    private Long start;

    public PageDTO(long current, long size) {
        this.current = current;
        this.size = size;
        this.start = (current - 1) * size;
    }

    public void setTotal(Long total) {
        this.total = total;
        
        if (this.total > 0 && this.size > 0) {
            this.pages = (new BigDecimal(String.valueOf(this.total)))
                .divide(new BigDecimal(String.valueOf(this.size)), RoundingMode.CEILING)
                .longValue();
        } else {
            this.pages = 0L;
        }
    }
}
