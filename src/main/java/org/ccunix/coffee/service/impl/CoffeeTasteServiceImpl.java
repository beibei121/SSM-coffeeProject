package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeTasteDao;
import org.ccunix.coffee.domain.CoffeeTaste;
import org.ccunix.coffee.pojo.CoffeeTastePOJO;
import org.ccunix.coffee.service.ICoffeeTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeTasteServiceImpl implements ICoffeeTasteService {

    @Autowired
    CoffeeTasteDao coffeeTasteDao;

    @Override
    public List<CoffeeTaste> selectAllTasteByPage(CoffeeTastePOJO coffeeTastePOJO) {
        return coffeeTasteDao.selectAllTasteByPage(coffeeTastePOJO);
    }

    @Override
    public Boolean addCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO) {
        return coffeeTasteDao.addCoffeeTaste(coffeeTastePOJO);
    }

    @Override
    public CoffeeTaste selectAllCoffeeTasteById(Integer id) {
        return coffeeTasteDao.selectAllCoffeeTasteById(id);
    }

    @Override
    public Boolean updateCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO) {
        return coffeeTasteDao.updateCoffeeTaste(coffeeTastePOJO);
    }

    @Override
    public Boolean deleteCoffeeTasteById(CoffeeTastePOJO coffeeTastePOJO) {
        return coffeeTasteDao.deleteCoffeeTasteById(coffeeTastePOJO);
    }

    @Override
    public List<CoffeeTaste> selectAllCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO) {
        return coffeeTasteDao.selectAllTasteByPage(coffeeTastePOJO);
    }
}
