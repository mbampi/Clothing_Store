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
public class UI {
    static Store store;
    
    public static void main(String[] args) {
        store = new Store();
        do{
            if(!UI.LoginPage()) //If login error, keeps on loginPage
                continue;
            if(store.isAdmin())
                UI.adminPage();
            else
                UI.cartPage();
        }while(true);
    }
    
    private static boolean LoginPage(){
        System.out.println("\n\n----- Clothing Store Login Page -----");
        String input_username = UI.getInput("Username: ");
        String input_password = UI.getInput("Password: ");
        return (store.login(input_username, input_password));
    }
    
    private static void adminPage(){
        System.out.println("\n\n----- Clothing Store Admin Page -----");
        System.out.println("1 - Account Manager");
        System.out.println("2 - Report Manager ");
        System.out.println("3 - Product Manager ");
        System.out.println("4 - Shopping Cart ");
        int input_op = Integer.parseInt(UI.getInput("Operation: "));
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
                UI.cartPage();
                break;
            default:
                break;
        }
    }
    
    private static void cartPage(){
        Scanner scan = new Scanner(System.in);
        do{
        System.out.println("\n\n----- Clothing Store Shopping Cart -----");
        System.out.println("1 - Add Item");
        System.out.println("2 - Delete Item ");
        System.out.println("3 - Checkout ");
        System.out.println("4 - Back ");
        System.out.println("5 - Logout ");
        int input_op = scan.nextInt();
        switch(input_op){
            case 1:
                //Add Item
                UI.newItemPage();
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
                store.logout();
                return;
            default:
                break;
        }
        }while(true);
    }
    
    private static void newItemPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n----- Clothing Store New Item -----");
        store.listProducts();
        Product item_product = store.productById(Integer.parseInt(UI.getInput("Product ID: ")));
        int quantity = Integer.parseInt(UI.getInput("Quantity: "));
        Item new_item = new Item(quantity, item_product);
        store.addCartItem(new_item);
    }
    
    private static void accountManagerPage(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n----- Clothing Store Account Manager -----");
        System.out.println("1 - Add Account");
        System.out.println("2 - Delete Account ");
        System.out.println("3 - Edit Account ");
        System.out.println("4 - Back ");
        int input_op = Integer.parseInt(UI.getInput("Operation: "));
        switch(input_op){
            case 1:
                //Add Account
                
                break;
            case 2:
                //Delete Account
                
                break;
            case 3:
                //Edit Account
                
                break;
            case 4:
                //Back
                break;
            default:
                break;
        }
    }
    
    private static String getInput(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.next().trim();
    }
    
    
}
