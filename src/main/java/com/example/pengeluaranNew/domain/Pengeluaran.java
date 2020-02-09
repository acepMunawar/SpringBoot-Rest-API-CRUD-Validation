package com.example.pengeluaranNew.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "PENGELUARAN")
@Entity
@Data
public class Pengeluaran {

    @Id
    @Column(name = "UUID", length = 36, unique = true, nullable = false)
    private String uuid;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @PrePersist
    public void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }

}