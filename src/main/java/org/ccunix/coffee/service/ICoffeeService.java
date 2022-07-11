package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.Coffee;
import org.ccunix.coffee.domain.CoffeeResultMap;
import org.ccunix.coffee.pojo.CoffeePOJO;

import java.util.List;

public interface ICoffeeService {
    /**
     *
     * @param coffeePOJO
     * @return
     */
    List<Coffee> selectAllCoffee(CoffeePOJO coffeePOJO);

    /**
     *
     * @param coffeePOJO  ResultMap 对象扩展模式
     * @return
     */
    List<CoffeeResultMap> selectAllCoffeeResultMap(CoffeePOJO coffeePOJO);

    /**
     * 添加咖啡
     * @param coffeePOJO
     */
    void addCoffee(CoffeePOJO coffeePOJO);

    /**
     * 根据id查询单个商品详情
     * @param id
     * @return
     */
    CoffeeResultMap selectCoffeeById(Integer id);

    /**
     * 修改咖啡数据
     * @param coffeePOJO
     */
    void updateCoffee(CoffeePOJO coffeePOJO);

    /**
     * 删除咖啡
     * @param id
     */
    void deleteCoffee(Integer id);
}
