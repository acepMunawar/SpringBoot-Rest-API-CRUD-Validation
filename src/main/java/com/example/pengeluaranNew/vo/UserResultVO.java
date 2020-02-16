package com.example.pengeluaranNew.vo;

import lombok.Data;

@Data
public class UserResultVO {

    private Integer status;
    private String message;
    private Object results;

    public UserResultVO() {
    }

    public UserResultVO(Integer status,String message,Object results ){
        this.status = status;
        this.message = message;
        this.results = results;
    }
}