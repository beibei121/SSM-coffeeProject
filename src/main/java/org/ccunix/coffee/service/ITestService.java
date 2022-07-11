package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.TestAccount;

import java.util.List;

public interface ITestService {
    public List<TestAccount> queryAll();

    public void saveAccount(TestAccount testAccount);
}
