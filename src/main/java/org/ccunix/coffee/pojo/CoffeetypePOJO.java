package org.ccunix.coffee.pojo;

import java.io.Serializable;

public class CoffeetypePOJO implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeetypePOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
