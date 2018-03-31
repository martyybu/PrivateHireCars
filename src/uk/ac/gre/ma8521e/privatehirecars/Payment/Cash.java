package uk.ac.gre.ma8521e.privatehirecars.Payment;

/**
 *
 * @author micael
 */
public class Cash extends Payment{
    
    float cashGiven = 0;
    float change;
    
    public Cash(int amount) {
        super(amount);
    }
    
}
