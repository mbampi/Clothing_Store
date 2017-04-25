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
public class Store implements Loggable{
    private Account account;
    private final ArrayList<Account> accounts;
    private final ArrayList<Product> products;
    private Cart cart;
    
    public Store(){
        this.accounts = new ArrayList<>();
        this.products = new ArrayList<>();
        accounts.add(new Account("admin", "admin", true));
    }
    
    @Override
    public boolean login(String username, String password){
        Account accountTemp = this.accountByUsername(username);
        if(accountTemp!=null && accountTemp.getPassword().equals(password)){
            this.account = accountTemp;
            return true;
        }
        return false;
    }
    
    @Override
    public void logout(){
        this.cart = null;
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
    
    public Cart getCart(){
        return this.cart;
    }
    
    public boolean hasCart(){
        return this.cart!=null;
    }
    
    public String checkout(){
        String out = this.cart.toString();
        this.cart = null;
        return out;
    }
    
    public Product productById(int id){
        return products.get(id);
    }
    
    public Account accountById(int id){
        return accounts.get(id);
    }
    
    public String listAccounts(){
        String output = "\n\t"+"ID"+"\t"+"Username"+"\t"+"isAdmin";
        for(int i=0; i<this.accounts.size(); i++)
            output += "\n\t"+i+"\t"+this.accounts.get(i).getUsername()+"\t\t"+this.accounts.get(i).isAdmin();
        return output;
    }
    
    public String listProducts(){
        String output = "\n\t"+"ID"+"\t"+"Brand"+"\t"+"Name"+"\t"+"Price";
        for(int i=0; i<this.products.size(); i++)
            output += "\n\t"+i+"\t"+this.products.get(i).getBrand()+"\t"+this.products.get(i).getName()+"\t"+this.products.get(i).getPrice();
        return output;
    }
    
    //    Admin Operations
    public boolean createNewAccount(Account new_account){
        if(this.isAdmin()){
            accounts.add(new_account);
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
    
    public void addProduct(Product new_product){
        this.products.add(new_product);
    }
    
    public void editProduct(){
        
    
    };
    
    public boolean deleteProduct(int id){
        if(this.isAdmin()){
            products.remove(id);
            return true;
        }
        return false;
    }
    
    public void report(){}; //later
    
}
