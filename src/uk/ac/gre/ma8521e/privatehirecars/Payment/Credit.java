package uk.ac.gre.ma8521e.privatehirecars.Payment;

import java.math.BigDecimal;

/**
 *
 * @author micael
 */
public class Credit extends Payment implements ElectronicPayment{
    
    Card card;
    
    public Credit(BigDecimal amount, Card newCard) {
        super(amount);
        this.card=newCard;
    }
    
    @Override
    public boolean validateCard(){
        return true;
    }
    
    @Override
    public boolean isThereEnoughFunds(){
        return true;
    }
    
    @Override
    public void finalizePayment(){
        
    }
    
}
