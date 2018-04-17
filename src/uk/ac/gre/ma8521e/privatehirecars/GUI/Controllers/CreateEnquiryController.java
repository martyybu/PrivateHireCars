/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.EnquiryDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.Enquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateEnquiryView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.EnquiryView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.PrivateHireCars;

/**
 *
 * @author ma8521e
 */
public class CreateEnquiryController {

    private CreateEnquiryView view;

    public CreateEnquiryController() {

    }

    void addView(CreateEnquiryView v2) {
        view = v2;
        setupListeners();
        loadTrips();
    }

    void setupListeners() {
        view.getSendBTn().addActionListener(evt -> sendBtn(evt));
    }

    void sendBtn(ActionEvent evt) {
        Enquiry enquiry = new Enquiry(view.getTextbox().getText(),null,null,PrivateHireCars.getPerson(),(Journey)view.getlistofTrips().getSelectedItem());
        new EnquiryDaoImpl().insertEnquiry(enquiry);
    }

    public void loadTrips() {
        List<Journey> journeys = new JourneyDaoImpl().getAllJourneys();
        journeys.stream().filter((journey)
                -> (journey.getPassenger().getID() == null
                        ? PrivateHireCars.getPerson().getID() == null
                        : journey.getPassenger().getID().equals(PrivateHireCars.getPerson().getID()))).forEachOrdered((journey)
                -> {
            view.getlistofTrips().addItem(journey);
        });
    
        
    }
}    
