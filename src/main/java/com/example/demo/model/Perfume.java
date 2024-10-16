package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String company;
    private String price;
    private String img;

    public Perfume(int id, String name, String company, String price, String img) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.img = img;
    }

    public Perfume() {
        super();
    }
}
