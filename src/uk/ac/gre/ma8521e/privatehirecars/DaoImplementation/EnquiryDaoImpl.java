/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DaoImplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.EnquiryDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;
import uk.ac.gre.ma8521e.privatehirecars.Enquiry;

/**
 *
 * @author micae
 */
public class EnquiryDaoImpl implements EnquiryDao {

    @Override
    public Enquiry getEnquiry(int ID) {
        Enquiry enquiry = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Enquiry WHERE EnquiryID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1,ID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                enquiry = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),new PersonDaoImpl().getPerson(rs.getString(4)),new PersonDaoImpl().getPerson(rs.getString(5)));
            }
        } catch (SQLException | NullPointerException e) {
            return enquiry;
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
        return enquiry;
    }

    @Override
    public List<Enquiry> getPersonEnquiries(String personID) {
        List<Enquiry> enquiry = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Enquiry WHERE PersonID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setString(1,personID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Enquiry enquiryobj= new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),new PersonDaoImpl().getPerson(rs.getString(4)),new PersonDaoImpl().getPerson(rs.getString(5)));
                enquiry.add(enquiryobj);
            }
        } catch (SQLException | NullPointerException e) {
            return enquiry;
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
        return enquiry;
    }

    @Override
    public void updateEnquiry(Enquiry enquiry) {
        PreparedStatement stmt = null;
        try {
            String query = "UPDATE Enquiry SET EnquiryID = ?, enquiry = ?, answer = ?, PersonID = ?, Staff = ? WHERE EnquiryID = ?;";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, enquiry.getID());
            stmt.setString(2, enquiry.getEnquiry());
            stmt.setString(3, enquiry.getAnswer());
            stmt.setString(4, enquiry.getPerson().getID());
            stmt.setString(6, enquiry.getStaff().getID());
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
    public void insertEnquiry(Enquiry enquiry) {
    PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO Enquiry VALUES (?, ?, ?, ?, ?)";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, enquiry.getID());
            stmt.setString(2, enquiry.getEnquiry());
            stmt.setString(3, enquiry.getAnswer());
            stmt.setString(4, enquiry.getPerson().getID());
            stmt.setString(6, enquiry.getStaff().getID());
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
