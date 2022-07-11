package org.ccunix.coffee.pojo;

import java.io.Serializable;

/**
 * 咖啡
 */
public class CoffeePOJO implements Serializable {
    private Integer id;//编号
    private String picture;//图片
    private String name;//名称
    private Integer coffeetypeId;//类型id
    private Double price;//价格
    private Integer num;//库存
    private String netweight;//净含量
    private String qualitydate;//保质期
    private Integer tasteId;//口味id
    private String brand;//品牌
    private String storage;//储存方法
    private String detail;//详细介绍


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoffeetypeId() {
        return coffeetypeId;
    }

    public void setCoffeetypeId(Integer coffeetypeId) {
        this.coffeetypeId = coffeetypeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNetweight() {
        return netweight;
    }

    public void setNetweight(String netweight) {
        this.netweight = netweight;
    }

    public String getQualitydate() {
        return qualitydate;
    }

    public void setQualitydate(String qualitydate) {
        this.qualitydate = qualitydate;
    }

    public Integer getTasteId() {
        return tasteId;
    }

    public void setTasteId(Integer tasteId) {
        this.tasteId = tasteId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CoffeePOJO{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", coffeetypeId=" + coffeetypeId +
                ", price=" + price +
                ", num=" + num +
                ", netweight='" + netweight + '\'' +
                ", qualitydate='" + qualitydate + '\'' +
                ", tasteId=" + tasteId +
                ", brand='" + brand + '\'' +
                ", storage='" + storage + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
