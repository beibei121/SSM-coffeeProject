package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.ITestDao;
import org.ccunix.coffee.domain.TestAccount;
import org.ccunix.coffee.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    ITestDao testDao;

    @Override
    public List<TestAccount> queryAll() {
        System.out.println("业务层 查询所有");
        return testDao.queryAll();
    }

    @Override
    public void saveAccount(TestAccount testAccount) {
        System.out.println("业务层，保存信息");
        testDao.saveAccount(testAccount);
        //System.out.println(1/0);
    }
}
