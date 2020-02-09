package com.example.pengeluaranNew.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "USER")
@Entity
@Data
public class User {

    @Id
    @Column(name = "UUID", length = 36, unique = true, nullable = false)
    private String uuid;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }

}