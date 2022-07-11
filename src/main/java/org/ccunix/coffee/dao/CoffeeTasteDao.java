package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.CoffeeTaste;
import org.ccunix.coffee.pojo.CoffeeTastePOJO;

import java.util.List;

public interface CoffeeTasteDao {

    List<CoffeeTaste> selectAllTasteByPage(CoffeeTastePOJO coffeeTastePOJO);

    Boolean addCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO);

    CoffeeTaste selectAllCoffeeTasteById(Integer id);

    Boolean updateCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO);

    Boolean deleteCoffeeTasteById(CoffeeTastePOJO coffeeTastePOJO);
}
