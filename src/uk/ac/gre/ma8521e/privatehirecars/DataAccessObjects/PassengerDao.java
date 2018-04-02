package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;

/**
 *
 * @author micael
 */
public interface PassengerDao {

    public List<Passenger> getAllPassengers();

    public Passenger getPassenger(String ID);

    public Passenger getPassenger(Integer ID);

    public void updatePassenger(Passenger passenger);

    public void createPassenger(Passenger passenger);

}
