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
public class Manager extends Account implements Admin{

    public Manager(String username, String password) {
        super(username, password, true);
    }
    
    public void addProduct(){};
    
    public void editProduct(){};
    
    public void deleteProduct(){};
    
    public void report(){};
    
    @Override
    public void createAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
