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
public class Clothes extends Product{

    public Clothes(String name, String brand, double price, String description) {
        super(name, brand, price, description);
    }
    
    enum ClothingMaterial {Denim, Fur, Cotton, Silk};
    
    private ClothingMaterial material;
    
    

    
}
