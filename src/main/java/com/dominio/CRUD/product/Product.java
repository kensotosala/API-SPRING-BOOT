package com.dominio.CRUD.product;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private float price;
    private LocalDate date;
    @Transient
    private int antiquity;

    public Product() {
    }

    public Product(int id, String name, float price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Product(String name, float price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAntiquity() {
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }
}
