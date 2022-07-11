package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeUserDao;
import org.ccunix.coffee.domain.CoffeeUser;
import org.ccunix.coffee.pojo.CoffeeUserPOJO;
import org.ccunix.coffee.service.ICoffeeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeUserServiceImpl implements ICoffeeUserService {

    @Autowired
    CoffeeUserDao coffeeUserDao;

    @Override
    public List<CoffeeUser> selectAllUserByPage(CoffeeUserPOJO coffeeUserPOJO) {
        return coffeeUserDao.selectAllUserByPage(coffeeUserPOJO);
    }

    @Override
    public CoffeeUser isExistSameUsername(String username) {
        List<CoffeeUser> userList =  coffeeUserDao.selectUserListByUserName(username);
        if (userList.size()>0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void addCoffeeUser(CoffeeUserPOJO coffeeUserPOJO) {
        coffeeUserDao.addCoffeeUser(coffeeUserPOJO);
    }

    @Override
    public CoffeeUser selectAllUserById(Integer id) {
        return coffeeUserDao.selectAllUserById(id);
    }

    @Override
    public void updateCoffee(CoffeeUserPOJO coffeeUserPOJO) {
        coffeeUserDao.updateCoffee(coffeeUserPOJO);
    }

    @Override
    public void deleteUserById(Integer id) {
        coffeeUserDao.deleteUserById(id);
    }
}
