/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.PaymentDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.Payment.Payment;

/**
 *
 * @author micae
 */
public class PaymentDaoImpl implements PaymentDao {

    @Override
    public Payment getPayment(int ID) {
        Payment payment = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Payment WHERE PaymentID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, ID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                payment = new Payment(new BigDecimal(rs.getInt("amount")));
            }
        } catch (SQLException | NullPointerException e) {
            return payment;
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
        return payment;
    }

    @Override
    public void createPayment(Payment payment) {
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO Person VALUES (?)";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setObject(1, payment.getAmount(), java.sql.Types.DECIMAL);
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
