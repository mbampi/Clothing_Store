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
public class Shoes extends Product{

    enum Category {Formal, Casual, Running, Slippers};
    
    private Category category;
    
    public Shoes(String name, String brand, double price, String description) {
        super(name, brand, price, description);
    }
    
    @Override
    public String toString(){
        return super.toString() + "\tCategory: " + this.category;
    }

}
