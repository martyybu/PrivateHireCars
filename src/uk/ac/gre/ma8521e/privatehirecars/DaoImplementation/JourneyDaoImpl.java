/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.JourneyDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyNotification;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyState;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

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
        PreparedStatement stmt = null;
        try {

            String query = "INSERT INTO Journey VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, journey.getDriver().getDriverID());
            stmt.setInt(2, journey.getPassenger().getPassengerID());
            stmt.setString(3, journey.getStartingLocation());
            stmt.setString(4, journey.getDestination());
            stmt.setString(5, journey.getCar().VIN);
            stmt.setInt(6, journey.getPayment().getID());
            stmt.setTimestamp(7,new Timestamp(journey.getDate().getTime()));
            stmt.setInt(8, journey.getDuration());
            stmt.setInt(9, journey.getRating());
            stmt.setString(10, journey.getState().toString());
            stmt.setString(11, journey.getNotifications().toString());
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
    public void deleteJourney(Journey journey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
