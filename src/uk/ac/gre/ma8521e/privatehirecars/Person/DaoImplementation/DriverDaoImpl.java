/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Person.DaoImplementation;

import java.util.ArrayList;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Person.Dao.DriverDao;
import uk.ac.gre.ma8521e.privatehirecars.Person.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Person.Passenger;

/**
 *
 * @author micae
 */
public class DriverDaoImpl implements DriverDao{

    List<Driver> drivers;
    
    public DriverDaoImpl(){
        drivers = new ArrayList<Driver>();
    }
    
    @Override
    public List<Driver> getAllDrivers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Driver getDriver(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDriver(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDriver(Passenger driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
