/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import uk.ac.gre.ma8521e.privatehirecars.Payment.Card;

/**
 *
 * @author micae
 */
public interface CardDao {

    public Card[] getAllCards();

    public Card getCard(String ID);

    public void updateCard(Card card);

    public void createCard(Card card);

}
