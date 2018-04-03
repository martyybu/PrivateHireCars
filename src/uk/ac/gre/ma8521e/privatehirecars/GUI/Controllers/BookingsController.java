/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.CarDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.BookingView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micae
 */
public class BookingsController {

    private BookingView view;
    private List<Journey> journeys;
    private int counter = 0;

    public BookingsController() {

    }

    public void addView(BookingView view2) {
        view = view2;
        loadFields();
        loadJourneys();
    }

    public void loadJourneys(){
        String[] journeysString = new String[journeys.size()];
        for (int i = 0; i < journeys.size(); i++) {
            journeysString[i] = journeys.get(i).getStartingLocation() +" - " + journeys.get(i).getDestination();
        }
        view.getBookingsCombo().setModel(new DefaultComboBoxModel(journeysString));
    }
    
    public void loadFields() {
        journeys = new JourneyDaoImpl().getAllJourneys();
        System.out.println(""+journeys.size());
        Journey journey = journeys.get(counter);
        view.getDateLbl().setText(journey.getDate() + "");
        if (journey.getPayment() != null) {
            view.getPriceLbl().setText("£" + journey.getPayment().getAmount());
        } else {
            view.getPriceLbl().setText("To be determined");
        }
        view.getfromLbl().setText("" + journey.getStartingLocation());
        view.getToLbl().setText("" + journey.getDestination());
        view.getDriverLbl().setText(journey.getDriver().getFirstName() + " " + journey.getDriver().getLastName());
        view.getDurationLbl().setText(journey.getDuration() + "");
        view.getReviewTxt().setText(journey.getReview());
    }

    public void setupListeners() {
        view.getReceiptButton().addActionListener(evt -> receiptBtn(evt));
        view.getSendButton().addActionListener(evt -> sendBtn(evt));
        view.getBookingsCombo().addActionListener(evt -> journeyChanged(evt));
    }

    public void journeyChanged(ActionEvent evt) {
        counter = view.getBookingsCombo().getSelectedIndex();
        loadFields();
        System.out.println("left");

    }
    
    public void sendBtn(ActionEvent evt) {

    }

    public void receiptBtn(ActionEvent evt) {

    }

}
