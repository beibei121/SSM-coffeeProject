package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.Coffeetype;
import org.ccunix.coffee.pojo.CoffeetypePOJO;

import java.util.List;

public interface ICoffeetypeService {
    /**
     * 查询所有咖啡类型列表
     * @param coffeetypePOJO
     * @return
     */
    List<Coffeetype> selectAllCoffeetype(CoffeetypePOJO coffeetypePOJO);
    /**
     * 查询所有咖啡类型列表
     * @return
     */
    List<Coffeetype> selectAllCoffeetypeByPag(CoffeetypePOJO coffeetypePOJO);

    /**
     * 咖啡类型添加
     * @param coffeetypePOJO
     * @return
     */

    Boolean addCoffeetype(CoffeetypePOJO coffeetypePOJO);

    /**
     * 根据id查询咖啡类型
     * @param id
     * @return
     */
    Coffeetype selectAllCoffeetypeById(Integer id);

    /**
     * 咖啡类型修改
     * @param coffeetypePOJO
     * @return
     */
    Boolean updateCoffeetype(CoffeetypePOJO coffeetypePOJO);

    /**
     * 咖啡类型删除
     * @param coffeetypePOJO
     * @return
     */
    Boolean deleteCoffeetypeById(CoffeetypePOJO coffeetypePOJO);

}
