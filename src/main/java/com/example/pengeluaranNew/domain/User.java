package com.example.pengeluaranNew.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;
import java.util.UUID;

import org.hibernate.annotations.DynamicUpdate;


@Table(name = "USER")
@Data
@DynamicUpdate
@Entity
public class User extends Base {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;


}