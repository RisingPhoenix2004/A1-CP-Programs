package com.example.demo;

public class Laptop {
    private int lid;
    private String brand;

    public Laptop() {
        super();
        System.out.println("Laptop object created");
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public int getLid() {
        return lid;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void laptoptest(){
        System.out.println("Laptop test");
    }
    @Override
    public String toString() {
        return "Laptop {lid=" + lid + ", brand=" + brand + "}";
    }
    public Laptop getLaptop(){
        return this;
    }
}
