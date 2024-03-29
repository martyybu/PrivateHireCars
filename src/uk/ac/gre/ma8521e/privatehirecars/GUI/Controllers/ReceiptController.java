/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import javax.swing.JFrame;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.ReceiptView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;


/**
 *
 * @author micae
 */
public class ReceiptController {
    
    private final ReceiptView VIEW;
    private final Journey JOURNEY;
    
    public ReceiptController(Journey journey,ReceiptView receipt){
        this.JOURNEY=journey;
        this.VIEW=receipt;
        generateReceipt();
        VIEW.setTitle("Receipt");
        VIEW.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    
    public void generateReceipt(){
        VIEW.getDate().setText(""+JOURNEY.getDate());
       VIEW.getFrom().setText(JOURNEY.getStartingLocation());
       VIEW.getTo().setText(JOURNEY.getDestination());
       VIEW.getDuration().setText(JOURNEY.getDuration()+" min");
       VIEW.getTotal().setText("£"+JOURNEY.getPayment().getAmount()+"");
    }
    
}
