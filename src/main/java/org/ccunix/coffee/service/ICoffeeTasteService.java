package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.CoffeeTaste;
import org.ccunix.coffee.pojo.CoffeeTastePOJO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICoffeeTasteService {
    /**
     * 查询口味类型列表
     * @param coffeeTastePOJO
     * @return
     */
    List<CoffeeTaste> selectAllTasteByPage(CoffeeTastePOJO coffeeTastePOJO);

    Boolean addCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO);

    CoffeeTaste selectAllCoffeeTasteById(Integer id);

    Boolean updateCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO);

    Boolean deleteCoffeeTasteById(CoffeeTastePOJO coffeeTastePOJO);

    List<CoffeeTaste> selectAllCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO);
}
