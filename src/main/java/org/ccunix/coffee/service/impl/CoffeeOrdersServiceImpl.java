package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeOrdersDao;
import org.ccunix.coffee.domain.CoffeeOrdersResultMap;
import org.ccunix.coffee.service.ICoffeeOrdersService;
import org.ccunix.coffee.vo.OrdersCustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeOrdersServiceImpl implements ICoffeeOrdersService {
    @Autowired
    CoffeeOrdersDao coffeeOrdersDao;

    @Override
    public List<CoffeeOrdersResultMap> selectAllOrdersByPage(OrdersCustomVO ordersCustomVO) {
        return coffeeOrdersDao.selectAllOrdersByPage(ordersCustomVO);
    }

    @Override
    public void toDeliver(Integer id) {
        coffeeOrdersDao.toDeliver(id);
    }

    @Override
    public CoffeeOrdersResultMap selectOrdersDetailListById(Integer id){
        return coffeeOrdersDao.selectOrdersDetailListById(id);
    }
}
