/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Payment.Card;

/**
 *
 * @author micae
 */
public interface CardDao {

    public List<Card> getAllCards();

    public Card getCard(Integer ID);

    public void updateCard(Card card);

    public void createCard(Card card);

}
