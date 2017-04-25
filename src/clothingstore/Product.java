/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstore;

/**
 *
 * @author matheus
 */
public abstract class Product{
    private final String name;
    private final String brand;
    private final double price;
    private final String description;

    public Product(String name, String brand, double price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\tBrand: " + this.brand + "\tPrice: " + this.price + "\tDescription: " + this.description;
    }
    
    
}
