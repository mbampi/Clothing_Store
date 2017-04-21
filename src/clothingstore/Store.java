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
    ArrayList<Account> accounts;
    private Cart cart;
    
    public Store(){
        this.accounts = new ArrayList<>();
        accounts.add(new Manager("admin", "admin"));
    }
    
    public boolean login(String username, String password){
        Account accountTemp = this.AccountByUsername(username);
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
    
    private Account AccountByUsername(String username){
        for(Account a : accounts){
            if(a.getUsername().equals(username))
                return a;
        }
        return null;
    }
    
    //     Just Admin Operations
    public boolean createNewAccount(String username, String password, boolean isAdmin){
        if(this.isAdmin()){
            if(isAdmin)
                accounts.add(new Manager(username, password));
            else
                accounts.add(new Employee(username, password));
            return true;
        }
        return false;
    }
    
    public boolean deleteAccount(String username){
        if(this.isAdmin()){
            Account accountTemp = this.AccountByUsername(username);
            accounts.remove(accountTemp);
            return true;
        }
        return false;
    }
    
}
