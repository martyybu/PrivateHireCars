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

     public final Integer CARDNO;
     public final Integer PASSENGERID;
     public final Date EXPIRYDATE;
     public final String CARDNAME;
     public final int CVC;
     
     public Card(Integer PassengerID,Integer cardno,Date expiryDate,String Cardname,int CVC){
         this.CARDNO=cardno;
         this.PASSENGERID = PassengerID;
         this.EXPIRYDATE=expiryDate;
         this.CARDNAME=Cardname;
         this.CVC = CVC;
     }

     @Override
      public String toString(){
          return "CARDNO "+this.CARDNO+", "+this.PASSENGERID+", "+this.CARDNAME;
      }
}
