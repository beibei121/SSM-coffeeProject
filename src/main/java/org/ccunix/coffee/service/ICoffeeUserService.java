package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.CoffeeUser;
import org.ccunix.coffee.pojo.CoffeeUserPOJO;

import java.util.List;

public interface ICoffeeUserService {
    /**
     * 会员用户查询
     * @param coffeeUserPOJO
     * @return
     */
    List<CoffeeUser> selectAllUserByPage(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 是否存在相同用户名
     * @param username
     * @return
     */
    CoffeeUser isExistSameUsername(String username);

    /**
     * 添加会员
     * @param coffeeUserPOJO
     */
    void addCoffeeUser(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 根据id获得会员信息
     * @return
     */
    CoffeeUser selectAllUserById(Integer id);

    /**
     * 更新用户信息
     * @param coffeeUserPOJO
     */
    void updateCoffee(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 删除会员
     * @param id
     */
    void deleteUserById(Integer id);
}
