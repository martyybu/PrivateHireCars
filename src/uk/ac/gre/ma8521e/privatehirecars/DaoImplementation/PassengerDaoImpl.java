/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.PassengerDao;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

/**
 *
 * @author micae
 */
public class PassengerDaoImpl implements PassengerDao {

    List<Passenger> passengers;

    public PassengerDaoImpl() {
        passengers = new ArrayList<Passenger>();
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Person> listPerson = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Passenger INNER JOIN Person ON Passenger.PassengerID = Person.PersonID";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Person person = new Person.Builder()
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setPassword(rs.getString("password"))
                        .setGender(Utils.fromStringtoBoolean(rs.getString("male")))
                        .setID(rs.getString("PersonID"))
                        .setYearOfBirth(rs.getInt("yob"))
                        .build();
                Passenger passenger = new Passenger.Builder()
                        .setPerson(person)
                        .setCard(newCar)
                listPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                stmt = null;
            }
        }
        return listPerson;
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
