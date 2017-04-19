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
public class Bill {
    enum PaymentMethod{Cash, Debit_Card, Credit_Card, Check}
    
    private PaymentMethod payment_method;
    private double price;
    
}
