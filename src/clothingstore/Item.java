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
public class Item {
    private final int quantity;
    private final double price;
    private final Product product;

    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.price = this.product.getPrice() * this.quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    
    public String getName(){
        return product.getName();
    }
    
}
