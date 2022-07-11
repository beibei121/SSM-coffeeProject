package org.ccunix.coffee.vo;


import org.ccunix.coffee.pojo.CoffeeCommentsPOJO;

public class CommentsCustomVO extends CoffeeCommentsPOJO {
    private String userName;//输入会员名称
    private String coffeeName;//输入咖啡名称
    private String startTime;//开始日期
    private String endsTime;//结束日期

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndsTime() {
        return endsTime;
    }

    public void setEndsTime(String endsTime) {
        this.endsTime = endsTime;
    }
}
