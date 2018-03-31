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
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            instance = DriverManager.getConnection("jdbc:sqlserver://sql-server:1433;databaseName=ma8521e;user=ma8521e;password=!0Gondar1997;");
            System.out.println("Connected to database !");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception :" + e.getMessage());
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            new Database();
        }
        return instance;
    }
}
