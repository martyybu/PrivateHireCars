/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.CarDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.EnquiryDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.Enquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateEnquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.EnquiryView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micae
 */
public class EnquiryController {

    private EnquiryView view;
    private Integer journeyIDselected = null;
    private Integer enquiryIDselected = null;

    public EnquiryController() {

    }

    void addView(EnquiryView v2) {
        view = v2;
    }

    void setupListeners() {
        view.getlistofTrips().addActionListener(evt -> changeListOfTrips(evt));
        view.getlistOfEnquiries().addActionListener(evt -> changeListOfEnquiries(evt));
        view.getsendBtn().addActionListener(evt -> sendBtn(evt));
    }

    void sendBtn(ActionEvent evt) {
        Enquiry enquiry = new EnquiryDaoImpl().getEnquiry(enquiryIDselected);
        if(enquiry!=null){
            if(enquiry.getEnquiry()!=null);
        }
    }

    void changeListOfEnquiries(ActionEvent evt) {
        getIDofEnquirySelected();
    }

    void loadFields() {
        if (this.enquiryIDselected != null) {
            Enquiry enquiry = new EnquiryDaoImpl().getEnquiry(this.enquiryIDselected);
            String answer = enquiry.getAnswer();
            String question = enquiry.getEnquiry();
            view.getTextBox().setText(enquiry.getPerson().getFirstName() + " " + enquiry.getPerson().getLastName()
                    + " /n " + question);
            if (answer != null) {
                view.getTextBox().setText(view.getTextBox().getText() + " /n /n /n " + enquiry.getStaff().getFirstName() + " " + enquiry.getStaff().getLastName() + " \n " + enquiry.getAnswer());
            }
        }
    }

    public Integer getIDofEnquirySelected() {
        String[] splittedText = view.getlistOfEnquiries().getSelectedItem().toString().split(" | ");
        Integer ID = Integer.valueOf(splittedText[1]);
        return ID;
    }

    void changeListOfTrips(ActionEvent evt) {
        this.journeyIDselected = view.getlistofTrips().getSelectedIndex();

    }

    void loadTrips() {
        List<Journey> journeys = new JourneyDaoImpl().getAllJourneys();
        String[] journeysString = new String[journeys.size()];
        for (int i = 0; i < journeys.size(); i++) {
            journeysString[i] = journeys.get(i).getStartingLocation() + " - " + journeys.get(i).getDestination();
        }
        view.getlistofTrips().setModel(new DefaultComboBoxModel(journeysString));
    }

    void loadEnquiries() {
        List<Enquiry> enquiries = new EnquiryDaoImpl().getPersonEnquiries(MainController.person.getID());
        String[] carsString = new String[enquiries.size()];
        for (int i = 0; i < enquiries.size(); i++) {
            carsString[i] = enquiries.get(i).toString();
        }
        view.getlistOfEnquiries().setModel(new DefaultComboBoxModel(carsString));
    }
}
