package org.ccunix.coffee.domain;

import org.ccunix.coffee.pojo.CoffeeOrdersDetailPOJO;

public class CoffeeOrdersDetailResultMap extends CoffeeOrdersDetailPOJO {
    /**
     * 扩展对象
     */
    private Coffee coffee;

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
