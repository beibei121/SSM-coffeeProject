package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.TestAccount;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITestDao {

    public List<TestAccount> queryAll();

    public void saveAccount(TestAccount testAccount);
}
