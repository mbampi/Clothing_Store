/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstore;

import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Store {
    private Account account;
    private ArrayList<Account> accounts;
    private ArrayList<Product> products;
    private Cart cart;
    
    public Store(){
        this.accounts = new ArrayList<>();
        accounts.add(new Account("admin", "admin", true));
    }
    
    public boolean login(String username, String password){
        Account accountTemp = this.accountByUsername(username);
        if(accountTemp!=null && accountTemp.getPassword().equals(password)){
            this.account = accountTemp;
            return true;
        }
        return false;
    }
    
    public void logout(){
        this.account = null;
    }
    
    public void newCart(){
        this.cart = new Cart(this.account);
    }
    
    public boolean isAdmin(){
        return account.isAdmin();
    }
    
    public boolean isLogin(){
        return !(account==null);
    }
    
    public Account accountByUsername(String username){
        for(Account a : accounts){
            if(a.getUsername().equals(username))
                return a;
        }
        return null;
    }
    
    public Product productById(int id){
        return products.get(id);
    }
    
    public Account accountById(int id){
        return accounts.get(id);
    }
    
    public String listAccounts(){
        String output = "\t"+"ID"+"\t"+"Username"+"\t"+"isAdmin";
        for(int i=0; i<this.accounts.size(); i++)
            output += "\t"+i+"\t"+this.accounts.get(i).getUsername()+"\t"+this.accounts.get(i).isAdmin();
        return output;
    }
    
    public String listProducts(){
        String output = "\t"+"ID"+"\t"+"Brand"+"\t"+"Name"+"\t"+"Price";
        for(int i=0; i<this.products.size(); i++)
            output += "\t"+i+"\t"+this.products.get(i).getBrand()+"\t"+this.products.get(i).getName()+"\t"+this.products.get(i).getPrice();
        return output;
    }
        
    public void addCartItem(Item new_item){
        this.cart.addItem(new_item);
    }
    
    //    Admin Operations
    public boolean createNewAccount(String username, String password, boolean admin){
        if(this.isAdmin()){
            accounts.add(new Account(username, password, admin));
            return true;
        }
        return false;
    }
    
    public boolean deleteAccount(int id){
        if(this.isAdmin()){
            accounts.remove(id);
            return true;
        }
        return false;
    }
    
    public void addClothes(){
        
    }
    
    public void addShoes(){
        
    }
    
    public void editProduct(){};
    
    public void deleteProduct(){};
    
    public void report(){}; //later
    
}
