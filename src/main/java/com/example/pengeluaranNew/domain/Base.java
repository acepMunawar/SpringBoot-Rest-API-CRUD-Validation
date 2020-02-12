package com.example.pengeluaranNew.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.hibernate.annotations.DynamicUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
public abstract class Base implements Serializable{
    @Id
    @Column(name="UUID", unique = true, length = 36, nullable=false)
    private String uuid;
  
    @PrePersist
    public void prePersist(){
        this.uuid = UUID.randomUUID().toString();
        
    }

 
}