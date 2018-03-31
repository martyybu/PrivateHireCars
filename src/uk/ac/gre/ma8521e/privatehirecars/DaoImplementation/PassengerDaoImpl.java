/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.util.ArrayList;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.PassengerDao;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;

/**
 *
 * @author micae
 */
public class PassengerDaoImpl implements PassengerDao {
    
    List<Passenger> passengers;
    
    public PassengerDaoImpl(){
        passengers = new ArrayList<Passenger>();
    }

    @Override
    public List<Passenger> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Passenger getPassenger(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
