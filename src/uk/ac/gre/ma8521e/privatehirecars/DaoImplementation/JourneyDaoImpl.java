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
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.JourneyDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyNotification;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyState;

/**
 *
 * @author micae
 */
public class JourneyDaoImpl implements JourneyDao {

    @Override
    public List<Journey> getAllJourneys() {
        List<Journey> listJourneys = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Passenger INNER JOIN Person ON Passenger.PassengerID = Person.PersonID";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Journey journey = new Journey.Builder()
                        .setTo(rs.getString("startingLocationID"))
                        .setFrom(rs.getString("destinationID"))
                        .setDriver(new DriverDaoImpl().getDriver(rs.getInt("DriverID")))
                        .setPassenger(new PassengerDaoImpl().getPassenger(rs.getInt("PassengerID")))
                        .setCar(new CarDaoImpl().getCar(rs.getString("CarID")))
                        .setPayment(null)
                        .setDate(rs.getDate("date"))
                        .setDuration(rs.getInt("duration"))
                        .setRating(rs.getInt("rating"))
                        .setState(JourneyState.valueOf(rs.getString("journeyState")))
                        .setNotification(JourneyNotification.valueOf(rs.getString("notification")))
                        .build();
                listJourneys.add(journey);
            }
        } catch (SQLException e) {
            return listJourneys;
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
        return listJourneys;
    }


    @Override
    public Journey getJourney(int ID) {
        Journey journey = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Passenger INNER JOIN Person ON Passenger.PassengerID = Person.PersonID";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                journey = new Journey.Builder()
                        .setTo(rs.getString("startingLocationID"))
                        .setFrom(rs.getString("destinationID"))
                        .setDriver(new DriverDaoImpl().getDriver(rs.getInt("DriverID")))
                        .setPassenger(new PassengerDaoImpl().getPassenger(rs.getInt("PassengerID")))
                        .setCar(new CarDaoImpl().getCar(rs.getString("CarID")))
                        .setPayment(null)
                        .setDate(rs.getDate("date"))
                        .setDuration(rs.getInt("duration"))
                        .setRating(rs.getInt("rating"))
                        .setState(JourneyState.valueOf(rs.getString("journeyState")))
                        .setNotification(JourneyNotification.valueOf(rs.getString("notification")))
                        .build();
            }
        } catch (SQLException e) {
            return journey;
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
        return journey;
    }

    @Override
    public void insertJourney(Journey journey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteJourney(Journey journey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
