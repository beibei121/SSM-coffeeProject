package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeetypeDao;
import org.ccunix.coffee.domain.Coffeetype;
import org.ccunix.coffee.pojo.CoffeetypePOJO;
import org.ccunix.coffee.service.ICoffeetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeetypeServiceImpl implements ICoffeetypeService {

    @Autowired
    CoffeetypeDao coffeetypeDao;

    @Override
    public List<Coffeetype> selectAllCoffeetype(CoffeetypePOJO coffeetypePOJO) {
        return coffeetypeDao.selectAllCoffeetypeByPag(coffeetypePOJO);
    }

    @Override
    public List<Coffeetype> selectAllCoffeetypeByPag(CoffeetypePOJO coffeetypePOJO) {
        return coffeetypeDao.selectAllCoffeetypeByPag(coffeetypePOJO);
    }

    @Override
    public Boolean addCoffeetype(CoffeetypePOJO coffeetypePOJO) {
        return coffeetypeDao.addCoffeetype(coffeetypePOJO);
    }

    @Override
    public Coffeetype selectAllCoffeetypeById(Integer id) {
        return coffeetypeDao.selectAllCoffeetypeById(id);
    }

    @Override
    public Boolean updateCoffeetype(CoffeetypePOJO coffeetypePOJO) {
        return coffeetypeDao.updateCoffeetype(coffeetypePOJO);
    }

    @Override
    public Boolean deleteCoffeetypeById(CoffeetypePOJO coffeetypePOJO) {
        return coffeetypeDao.deleteCoffeetypeById(coffeetypePOJO);
    }


}
