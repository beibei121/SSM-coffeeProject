package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.Coffeetype;
import org.ccunix.coffee.pojo.CoffeetypePOJO;

import java.util.List;

public interface CoffeetypeDao {
    List<Coffeetype> selectAllCoffeetypeByPag(CoffeetypePOJO coffeetypePOJO);

    Boolean addCoffeetype(CoffeetypePOJO coffeetypePOJO);

    Coffeetype selectAllCoffeetypeById(Integer id);

    Boolean updateCoffeetype(CoffeetypePOJO coffeetypePOJO);

    Boolean deleteCoffeetypeById(CoffeetypePOJO coffeetypePOJO);

}
