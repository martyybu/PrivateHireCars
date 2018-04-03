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
import uk.ac.gre.ma8521e.privatehirecars.Payment.Card;
import uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects.CardDao;
import uk.ac.gre.ma8521e.privatehirecars.Database;

/**
 *
 * @author micae
 */
public class CardDaoImpl implements CardDao{

    @Override
    public List<Card> getAllCards() {
        List<Card> cardList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Card";
            stmt = Database.getInstance().prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card(rs.getInt("PassengerID"),
                        rs.getInt("CardNO"),
                        rs.getDate("expDate"),
                        rs.getString("cardName"),
                        rs.getInt("CVC"));
                cardList.add(card);
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
        return cardList;
    }

    @Override
    public Card getCard(Integer userID) {
        Card card = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Card WHERE PassengerID= ?";
            stmt = Database.getInstance().prepareStatement(query);
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                card = new Card(rs.getInt("PassengerID"),
                        rs.getInt("CardNO"),
                        rs.getDate("expDate"),
                        rs.getString("cardName"),
                        rs.getInt("CVC"));
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
        return card;
    }

    @Override
    public void updateCard(Card card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCard(Card card) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
