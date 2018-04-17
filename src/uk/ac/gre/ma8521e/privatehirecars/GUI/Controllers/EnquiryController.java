/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.EnquiryDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.Enquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.EnquiryView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.PrivateHireCars;

/**
 *
 * @author micae
 */
public class EnquiryController {

    private EnquiryView view;

    public EnquiryController() {

    }

    void addView(EnquiryView v2) {
        view = v2;
        setupListeners();
        view.getAnswerTexBox().setFocusable(false);
        view.getTextBox().setFocusable(false);
        loadEnquiries();
    }

    void setupListeners() {
        view.getlistOfEnquiries().addActionListener(evt -> changeListOfEnquiries(evt));
    }

    /**
     * void sendBtn(ActionEvent evt) { Enquiry enquiry = new
     * EnquiryDaoImpl().getEnquiry(((Enquiry)
     * view.getlistOfEnquiries().getSelectedItem()).getID()); if (enquiry !=
     * null) { if (enquiry.getEnquiry() != null); } }*
     */
    void changeListOfEnquiries(ActionEvent evt) {
        view.getTextBox().setText(((Enquiry) view.getlistOfEnquiries().getSelectedItem()).getEnquiry());
        view.getAnswerTexBox().setText(((Enquiry) view.getlistOfEnquiries().getSelectedItem()).getAnswer());
        if (((Enquiry) view.getlistOfEnquiries().getSelectedItem()).getJourney() != null) {
            view.getLblTrip().setText(((Enquiry) view.getlistOfEnquiries().getSelectedItem()).getJourney().toString());
        }
    }

    /**
     * *
     * public void loadTrips() { List<Journey> journeys = new
     * JourneyDaoImpl().getAllJourneys(); //looping through the journeys to get
     * the ones that belong to the user journeys.stream().filter((journey) ->
     * (journey.getPassenger().getID() == null ?
     * PrivateHireCars.getPerson().getID() == null :
     * journey.getPassenger().getID().equals(PrivateHireCars.getPerson().getID()))).forEachOrdered((journey)
     * -> { view.getlistofTrips().addItem(journey); }); }*
     */
    void loadEnquiries() {
        List<Enquiry> enquiries = new EnquiryDaoImpl().getPersonEnquiries(PrivateHireCars.getPerson().getID());
        System.out.println("e" + enquiries);
        for (int i = 0; i < enquiries.size(); i++) {
            view.getlistOfEnquiries().addItem(enquiries.get(i));
        }
    }
}
