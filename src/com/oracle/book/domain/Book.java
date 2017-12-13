package com.oracle.book.domain;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    //创建private字段
    private int id;
    private String name;
    private String type;
    private String author;
    private double discount;
    private double price;
    private int amount;
    private String profile;
    //创建需要的构造器
    public Book(){}
    public Book(String type, String author, double discount, double price, int amount, String profile) {
        this.type = type;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.amount = amount;
        this.profile = profile;
    }

    public Book(String name, String type, String author, double discount, double price, int amount, String profile) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.amount = amount;
        this.profile = profile;
    }

    public Book(int id, String name, String type, String author, double discount, double price, int amount, String profile) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.amount = amount;
        this.profile = profile;
    }
    
    
    //创建get和set方法
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    //重写toString方法
    @Override
    public String toString() {
        return id + "\t" + name + "\t" + type + "\t" + author + "\t" 
                + discount + "\t" + price + "\t" + amount + "\t" + profile;
    }
    
    
}
