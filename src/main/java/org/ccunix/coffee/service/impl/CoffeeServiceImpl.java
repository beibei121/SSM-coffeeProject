package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeDao;
import org.ccunix.coffee.domain.Coffee;
import org.ccunix.coffee.domain.CoffeeResultMap;
import org.ccunix.coffee.pojo.CoffeePOJO;
import org.ccunix.coffee.service.ICoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements ICoffeeService {

    @Autowired
    CoffeeDao coffeeDao;

    @Override
    public List<Coffee> selectAllCoffee(CoffeePOJO coffeePOJO) {
        return coffeeDao.selectAllCoffee(coffeePOJO);
    }

    @Override
    public List<CoffeeResultMap> selectAllCoffeeResultMap(CoffeePOJO coffeePOJO) {
        return coffeeDao.selectAllCoffeeResultMap(coffeePOJO);
    }

    @Override
    public void addCoffee(CoffeePOJO coffeePOJO) {
        coffeeDao.addCoffee(coffeePOJO);
    }

    @Override
    public CoffeeResultMap selectCoffeeById(Integer id) {
        return coffeeDao.selectCoffeeById(id);
    }

    @Override
    public void updateCoffee(CoffeePOJO coffeePOJO) {
        coffeeDao.updateCoffee(coffeePOJO);
    }

    @Override
    public void deleteCoffee(Integer id) {
        coffeeDao.deleteCoffee(id);
    }

}
