package com.business.program.cross.border.trade.service.impl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.UUID;

import com.business.program.cross.border.trade.exception.BizException;
import com.business.program.cross.border.trade.repository.dao.TestDao;
import com.business.program.cross.border.trade.repository.po.TestTableA;
import com.business.program.cross.border.trade.repository.po.XxlJobInfo;
import com.business.program.cross.border.trade.service.interfaces.TestService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;

    @Resource
    @Lazy
    private TestService self;

    @Override
    @Transactional
    public void addData() {
        TestTableA testTableA = new TestTableA();
        testTableA.setFundName("test"+UUID.randomUUID().toString());
        testDao.addTestTableA(testTableA);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
        } catch (FileNotFoundException e) {
            throw new BizException("文件不存在");
        }

        TestTableA testTableA2 = new TestTableA();
        testTableA2.setFundName("test2"+UUID.randomUUID().toString());
        testDao.addTestTableA(testTableA2);

    }

    @Override
    public void addData2() {
        TestTableA testTableA = new TestTableA();
        testTableA.setFundName("test"+ UUID.randomUUID());
        testDao.addTestTableA(testTableA);

        self.addData3();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
        } catch (FileNotFoundException e) {
            throw new BizException("文件不存在");
        }
    }


    @Override
    @Transactional()
    public void addData3() {
        TestTableA testTableA = new TestTableA();
        testTableA.setFundName("test"+ UUID.randomUUID());
        testDao.addTestTableA(testTableA);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistentfile.txt"));
        } catch (FileNotFoundException e) {
            throw new BizException("文件不存在");
        }

        TestTableA testTableA2 = new TestTableA();
        testTableA2.setFundName("test2"+UUID.randomUUID().toString());
        testDao.addTestTableA(testTableA2);
    }
    
    
}
