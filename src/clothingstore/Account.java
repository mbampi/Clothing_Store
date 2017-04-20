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
public abstract class Account {
    private String username;
    private String password;
    private boolean Admin;

    public Account(String username, String password, boolean Admin) {
        this.username = username;
        this.password = password;
        this.Admin = Admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean Admin) {
        this.Admin = Admin;
    }
    
}
