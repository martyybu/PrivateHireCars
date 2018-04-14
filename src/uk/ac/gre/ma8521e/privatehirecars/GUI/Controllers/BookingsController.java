package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.CarDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.DriverDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.BookingView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.ReceiptView;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyState;
import uk.ac.gre.ma8521e.privatehirecars.PrivateHireCars;

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
        updateJourneys();
        System.out.println("" + journeys.size());
        Journey journey = journeys.get(counter);
        view.getDateLbl().setText(journey.getDate() + "");
        if (!journey.getState().equals(JourneyState.FINISHED)) {
            view.getPriceLbl().setText("To be determined");
            view.getDurationLbl().setText("To be determined");
            view.getJourneyRating().setSelectedIndex(0);
            view.getReviewTxt().setText("");
        } else {
            view.getPriceLbl().setText("£" + journey.getPayment().getAmount());
            view.getDurationLbl().setText(journey.getDuration() + " min");
            view.getReviewTxt().setText(journey.getReview() + "");
            view.getJourneyRating().setSelectedIndex(journey.getRating());
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

    public void updateJourneys() {
        journeys = new JourneyDaoImpl().getAllJourneys();
        //looping through the journeys to get the ones that belong to the user
        List<Journey> relevantJourneys = new ArrayList<>();
        journeys.stream().filter((journey) -> (journey.getPassenger().getID() == null ? PrivateHireCars.getPerson().getID() == null : journey.getPassenger().getID().equals(PrivateHireCars.getPerson().getID()))).forEachOrdered((journey) -> {
            relevantJourneys.add(journey);
        });
    }

    public void sendBtn(ActionEvent evt) {
        if (!journeys.get(counter).getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot review and rate the journey as of yet!");
        } else {
            Journey journey = journeys.get(counter);
            journey.setRating(view.getJourneyRating().getSelectedIndex());
            journey.addReview(view.getReviewTxt().getText());
            journey.getCar().rate(view.getCarRating().getSelectedIndex());
            journey.getDriver().rate(view.getDriverRating().getSelectedIndex());
            new DriverDaoImpl().updateDriver(journey.getDriver());
            new CarDaoImpl().updateCar(journey.getCar());
            new JourneyDaoImpl().updateJourney(journey);
            updateJourneys();
            JOptionPane.showMessageDialog(view,
                    "Thank you for the review, It was registered with success!");
        }
    }

    public void receiptBtn(ActionEvent evt) {
        if (!journeys.get(counter).getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot get your receipt!");
        } else {
            ReceiptView receiptView = new ReceiptView();
            ReceiptController receiptController = new ReceiptController(journeys.get(counter), receiptView);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            receiptView.setLocation(new Point((screenSize.width / 2) - receiptView.getWidth() / 2, (screenSize.height / 2) - receiptView.getHeight() / 2));
            receiptView.setVisible(true);
        }
    }

}
