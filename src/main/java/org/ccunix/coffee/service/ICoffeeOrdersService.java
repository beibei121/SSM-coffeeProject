package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.CoffeeOrdersResultMap;
import org.ccunix.coffee.vo.OrdersCustomVO;

import java.util.List;

public interface ICoffeeOrdersService {
    /**
     * 根据条件查询订单信息
     * @param ordersCustomVO
     * @return
     */
    List<CoffeeOrdersResultMap> selectAllOrdersByPage(OrdersCustomVO ordersCustomVO);

    /**
     * 发货 改变货物状态
     * @param id
     */
    void toDeliver(Integer id);

    /**
     * 根据id查询点单详情
     * @param id
     * @return
     */
    CoffeeOrdersResultMap selectOrdersDetailListById(Integer id);
}
