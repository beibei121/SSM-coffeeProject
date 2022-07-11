package org.ccunix.coffee.domain;

import org.ccunix.coffee.pojo.CoffeePOJO;

public class Coffee extends CoffeePOJO {
    @Override
    public String toString() {
        return "Coffee{}"+super.toString();
    }

    //扩展字段
    private String coffeetypeName;//咖啡类型名称
    private String tasteName;//咖啡口味名称

    public String getCoffeetypeName() {
        return coffeetypeName;
    }

    public void setCoffeetypeName(String coffeetypeName) {
        this.coffeetypeName = coffeetypeName;
    }

    public String getTasteName() {
        return tasteName;
    }

    public void setTasteName(String tasteName) {
        this.tasteName = tasteName;
    }
}
