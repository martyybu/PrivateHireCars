package uk.ac.gre.ma8521e.privatehirecars.Payment;

import java.math.BigDecimal;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micael
 */
public class Payment {
    private Integer ID;
    private BigDecimal amount;

    public Payment(BigDecimal amount){
        this.amount = amount;
    }
    
    public Integer getID(){
        return this.ID;
    }
    
    public String[] getReceipt(){
        return new String[4];
    }
    
    public BigDecimal getAmount(){
        return this.amount;
    }
    
    
    public void setAmount(BigDecimal newAmount){
        this.amount=newAmount;
    }
    
}
