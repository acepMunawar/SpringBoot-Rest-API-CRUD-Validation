package com.example.pengeluaranNew.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PengeluaranRequestVO {

    private String name;
    private String code;
    private String type;

    public PengeluaranRequestVO() {
    }

    public PengeluaranRequestVO(String name, String code, String type) {
        this.name = name;
        this.code = code;
        this.type = type;
    }

}