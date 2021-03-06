/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstore;

import clothingstore.Shoes.Category;
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
        do{
        System.out.println("\n\n----- Clothing Store Admin Page -----");
        System.out.println("1 - Account Manager");
        System.out.println("2 - Product Manager ");
        System.out.println("3 - Shopping Cart ");
        System.out.println("4 - Day Report ");
        System.out.println("5 - Logout ");
        int input_op = Integer.parseInt(UI.getInput("Operation: "));
        switch(input_op){
            case 1:
                //Account Manager
                UI.accountManagerPage();
                break;
            case 2:
                //Product Manager
                UI.productManagerPage();
                break;
            case 3:
                //Shopping Cart
                UI.cartPage();
                break;
            case 4:
                //Report
                System.out.println(store.dayReport());
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
    
    private static void cartPage(){
        Scanner scan = new Scanner(System.in);
        do{
        System.out.println("\n\n----- Clothing Store Shopping Cart -----");
        if(!store.hasCart())
            store.newCart();
        System.out.println(store.getCart().toString());
        System.out.println("1 - Add Item");
        System.out.println("2 - Delete Item ");
        System.out.println("3 - Checkout ");
        System.out.println("4 - Logout ");
        int input_op = scan.nextInt();
        switch(input_op){
            case 1:
                //Add Item
                UI.newItemPage();
                break;
            case 2:
                //Delete Item
                int id = Integer.parseInt(UI.getInput("Product ID: "));
                store.getCart().deleteItem(id);
                break;
            case 3:
                //Checkout
                System.out.println("\n----- Shopping Cart Checkout -----");
                System.out.println(store.checkout()); //store.cart = null -> store.newCart
                System.out.println("\n----- ---------------------- -----");
                return;
            case 4:
                //Logout
                store.logout();
                return;
            default:
                break;
        }
        }while(true);
    }
    
    private static void newItemPage(){
        System.out.println("\n\n----- Clothing Store New Item -----");
        System.out.println(store.listProducts());
        Product item_product = store.productById(Integer.parseInt(UI.getInput("Product ID: ")));
        int quantity = Integer.parseInt(UI.getInput("Quantity: "));
        Item new_item = new Item(quantity, item_product);
        store.getCart().addItem(new_item);
    }
    
    private static void productManagerPage(){
        System.out.println("\n\n----- Clothing Store Product Manager -----");
        System.out.println(store.listProducts());
        System.out.println("1 - Add Product");
        System.out.println("2 - Delete Product ");
        System.out.println("3 - Back ");
        int input_op = Integer.parseInt(UI.getInput("Operation: "));
        switch(input_op){
            case 1:
                //Add Product
                UI.newProductPage();
                break;
            case 2:
                //Delete Product
                int id = Integer.parseInt(UI.getInput("Product ID: "));
                store.deleteProduct(id);
                break;
            case 3:
                //Back
                break;
            default:
                break;
        }
    }
    
    private static void newProductPage(){
        Product new_product;
        System.out.println("\n\n----- Clothing Store New Product -----");
        String new_name = UI.getInput("new Name: ");
        String new_brand = UI.getInput("new Brand: ");
        float new_price = Float.parseFloat(UI.getInput("new Price: "));
        String new_description = UI.getInput("new Description: ");
        String c = UI.getInput("Shoes(s) or Clothes(c): ");
        if(c.equals("s")){
            String category_abrev = UI.getInput("new Category: Formal(f), Casual(c), Running(r), Slippers(s), Other(o)");
            Category new_category;
            switch(category_abrev){
                case "f":
                    new_category = Category.Formal;
                    break;
                case "c":
                    new_category = Category.Casual;
                    break;
                case "r":
                    new_category = Category.Running;
                    break;
                case "s":
                    new_category = Category.Slippers;
                    break;
                default:
                    new_category = Category.Other;
                    break;
            }
            new_product = new Shoes(new_name, new_brand, new_price, new_description, new_category);
        }else
            new_product = new Clothes(new_name, new_brand, new_price, new_description);
        
        store.addProduct(new_product);
    }
    
    private static void accountManagerPage(){
        System.out.println("\n\n----- Clothing Store Account Manager -----");
        System.out.println(store.listAccounts());
        System.out.println("1 - Add Account");
        System.out.println("2 - Delete Account ");
        System.out.println("3 - Back ");
        int input_op = Integer.parseInt(UI.getInput("Operation: "));
        switch(input_op){
            case 1:
                //Add Account
                UI.newAccountPage();
                break;
            case 2:
                //Delete Account
                int id = Integer.parseInt(UI.getInput("Account ID: "));
                store.deleteAccount(id);
                break;
            case 3:
                //Back
                break;
            default:
                break;
        }
    }
    
    private static void newAccountPage(){
        System.out.println("\n\n----- Clothing Store New Account -----");
        String new_username = UI.getInput("new Username: ");
        String new_password = UI.getInput("new Password: ");
        boolean admin = UI.getInput("Admin? (y or n)").equals("y");
        Account new_account = new Account(new_username, new_password, admin);
        store.createNewAccount(new_account);
    }
    
    private static String getInput(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.next().trim();
    }
    
    
}
