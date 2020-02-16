package com.example.pengeluaranNew.vo;

import lombok.Data;

@Data
public class UserResponseVO extends UserRequestVO{
    private String uuid;
    private String name;
    private String address;
    private String email;
    private String phone;
    
    public UserResponseVO(){

    }

    public UserResponseVO(String uuid, String name, String address, String email, String phone)
    {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }


}