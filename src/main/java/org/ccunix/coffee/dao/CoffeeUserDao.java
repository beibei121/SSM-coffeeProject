package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.CoffeeUser;
import org.ccunix.coffee.pojo.CoffeeUserPOJO;

import java.util.List;

public interface CoffeeUserDao {
    /**
     * 会员用户信息查询
     * @param coffeeUserPOJO
     * @return
     */
    List<CoffeeUser> selectAllUserByPage(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 更具用户昵称去查询用户信息
     * @param username
     * @return
     */
    List<CoffeeUser> selectUserListByUserName(String username);

    /**
     * 添加会员信息
     * @param coffeeUserPOJO
     */
    void addCoffeeUser(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 根据id获得会员信息
     * @param id
     * @return
     */
    CoffeeUser selectAllUserById(Integer id);

    /**
     * 更新用户信息
     * @param coffeeUserPOJO
     */
    void updateCoffee(CoffeeUserPOJO coffeeUserPOJO);

    /**
     * 删除会员  这是个假删除  改变状态 逻辑删除
     * @param id
     */
    void deleteUserById(Integer id);
}
