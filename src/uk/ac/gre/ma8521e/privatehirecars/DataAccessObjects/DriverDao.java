/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;

/**
 *
 * @author micae
 */
public interface DriverDao {

    public List<Driver> getAllDrivers();

    public Driver getDriver(int ID);

    public void updateDriver(Driver driver);

    public void deleteDriver(Driver driver);

}
