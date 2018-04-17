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
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.DriverDao;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

/**
 *
 * @author micae
 */
public class DriverDaoImpl implements DriverDao {

    public DriverDaoImpl() {
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> listDrivers = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Driver";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Driver driver = new Driver.Builder()
                        .setPerson(new PersonDaoImpl().getPerson(rs.getString("PersonID")))
                        .setID(rs.getInt("DriverID"))
                        .setRating(rs.getInt("rating"))
                        .setonJourney(Utils.fromStringtoBoolean(rs.getString("onJourneys")))
                        .setCar(new CarDaoImpl().getCar(rs.getString("Car")))
                        .build();
                listDrivers.add(driver);
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
        return listDrivers;
    }

    @Override
    public Driver getDriver(int ID) {
        Driver driver = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Driver WHERE DriverID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, String.valueOf(ID));
            rs = stmt.executeQuery();
            while (rs.next()) {
                driver = new Driver.Builder()
                        .setID(rs.getInt("DriverID"))
                        .setRating(rs.getInt("rating"))
                        .setPerson(new PersonDaoImpl().getPerson(rs.getString("PersonID")))
                        .setCar(new CarDaoImpl().getCar(rs.getString("Car")))
                        .setonJourney(Utils.fromStringtoBoolean(rs.getString("onJourneys")))
                        .build();

            }
        } catch (SQLException e) {
            return null;
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
        return driver;
    }

    @Override
    public void updateDriver(Driver driver) {
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE Driver SET PersonID = ?, onJourneys = ?, rating = ?, Car = ? WHERE DriverID = ?;";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, driver.getID());
            stmt.setString(2, Utils.frommBooleanToString(driver.isOnaJourney()));
            stmt.setInt(3, driver.getRating());
            if (driver.getCar() == null) {
                stmt.setString(4, null);
            } else {
                stmt.setString(4, driver.getCar().VIN);
            }
            stmt.setInt(5, driver.getDriverID());
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
    public void deleteDriver(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
