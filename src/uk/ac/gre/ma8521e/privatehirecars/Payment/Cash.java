package uk.ac.gre.ma8521e.privatehirecars.Payment;

import java.math.BigDecimal;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micael
 */
public class Cash extends Payment{
    
    final BigDecimal cashGiven;
    BigDecimal change;
    
    public Cash(Journey journey, BigDecimal cashGiven) {
        super(journey);
        this.cashGiven= cashGiven;
    }
    
    public BigDecimal getChange(){return getAmount().subtract(getCashGiven());}
    
    public BigDecimal getCashGiven(){return this.cashGiven;}
    
}
