package uk.ac.gre.ma8521e.privatehirecars.Payment;

import java.math.BigDecimal;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micael
 */
public class Payment {
    
    BigDecimal amount;
    final Journey journey;
    
    public Payment(Journey journey){
        this.amount = journey.getPrice();
        this.journey = journey;
    }
    
    public String[] getReceipt(){
        return new String[4];
    }
    
    public BigDecimal getAmount(){
        return this.amount;
    }
    
    public Journey getJourney(){
       return this.journey;
    }
    
    public void setAmount(BigDecimal newAmount){
        this.amount=newAmount;
    }
    
}
