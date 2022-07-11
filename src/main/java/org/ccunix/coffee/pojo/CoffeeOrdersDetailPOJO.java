package org.ccunix.coffee.pojo;

import java.io.Serializable;

public class CoffeeOrdersDetailPOJO implements Serializable {
    private Integer id;
    private Integer ordersId;
    private Integer coffeeId;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
