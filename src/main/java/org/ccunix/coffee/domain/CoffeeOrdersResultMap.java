package org.ccunix.coffee.domain;

import org.ccunix.coffee.pojo.CoffeeOrdersDetailPOJO;
import org.ccunix.coffee.pojo.CoffeeOrdersPOJO;

import java.util.List;

public class CoffeeOrdersResultMap extends CoffeeOrdersPOJO {
    /**
     * 订单扩展
     */
    private CoffeeUser coffeeUser;
    private CoffeeAddress coffeeAddress;

    /**
     * 详单扩展
      * @return
     */
    private List<CoffeeOrdersDetailResultMap> ordersDetailList;

    public List<CoffeeOrdersDetailResultMap> getOrdersDetailList() {
        return ordersDetailList;
    }

    public void setOrdersDetailList(List<CoffeeOrdersDetailResultMap> ordersDetailList) {
        this.ordersDetailList = ordersDetailList;
    }

    public CoffeeUser getCoffeeUser() {
        return coffeeUser;
    }

    public void setCoffeeUser(CoffeeUser coffeeUser) {
        this.coffeeUser = coffeeUser;
    }

    public CoffeeAddress getCoffeeAddress() {
        return coffeeAddress;
    }

    public void setCoffeeAddress(CoffeeAddress coffeeAddress) {
        this.coffeeAddress = coffeeAddress;
    }
}
