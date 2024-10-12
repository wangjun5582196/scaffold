package com.business.program.cross.border.trade.repository.dao;


import com.business.program.cross.border.trade.repository.mapper.XxlJobInfoMapper;
import com.business.program.cross.border.trade.repository.po.XxlJobInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestDao {

    @Resource
    private XxlJobInfoMapper xxlJobInfoMapper;

    public void addXXLJobInfo(XxlJobInfo xxlJobInfo) {
        xxlJobInfoMapper.insert(xxlJobInfo);
    }
}
