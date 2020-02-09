package com.example.pengeluaranNew.vo;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;


@Data
@Setter
@Getter
public class UserRequestVO {
    private String name;
    private String address;
    private String phone;
    private String email;

    public UserRequestVO(){

    }

    public UserRequestVO(String name,String address,String phone,String email)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }

}