/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.CarDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.DriverDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.JourneyDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateBooking;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyNotification;
import uk.ac.gre.ma8521e.privatehirecars.Journey.JourneyState;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Location;
import uk.ac.gre.ma8521e.privatehirecars.Journey.MapsApiImpl;
import uk.ac.gre.ma8521e.privatehirecars.Payment.Credit;
import uk.ac.gre.ma8521e.privatehirecars.Payment.ElectronicPayment;
import uk.ac.gre.ma8521e.privatehirecars.PrivateHireCars;
import uk.ac.gre.ma8521e.privatehirecars.Utils;

/**
 *
 * @author ma8521e
 */
public class CreateBookingController {

    private CreateBooking view;
    private Journey journey;

    public CreateBookingController() {

    }

    public void addView(CreateBooking view2) {
        view = view2;
        setupListeners();
        loadDropDownCars();
    }

    public void loadDropDownCars() {
        if (new CarDaoImpl().getAvailableCars() == null || new CarDaoImpl().getAvailableCars().isEmpty()) {
            String[] message = new String[1];
            message[0] = "No cars Available";
            view.getCarsDrop().setModel(new DefaultComboBoxModel(message));
        } else {
            List<Car> cars = new CarDaoImpl().getAvailableCars();
            for (int i = 0; i < cars.size(); i++) {
                view.getCarsDrop().addItem(cars.get(i));
            }
        }
    }

    public void setupListeners() {
        view.getAvailabilityButton().addActionListener(evt -> btnAvailability(evt));
        view.getConfirmButton().addActionListener(evt -> btnConfirm(evt));
    }

    public void btnConfirm(ActionEvent evt) {
        if (journey != null) {
            view.getAvailabilityButton().doClick();
        }

        ElectronicPayment payment = new Credit(journey.getPrice(), journey.getPassenger().getCard());
        if (payment.isThereEnoughFunds()) {
            JOptionPane.showMessageDialog(view,
                    "Your booking was succeful!");
        }
        journey.getDriver().setCar(journey.getCar());
        journey.getDriver().onJourney(true);
        new DriverDaoImpl().updateDriver(journey.getDriver());
        new JourneyDaoImpl().createJourney(journey);
    }

    public void btnAvailability(ActionEvent evt) {
        if (journey == null) {
            if (Utils.isFieldEmpty(view.getTo().getText()) || Utils.isFieldEmpty(view.getFrom().getText())) {
                JOptionPane.showMessageDialog(view,
                        "You need to enter location!");
                return;
            }
            //Check if locations are valid
            if (new MapsApiImpl().getLocation(view.getTo().getText()) == null || new MapsApiImpl().getLocation(view.getFrom().getText()) == null) {
                JOptionPane.showMessageDialog(view,
                        "One of the Locations is invalid, please check them!");
                return;
            }
            String fromTemp = view.getFrom().getText();
            String toTemp = view.getTo().getText();
            Location from = new MapsApiImpl().getLocation(fromTemp);
            Location to = new MapsApiImpl().getLocation(toTemp);
            int distance = new MapsApiImpl().getDistanceBetweenLocation(from, to);

            //check if passenger has a card
            if (doesPersonHaveCard(PrivateHireCars.getPerson())) {
                Passenger passenger = (Passenger) PrivateHireCars.getPerson();
            } else {
                JOptionPane.showMessageDialog(view,
                        "You havent added a card to your account. You can do it in Profile!");
                return;
            }
            Passenger passenger = (Passenger) PrivateHireCars.getPerson();
            //find out the car VIN

            Object car = view.getCarsDrop().getSelectedItem();

            if (!(car instanceof Car)) {
                JOptionPane.showMessageDialog(view,
                        "There are no cars available at the moment! Try later!");
                return;
            }

            Date date = (Date) view.getDate().getValue();

            if (getDriver() == null) {
                JOptionPane.showMessageDialog(view,
                        "There are no drivers available!");
                return;
            }

            journey = new Journey.Builder()
                    .setFrom(fromTemp)
                    .setTo(toTemp)
                    .setCar(new CarDaoImpl().getCar(((Car)car).VIN))
                    .setDriver(getDriver())
                    .setPassenger(passenger)
                    .setNotification(JourneyNotification.valueOf(view.getNotification().getSelectedItem().toString()))
                    .setDate(date)
                    .setDuration(new MapsApiImpl().getDuration(to, from) * 1)
                    .setState(JourneyState.SCHEDULE).build();
            BigDecimal etaPrice = journey.getPrice().add(new BigDecimal(2));
            view.getFinalPrice().setText("£" + journey.getPrice() + " - " + "£" + etaPrice);
            view.getDuration().setText(journey.getDuration() + "" + " min");
            view.getDriver().setText(journey.getDriver().getFirstName() + " " + journey.getDriver().getLastName() + " Rating:   " + journey.getDriver().getRating() + "*");
            //Check if user has a card and if so check the balance
            //then Create Journey
        }
    }

    public Driver getDriver() {
        for (Iterator<Driver> it = new DriverDaoImpl().getAllDrivers().iterator(); it.hasNext();) {
            Driver driver = it.next();
            if (driver.getCar() == null) {
                return driver;
            }
        }
        return null;
    }

    public boolean doesPersonHaveCard(Person person) {
        if (person instanceof Passenger) {
            Passenger passenger = (Passenger) person;
            if (passenger.getCard() != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
