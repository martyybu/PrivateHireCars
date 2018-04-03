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
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.CarDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.BookingView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyState;

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
        setupListeners();
        loadFields();
        loadJourneys();
    }

    public void loadJourneys() {
        String[] journeysString = new String[journeys.size()];
        for (int i = 0; i < journeys.size(); i++) {
            journeysString[i] = journeys.get(i).getStartingLocation() + " - " + journeys.get(i).getDestination();
        }
        view.getBookingsCombo().setModel(new DefaultComboBoxModel(journeysString));
    }

    public void loadFields() {
        journeys = new JourneyDaoImpl().getAllJourneys();
        System.out.println("" + journeys.size());
        Journey journey = journeys.get(counter);
        view.getDateLbl().setText(journey.getDate() + "");
        if (!journey.getState().equals(JourneyState.FINISHED)) {
            view.getPriceLbl().setText("To be determined");
            view.getDurationLbl().setText("To be determined");
            view.getRatingLbl().setSelectedIndex(0);
            view.getReviewTxt().setText("");
        } else {
            view.getPriceLbl().setText("£" + journey.getPayment().getAmount());
            view.getDurationLbl().setText(journey.getDuration() + " min");
            view.getReviewTxt().setText(journey.getReview());
            view.getRatingLbl().setSelectedIndex(journey.getRating());
        }
        view.getfromLbl().setText("" + journey.getStartingLocation());
        view.getToLbl().setText("" + journey.getDestination());
        view.getDriverLbl().setText(journey.getDriver().getFirstName() + " " + journey.getDriver().getLastName());
    }

    public void setupListeners() {
        view.getReceiptButton().addActionListener(evt -> receiptBtn(evt));
        view.getSendButton().addActionListener(evt -> sendBtn(evt));
        view.getBookingsCombo().addActionListener(evt -> journeyChanged(evt));
    }

    public void journeyChanged(ActionEvent evt) {
        counter = view.getBookingsCombo().getSelectedIndex();
        loadFields();
    }

    public void sendBtn(ActionEvent evt) {
        if (!journeys.get(counter).getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot review and rate the journey as of yet!");
        } else {
            journeys.get(counter).setRating(view.getBookingsCombo().getSelectedIndex());
            journeys.get(counter).addReview(view.getReviewTxt().getText());
            new JourneyDaoImpl().updateJourney(journeys.get(counter));
            JOptionPane.showMessageDialog(view,
                    "Thank you for th review, It was registered with success!");
        }
    }

    public void receiptBtn(ActionEvent evt) {
        if (!journeys.get(counter).getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot get your receipt!");
        } else {

        }
    }

}
