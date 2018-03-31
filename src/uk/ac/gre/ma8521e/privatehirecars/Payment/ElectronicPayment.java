package uk.ac.gre.ma8521e.privatehirecars.Payment;

/**
 *
 * @author micael
 */
public interface ElectronicPayment {

    public boolean validateCard();

    public boolean isThereEnoughFunds();

    public void finalizePayment();
}
