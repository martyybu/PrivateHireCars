package uk.ac.gre.ma8521e.privatehirecars.Payment;

import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micael
 */
public class Credit extends Payment implements ElectronicPayment{
    
    Card card;
    
    public Credit(Journey journey, Card newCard) {
        super(journey);
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
