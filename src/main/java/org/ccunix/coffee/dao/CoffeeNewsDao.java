package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.CoffeeNews;
import org.ccunix.coffee.pojo.CoffeeNewsPOJO;

import java.util.List;

public interface CoffeeNewsDao {
    /**
     * 根据条件查询咖啡资讯列表
     * @param coffeenewsPOJO
     * @return
     */
    List<CoffeeNews> selectAllCoffeeResultMap(CoffeeNewsPOJO coffeenewsPOJO);

    /**
     * 添加资讯
     * @param coffeeNewsPOJO
     */
    void addCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO);

    /**
     * 根据id查询资讯详情
     * @param id
     * @return
     */
    CoffeeNews selectAllCoffeeNewsById(Integer id);

    /**
     * 修改资讯
     * @param coffeeNewsPOJO
     */
    void updateCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO);

    /**
     * 逻辑删除
     * @param id
     */
    void deleteCoffeenewsById(Integer id);
}
