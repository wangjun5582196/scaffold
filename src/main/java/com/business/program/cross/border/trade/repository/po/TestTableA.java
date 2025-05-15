package com.business.program.cross.border.trade.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangjun51000
 * @since 2025-05-14
 */
@TableName("TEST_TABLE_A")
public class TestTableA implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REC_ID", type = IdType.AUTO)
    private Long recId;

    private String fundName;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    @Override
    public String toString() {
        return "TestTableA{" +
        "recId = " + recId +
        ", fundName = " + fundName +
        "}";
    }
}
