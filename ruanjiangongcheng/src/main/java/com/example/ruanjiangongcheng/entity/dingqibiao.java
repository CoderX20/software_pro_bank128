package com.example.ruanjiangongcheng.entity;

import java.util.Date;

public class dingqibiao {
    private Integer id;
    private String card_number;
    private Double money;
    private String period;
    private Float rate;
    private Date create_time;

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "dingqibiao{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", money=" + money +
                ", period='" + period + '\'' +
                ", rate=" + rate +
                ", create_time=" + create_time +
                '}';
    }
}
