package com.example.ruanjiangongcheng.entity.retuen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "定期表信息类")
public class dingqi {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty(value = "card_number")
    private String card_number;
    @ApiModelProperty(value = "money")
    private Double money;
    @ApiModelProperty(value = "period")
    private String period;
    @ApiModelProperty(value = "rate")
    private Double rate;
    @ApiModelProperty(value = "create_time")
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public dingqi(Integer id, String card_number, Double money, String period, Double rate, Date create_time) {
        this.id = id;
        this.card_number = card_number;
        this.money = money;
        this.period = period;
        this.rate = rate;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "dingqi{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", money=" + money +
                ", period='" + period + '\'' +
                ", rate=" + rate +
                ", create_time=" + create_time +
                '}';
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

//    @Override
//    public String toString() {
//        return "dingqibiao{" +
//                "id=" + id +
//                ", card_number='" + card_number + '\'' +
//                ", money=" + money +
//                ", period='" + period + '\'' +
//                ", rate=" + rate +
//                ", create_time=" + create_time +
//                '}';
//    }

}