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
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.CarDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;

/**
 *
 * @author micae
 */
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getAllCar(int ID) {
        List<Car> car = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Car WHERE VIN= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, String.valueOf(ID));
            rs = stmt.executeQuery();
            while (rs.next()) {
                Car car1 = new Car(rs.getString("VIN"), rs.getInt("plateNo"), rs.getInt("seats"), rs.getString("brand"), new DriverDaoImpl().getDriver(rs.getInt("DriverID")),rs.getString("model"));
                car.add(car1);
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
        return car;
    }

    public List<Car> getAllCars() {
        List<Car> car = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Car";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Car car1 = new Car(rs.getString("VIN"), rs.getInt("plateNo"), rs.getInt("seats"), rs.getString("brand"), new DriverDaoImpl().getDriver(rs.getInt("DriverID")),rs.getString("model"));
                car.add(car1);
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
        return car;
    }

    @Override
    public Car getCar(String ID) {
        Car car = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Car WHERE VIN= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1, String.valueOf(ID));
            rs = stmt.executeQuery();
            while (rs.next()) {
                car = new Car(rs.getString("VIN"), rs.getInt("plateNo"), rs.getInt("seats"), rs.getString("brand"), new DriverDaoImpl().getDriver(rs.getInt("DriverID")),rs.getString("model"));
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
        return car;
    }

    @Override
    public void updateCar(Car car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCar(Car car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
