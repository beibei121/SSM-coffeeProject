package org.ccunix.coffee.domain;

import org.ccunix.coffee.pojo.CoffeeCommentsPOJO;

public class CoffeeCommentsResultMap extends CoffeeCommentsPOJO {
    /**
     * 扩展字段  用户信息
     */
    private CoffeeUser coffeeUser;
    /**
     * 扩展字段  咖啡信息
     */
    private Coffee coffee;

    public CoffeeUser getCoffeeUser() {
        return coffeeUser;
    }

    public void setCoffeeUser(CoffeeUser coffeeUser) {
        this.coffeeUser = coffeeUser;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
