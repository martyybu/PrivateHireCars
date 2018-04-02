package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;

/**
 *
 * @author micae
 */
public interface CarDao {

    public Car getCar(String ID);

    public void updateCar(Car car);

    public void deleteCar(Car car);

    public List<Car> getAllCar(int ID);

    }
