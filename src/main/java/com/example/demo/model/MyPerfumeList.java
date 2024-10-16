package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "MyPerfumes")
public class MyPerfumeList {
    @Id
    private  int id;
    private String name;
    private String company;
    private String price;
    private String img;

    public MyPerfumeList(int id, String name, String company, String price, String img) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.img = img;
    }

    public MyPerfumeList() {
        super();
    }
}
