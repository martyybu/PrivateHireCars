/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateBooking;

/**
 *
 * @author ma8521e
 */
public class CreateBookingController {

    CreateBooking view;

    public CreateBookingController() {

    }

    public void addView(CreateBooking view2) {
        view = view2;
        setupListeners();
    }

    public void setupListeners() {
        view.getAvailabilityBtn().addActionListener(evt -> btnAvailability(evt));
        view.getConfirmBtn().addActionListener(evt -> btnConfirm(evt));
    }

    public void btnConfirm(ActionEvent evt) {
        //Check Card Money
        //Check if user has a card and if so check the balance
        
        
        //then Create Journey
        
        
        
        
    }

    public void btnAvailability(ActionEvent evt) {
        //check if to and from are valid locations
        
        //check if there is  a driver available
        
        //after all the checks get Price, duration and disply details

    }

}
