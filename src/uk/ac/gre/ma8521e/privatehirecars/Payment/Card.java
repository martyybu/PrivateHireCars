/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Payment;

import java.util.Date;

/**
 *
 * @author micae
 */
public class Card {

     final Integer CARDNO;
     final Date EXPIRYDATE;
     final String CARDNAME;
     final int CVC;
     
     public Card(Integer cardno,Date expiryDate,String Cardname,int CVC){
         this.CARDNO=cardno;
         this.EXPIRYDATE=expiryDate;
         this.CARDNAME=Cardname;
         this.CVC = CVC;
     }

}
