package com.business.program.cross.border.trade.service.impl;
import java.time.LocalDateTime;
import java.util.UUID;

import com.business.program.cross.border.trade.repository.dao.TestDao;
import com.business.program.cross.border.trade.repository.po.XxlJobInfo;
import com.business.program.cross.border.trade.service.interfaces.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;

    @Override
    public void addData() {
        XxlJobInfo xxlJobInfo = new XxlJobInfo();

        xxlJobInfo.setJobGroup(0);
        xxlJobInfo.setJobDesc(UUID.randomUUID().toString());
        xxlJobInfo.setAddTime(LocalDateTime.now());
        xxlJobInfo.setUpdateTime(LocalDateTime.now());
        xxlJobInfo.setAuthor("2");
        xxlJobInfo.setAlarmEmail("3");
        xxlJobInfo.setScheduleType("5");
        xxlJobInfo.setScheduleConf("7");
        xxlJobInfo.setMisfireStrategy("9");
        xxlJobInfo.setExecutorRouteStrategy("19");
        xxlJobInfo.setExecutorHandler("11");
        xxlJobInfo.setExecutorParam("12");
        xxlJobInfo.setExecutorBlockStrategy("13");
        xxlJobInfo.setExecutorTimeout(0);
        xxlJobInfo.setExecutorFailRetryCount(0);
        xxlJobInfo.setGlueType("14");
        xxlJobInfo.setGlueSource("15");
        xxlJobInfo.setGlueRemark("16");
        xxlJobInfo.setGlueUpdatetime(LocalDateTime.now());
        xxlJobInfo.setChildJobid("17");
        xxlJobInfo.setTriggerStatus(0);
        xxlJobInfo.setTriggerLastTime(0L);
        xxlJobInfo.setTriggerNextTime(0L);
        testDao.addXXLJobInfo(xxlJobInfo);
    }
}
