package com.example.ruanjiangongcheng.entity;

import java.util.Date;

public class huoqibiao {
    private Integer id;
    private String card_number;
    private Date create_time;
    private Double money;
    private Date last_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }



    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    @Override
    public String toString() {
        return "huoqibiao{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", create_time='" + create_time + '\'' +
                ", money=" + money +
                ", last_time='" + last_time + '\'' +
                '}';
    }
}
