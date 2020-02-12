package com.example.pengeluaranNew.vo;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserRequestVO {

    @NotBlank(message = "Name can't be empty")
    private String name ;
    
    @NotBlank(message = "address can't be empty")
    private String address;

    @NotBlank(message = "email can't be empty")
    private String email;

    @NotBlank(message = "phone can't be empty")
    private String phone;
    

    public UserRequestVO(){}
    


}