package uk.ac.gre.ma8521e.privatehirecars.Payment;

/**
 *
 * @author micael
 */
public class Credit extends Payment implements ElectronicPayment{
    
    Card card;
    
    public Credit(int amount, Card newCard) {
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
