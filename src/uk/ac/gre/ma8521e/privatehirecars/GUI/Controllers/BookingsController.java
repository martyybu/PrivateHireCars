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
    private int selectedID = 0;

    public BookingsController() {

    }

    public void addView(BookingView view2) {
        view = view2;
        setupListeners();
        updateJourneys();
        selectedID = journeys.get(1).getID();
        loadFields();
        loadJourneys();
    }

    public void loadJourneys() {
        for (int i = 0; i < journeys.size(); i++) {
            view.getBookingsCombo().addItem(journeys.get(i));
        }
    }

    public void loadFields() {
        Journey journey = new JourneyDaoImpl().getJourney(selectedID);
        view.getDateLbl().setText(journey.getDate() + "");
        if (!journey.getState().equals(JourneyState.FINISHED)) {
            view.getPriceLbl().setText("To be determined");
            view.getDurationLbl().setText("To be determined");
            view.getJourneyRating().setSelectedIndex(0);
            view.getCarRating().setSelectedIndex(0);
            view.getDriverRating().setSelectedIndex(0);
            view.getReviewTxt().setText("");
        } else {
            view.getPriceLbl().setText("£" + journey.getPrice());
            view.getDurationLbl().setText(journey.getDuration() + " min");
            view.getReviewTxt().setText(journey.getReview() + "");
            view.getCarRating().setSelectedIndex(journey.getCarRating());
            view.getDriverRating().setSelectedIndex(journey.getDriverRating());
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
        Journey journey = (Journey) view.getBookingsCombo().getSelectedItem();
        selectedID = journey.getID();
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
        if (!new JourneyDaoImpl().getJourney(selectedID).getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot review and rate the journey as of yet!");
        } else {
            Journey journey = new JourneyDaoImpl().getJourney(selectedID);
            journey.setJourneyRating(view.getJourneyRating().getSelectedIndex());
            journey.addReview(view.getReviewTxt().getText());
            journey.setCarRating(view.getCarRating().getSelectedIndex());
            journey.setDriverRating(view.getDriverRating().getSelectedIndex());
            new DriverDaoImpl().updateDriver(journey.getDriver());
            new CarDaoImpl().updateCar(journey.getCar());
            new JourneyDaoImpl().updateJourney(journey);
            updateJourneys();
            JOptionPane.showMessageDialog(view,
                    "Thank you for the review, It was registered with success!");
        }
    }

    public void receiptBtn(ActionEvent evt) {
        Journey journey = new JourneyDaoImpl().getJourney(selectedID);
        if (!journey.getState().equals(JourneyState.FINISHED)) {
            JOptionPane.showMessageDialog(view,
                    "Your journey has not occured or has not been terminated, therefore you cannnot get your receipt!");
        } else {
            ReceiptView receiptView = new ReceiptView();
            ReceiptController receiptController = new ReceiptController(new JourneyDaoImpl().getJourney(selectedID), receiptView);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            receiptView.setLocation(new Point((screenSize.width / 2) - receiptView.getWidth() / 2, (screenSize.height / 2) - receiptView.getHeight() / 2));
            receiptView.setVisible(true);
        }
    }

}
