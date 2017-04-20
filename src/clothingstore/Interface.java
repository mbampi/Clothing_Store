/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstore;

import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class Interface {
    static Store store;
    
    public static void main(String[] args) {
        store = new Store();
        do{
            if(!Interface.LoginPage()){
                System.out.println("Login Page ag");
                continue;
            }
            if(store.isAdmin()){
                System.out.println("Admin Page");
                Interface.adminPage();
            }else{
                System.out.println("Cart Page");
                Interface.cartPage();
            }
        }while(true);
    }
    
    
    public static boolean LoginPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n----- Clothing Store Login Page -----");
        System.out.println("Username: ");
        String input_username = scan.next();
        System.out.println("Password: ");
        String input_password = scan.next();
        return (store.login(input_username, input_password));
    }
    
    public static void adminPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n----- Clothing Store Admin Page -----");
        System.out.println("1 - Account Manager");
        System.out.println("2 - Report Manager ");
        System.out.println("3 - Product Manager ");
        System.out.println("4 - Shopping Cart ");
        int input_op = scan.nextInt();
        switch(input_op){
            case 1:
                //Account Manager
                break;
            case 2:
                //Report Manager
                break;
            case 3:
                //Product Manager
                break;
            case 4:
                //Shopping Cart
                break;
            default:
                break;
        }
    }
    
    public static void cartPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n----- Clothing Store Cart Page -----");
        System.out.println("1 - Add Item");
        System.out.println("2 - Delete Item ");
        System.out.println("3 - Checkout ");
        System.out.println("4 - Back ");
        System.out.println("4 - Logout ");
        int input_op = scan.nextInt();
        switch(input_op){
            case 1:
                //Add Item
                break;
            case 2:
                //Delete Item
                break;
            case 3:
                //Checkout
                break;
            case 4:
                //Back
                break;
            case 5:
                //Logout
                break;
            default:
                break;
        }
    }
    
    
    
    
}
