package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;


import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;

/**
 *
 * @author micael
 */
public interface PassengerDao {

    public List<Passenger> getAllStudents();

    public Passenger getPassenger(int ID);

    public void updatePassenger(Passenger passenger);

    public void deletePassenger(Passenger passenger);

}
