package com.example.pengeluaranNew.domain;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Data;

@Table(name = "PENGELUARAN")
@Entity
@Data
public class Pengeluaran extends Base {


    
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TYPE", nullable = false)
    private String type;


}