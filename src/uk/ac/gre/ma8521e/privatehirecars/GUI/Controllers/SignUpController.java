/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.Actors.PersonFactory;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.PersonDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.SignUpView;
import uk.ac.gre.ma8521e.privatehirecars.PasswordHash;

/**
 *
 * @author micae
 */
public class SignUpController {

    SignUpView view;
    String errorMessage;

    public SignUpController() {

    }

    public void addView(SignUpView view2) {
        view = view2;
        setupListener();
    }

    public void setupListener() {
        view.getSignUpButton().addActionListener(evt -> signUpButton(evt));
    }

    public void signUpButton(ActionEvent evt) {
        validateLoginInformation();
        if (errorMessage == null) {
            Person newPerson = (Person) PersonFactory.createAccount("Passenger");
            try {
                newPerson = new Person.Builder()
                        .setFirstName(view.getFirstName().getText())
                        .setLastName(view.getLastName().getText())
                        .setGender(getGender())
                        .setID(view.getUsername().getText())
                        .setPassword(PasswordHash.createHash(view.getPassword().getText()))
                        .setPhoneNumber(view.getPhoneNumber().getText())
                        .setYearOfBirth(new Date(view.getBirthDate().getText()).getYear())
                        .build();
                new PersonDaoImpl().createPerson(newPerson);
                Passenger passenger = new Passenger.Builder()
                        .setPerson(newPerson)
                        .setRating(5)
                        .setOnJourney(false)
                        .setCard(null)
                        .build();
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Boolean getGender() {
        return view.getGender().getSelectedIndex() == 1;
    }

    public void validateLoginInformation() {
        if (!areNamesValid()) {
            errorMessage = "You need to enter a first name and last name!";
            JOptionPane.showMessageDialog(view,
                    errorMessage);
            return;
        }
        if (!isUserNameAvailable()) {
            errorMessage = "This username is already taken";
            JOptionPane.showMessageDialog(view,
                    errorMessage);
            return;
        }
        if (!isPasswordValid()) {
            errorMessage = "The password needs to be at least 8 characters";
            JOptionPane.showMessageDialog(view,
                    errorMessage);
            return;
        }
        if (!isDateValid()) {
            errorMessage = "The date needs to be in the following format dd/MM/yyyy";
            JOptionPane.showMessageDialog(view,
                    errorMessage);
            return;
        }
        //if there are no errors it will empty
        errorMessage = null;
    }

    public boolean areNamesValid() {
        if (isFieldEmpty(view.getFirstName().getText()) || isFieldEmpty(view.getLastName().getText())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isDateValid() {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            date = sdf.parse(view.getBirthDate().getText());
            if (!view.getBirthDate().getText().equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (date == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isUserNameAvailable() {
        return new PersonDaoImpl().getPerson(view.getUsername().getText()) == null;
    }

    public boolean isPasswordValid() {
        if (!isFieldEmpty(view.getPassword().getText())) {
            return view.getPassword().getText().length() >= 8;
        } else {
            return false;
        }
    }

    public boolean isFieldEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
