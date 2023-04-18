package com.example.ruanjiangongcheng.entity.retuen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "活期表信息类")
public class huoqi {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty(value = "card_number")
    private String card_number;
    @ApiModelProperty(value = "create_time")
    private Date create_time;
    @ApiModelProperty(value = "money")
    private Double money;



    @ApiModelProperty(value = "last_time")
    private Date last_time;
    @ApiModelProperty(value = "rate")
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

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


    public Date getLast_time() {
        return last_time;
    }

    public huoqi(Integer id, String card_number, Date create_time, Double money, Date last_time, Double rate) {
        this.id = id;
        this.card_number = card_number;
        this.create_time = create_time;
        this.money = money;
        this.last_time = last_time;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "huoqibiao{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", create_time=" + create_time +
                ", money=" + money +
                ", last_time=" + last_time +
                ", rate=" + rate +
                '}';
    }



    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

}
