package com.example.pengeluaranNew.vo;

import lombok.Data;

@Data
public class UserResultVO {

    private Integer Status;
    private String Message;
    private Object Results;

    public UserResultVO() {
    }

    public UserResultVO(Integer Status,String Message,Object Results ){
        this.Status = Status;
        this.Message = Message;
        this.Results = Results;
    }
}