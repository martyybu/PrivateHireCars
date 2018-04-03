/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import uk.ac.gre.ma8521e.privatehirecars.Payment.Payment;

/**
 *
 * @author micae
 */
public interface PaymentDao {
    
    public Payment getPayment(int ID);
    
    public void createPayment(Payment payment);
    
}
