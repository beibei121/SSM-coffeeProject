package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeNewsDao;
import org.ccunix.coffee.domain.CoffeeNews;
import org.ccunix.coffee.pojo.CoffeeNewsPOJO;
import org.ccunix.coffee.service.ICoffeeNewsService;
import org.ccunix.coffee.utils.DateSwitchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoffeeNewsServiceImpl implements ICoffeeNewsService {
    @Autowired
    CoffeeNewsDao coffeeNewsDao;

    @Override
    public List<CoffeeNews> selectAllCoffeeResultMap(CoffeeNewsPOJO coffeenewsPOJO) {
        return coffeeNewsDao.selectAllCoffeeResultMap(coffeenewsPOJO);
    }

    @Override
    public void addCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO) {
        //获得服务器的当前时间
        String addtime = DateSwitchUtil.parseString(new Date(),"yyyy-MM-dd HH:mm:ss");
        //设置到 coffeeNewsPOJO上
        coffeeNewsPOJO.setAddtime(addtime);
        coffeeNewsDao.addCoffeenews(coffeeNewsPOJO);
    }

    @Override
    public CoffeeNews selectAllCoffeeNewsById(Integer id) {
        return coffeeNewsDao.selectAllCoffeeNewsById(id);
    }

    @Override
    public void updateCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO) {
        coffeeNewsDao.updateCoffeenews(coffeeNewsPOJO);
    }

    @Override
    public void deleteCoffeenewsById(Integer id) {
        coffeeNewsDao.deleteCoffeenewsById(id);
    }
}
