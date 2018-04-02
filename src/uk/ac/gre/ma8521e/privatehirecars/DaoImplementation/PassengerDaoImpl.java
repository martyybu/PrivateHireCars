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
import uk.ac.gre.ma8521e.privatehirecars.Payment.Card;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

/**
 *
 * @author micae
 */
public class PassengerDaoImpl implements PassengerDao {

    public PassengerDaoImpl() {
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Passenger> listPassenger = new ArrayList<>();
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
                        .setCard(null)
                        .setOnJourney(Utils.fromStringtoBoolean(rs.getString("onJourney")))
                        .setPassenger(rs.getInt("PassengerID"))
                        .setRating(rs.getInt("rating"))
                        .build();
                Card card = new CardDaoImpl().getCard(passenger.getPassengerID());
                passenger.addCard(card);
                listPassenger.add(passenger);
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
        return listPassenger;
    }

    @Override
    public Passenger getPassenger(String ID) {
        Passenger passenger = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Passenger FULL OUTER JOIN Person ON Passenger.PersonID = Person.PersonID WHERE Person.PersonID = ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, ID);
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
                passenger = new Passenger.Builder()
                        .setPerson(person)
                        .setCard(null)
                        .setOnJourney(Utils.fromStringtoBoolean(rs.getString("onJourney")))
                        .setPassenger(rs.getInt("PassengerID"))
                        .setRating(rs.getInt("rating"))
                        .build();
                Card card = new CardDaoImpl().getCard(passenger.getPassengerID());
                passenger.addCard(card);

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
        return passenger;
    }

     @Override
    public Passenger getPassenger(Integer ID) {
        Passenger passenger = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Passenger FULL OUTER JOIN Person ON Passenger.PersonID = Person.PersonID WHERE Passenger.PassengerID = ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, ID);
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
                passenger = new Passenger.Builder()
                        .setPerson(person)
                        .setCard(null)
                        .setOnJourney(Utils.fromStringtoBoolean(rs.getString("onJourney")))
                        .setPassenger(rs.getInt("PassengerID"))
                        .setRating(rs.getInt("rating"))
                        .build();
                Card card = new CardDaoImpl().getCard(passenger.getPassengerID());
                passenger.addCard(card);

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
        return passenger;
    }
    
    @Override
    public void updatePassenger(Passenger passenger) {
        PreparedStatement stmt = null;
        try {
            new PersonDaoImpl().updatePerson(passenger);
            String query = "UPDATE Passenger SET PersonID = ?, onJourney = ?, rating = ?, CardID = ? WHERE PassengerID = ?;";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, passenger.getID());
            stmt.setString(2, Utils.frommBooleanToString(passenger.isOnJourney()));
            stmt.setInt(3, passenger.getRating());
            stmt.setInt(4, passenger.getCard().CARDNO);
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
    public void createPassenger(Passenger passenger) {
        PreparedStatement stmt = null;
        try {
            new PersonDaoImpl().createPerson(passenger);
            String query = "INSERT INTO Passenger VALUES (?, ?, ?, ?)";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, passenger.getID());
            stmt.setString(2, Utils.frommBooleanToString(passenger.isOnJourney()));
            stmt.setInt(3, passenger.getRating());
            if (passenger.getCard() != null) {
                stmt.setInt(4, passenger.getCard().CARDNO);
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
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

}
