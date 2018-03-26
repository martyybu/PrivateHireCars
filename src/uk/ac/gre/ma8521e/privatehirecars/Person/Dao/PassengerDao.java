package uk.ac.gre.ma8521e.privatehirecars.Person.Dao;


import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Person.Passenger;

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
