package uk.ac.gre.ma8521e.privatehirecars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author micael
 */
public class Database {

    private static Connection instance;

    private Database() {
        try {
            instance = (Connection) DriverManager.getConnection("jdbc:mysql://176.31.122.221:3306/taxi?" + "user=taxi&password=taxi123");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            new Database();
        }
        return instance;
    }
}
