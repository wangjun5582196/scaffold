package com.business.program.cross.border.trade.repository.dao;


import com.business.program.cross.border.trade.repository.mapper.TestTableAMapper;
import com.business.program.cross.border.trade.repository.mapper.TestTableBMapper;
import com.business.program.cross.border.trade.repository.mapper.XxlJobInfoMapper;
import com.business.program.cross.border.trade.repository.po.TestTableA;
import com.business.program.cross.border.trade.repository.po.TestTableB;
import com.business.program.cross.border.trade.repository.po.XxlJobInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestDao {

    @Resource
    private XxlJobInfoMapper xxlJobInfoMapper;

    @Resource
    private TestTableAMapper testTableAMapper;

    @Resource
    private TestTableBMapper testTableBMapper;

    public void addXXLJobInfo(XxlJobInfo xxlJobInfo) {
        xxlJobInfoMapper.insert(xxlJobInfo);
    }

    public void addTestTableA(TestTableA testTableA) {
        testTableAMapper.insert(testTableA);
    }

    public void addTestTableB(TestTableB testTableB) {
        testTableBMapper.insert(testTableB);
    }

}
