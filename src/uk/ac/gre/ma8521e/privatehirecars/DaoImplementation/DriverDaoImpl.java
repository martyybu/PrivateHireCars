/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.DriverDao;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;

/**
 *
 * @author micae
 */
public class DriverDaoImpl implements DriverDao {

    Driver[] drivers;

    public DriverDaoImpl() {
        drivers = getAllDrivers();
    }

    @Override
    public Driver[] getAllDrivers() {
        Driver[] listChest = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Driver";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
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
        return listChest;
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
                        .setCar(new CarDaoImpl().getCar(rs.getInt("DriverID")))
                        .setonJourney(rs.getBoolean("onJourney")).build();
                         
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
        return driver;
    }

    @Override
    public void updateDriver(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void deleteDriver(Driver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
