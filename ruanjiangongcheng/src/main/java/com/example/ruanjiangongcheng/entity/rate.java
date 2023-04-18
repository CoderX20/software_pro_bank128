package com.example.ruanjiangongcheng.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "利率类")

public class rate {
    @ApiModelProperty(value = "type")
    private String type;
    @ApiModelProperty(value = "rate")
    private Double rate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "rate{" +
                "type='" + type + '\'' +
                ", rate=" + rate +
                '}';
    }
}
