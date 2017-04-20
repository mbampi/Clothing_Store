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
    public boolean isLogin;
    public boolean isAdmin;
    private Account account;
    ArrayList<Account> accounts;
    
    public Store(){
        this.accounts = new ArrayList<>();
    }
    
    public boolean login(String username, String password){
        for(Account a : accounts){
            
        }

        //if(login correct)
            //account = Account logged;
            //if(admin)
                //go to admin page
            //else
                //go to cart
            return true;
        //else
        //return false;
    }
    
    public void logout(){
        //isLogin = false;
        //isAdmin = false;
        //go to login page
    }
    
    public void createNewAccount(String username, String password, boolean isAdmin){
        
    }
    
    
    
}
