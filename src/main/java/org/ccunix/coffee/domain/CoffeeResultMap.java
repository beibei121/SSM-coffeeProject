package org.ccunix.coffee.domain;

import org.ccunix.coffee.pojo.CoffeePOJO;

public class CoffeeResultMap extends CoffeePOJO {
    //扩展字段
    private Coffeetype coffeetype;//咖啡类型对象
    private CoffeeTaste coffeeTaste;//咖啡口味对象

    public Coffeetype getCoffeetype() {
        return coffeetype;
    }

    public void setCoffeetype(Coffeetype coffeetype) {
        this.coffeetype = coffeetype;
    }

    public CoffeeTaste getCoffeeTaste() {
        return coffeeTaste;
    }

    public void setCoffeeTaste(CoffeeTaste coffeeTaste) {
        this.coffeeTaste = coffeeTaste;
    }
}
