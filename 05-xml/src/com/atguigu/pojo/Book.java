package com.atguigu.pojo;

import org.dom4j.Element;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2020-04-15 21:28
 */
public class Book {
    private String sn;
    private String name;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String sn, String name, double price, String author) {
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book(String sn, Element name, double parseDouble, String author) {
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
