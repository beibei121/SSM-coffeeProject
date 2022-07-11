package org.ccunix.coffee.vo;


import org.ccunix.coffee.pojo.CoffeeOrdersPOJO;

public class OrdersCustomVO extends CoffeeOrdersPOJO {
    private String addressname;
    private String phone;
    private String userName;
    private String linkman;

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
}
