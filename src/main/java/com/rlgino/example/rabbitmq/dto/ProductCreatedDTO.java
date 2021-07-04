package com.rlgino.example.rabbitmq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCreatedDTO {
    @JsonProperty("prod_id")
    private Integer prodID;
    @JsonProperty("user_id")
    private Integer userID;

    public Integer getProdID() {
        return prodID;
    }

    public void setProdID(Integer prodID) {
        this.prodID = prodID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
