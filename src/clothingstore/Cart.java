/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstore;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author matheus
 */
public class Cart {
    private final int id;
    private double total;
    private double sub_total;
    private static final double TAX  = 0.10;
    private int number_of_products;
    private Date date;
    private final Account account;
    private ArrayList<Item> items;

    public Cart(Account account) {
        this.id = 1;//generate_id
        this.sub_total = 0;
        this.total = 0;
        this.number_of_products = 0;
        //this.date = //todaysdate
        this.items =  new ArrayList<>();
        this.account = account;
    }
    
    public void addItem(Item item){
        this.items.add(item);
        this.number_of_products += item.getQuantity();
        this.sub_total += item.getPrice();
        this.updateTotal();
    }
    
    public void deleteItem(int n){
        Item itemTemp = items.get(n-1);
        this.number_of_products -= itemTemp.getQuantity();
        this.sub_total -= itemTemp.getPrice();
        this.updateTotal();
        this.items.remove(itemTemp);
    }
    
    private void updateTotal(){
        this.total = this.sub_total+(this.sub_total*TAX);
    }
    
    @Override
    public String toString(){
        String output =  "\nShopping Cart "+this.id;
        output += "\n"+ "ID" + "\t"+ "Item" + "\t" + "Quantity" + "\t" + "Price";
        int n = 0;
        for(Item i : items){
            n++;
            output += "\n"+ n + "\t"+ i.getName() + "\t" + i.getQuantity() + "\t" + i.getPrice();
        }
        output += "\nProducts: "+this.number_of_products + "  Sub-total: "+this.sub_total+"  Tax: "+ Cart.TAX*100+"%"+"  TOTAL: "+this.total;
        return output;
    }
    
}
