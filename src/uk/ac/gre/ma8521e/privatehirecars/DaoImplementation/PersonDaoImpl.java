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
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.PersonDao;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

/**
 *
 * @author micae
 */
public class PersonDaoImpl implements PersonDao {

    public PersonDaoImpl() {
    }

    @Override
    public List<Person> getAll() {
        List<Person> listPerson = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Person";
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
    public void updatePerson(Person person) {
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE Person SET password = ?, firstName = ?, lastName = ?, yob = ?, male = ? WHERE PersonID = ?;";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, person.getPassword());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.setInt(4, person.getYearOfBirthday());
            stmt.setString(5, Utils.frommBooleanToString(person.getGender()));
            stmt.setString(6, person.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore
                stmt = null;
            }
        }
    }

    @Override
    public void deletePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(String ID) {
        Person person = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Person WHERE PersonID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, String.valueOf(ID));
            rs = stmt.executeQuery();
            while (rs.next()) {
                person = new Person.Builder()
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setPassword(rs.getString("password"))
                        .setGender(Utils.fromStringtoBoolean(rs.getString("male")))
                        .setID(rs.getString("PersonID"))
                        .setYearOfBirth(rs.getInt("yob"))
                        .build();
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
        return person;
    }

}
