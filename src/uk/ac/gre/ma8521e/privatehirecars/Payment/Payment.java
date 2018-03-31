/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Payment;

import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micae
 */
public class Payment {
    
    int amount;
    Journey journey;
    
    public Payment(Journey journey){
        this.amount = journey.getPrice();
    }
    
    public String[] getReceipt(){
        return new String[4];
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public void setAmount(int newAmount){
        this.amount=newAmount;
    }
    
}
