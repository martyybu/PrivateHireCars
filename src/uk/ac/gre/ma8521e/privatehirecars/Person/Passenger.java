/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Person;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Card;
import uk.ac.gre.ma8521e.privatehirecars.Journey;

/**
 *
 * @author micae
 */
public class Passenger extends Person implements PersonI{

    private final int PASSENGER_ID;
    private List<Journey> journeys;
    private String phoneNumber;
    private Card card;
    private int rating;

    public Passenger(Passenger passenger) {
        super((Person) passenger);
        this.PASSENGER_ID = passenger.getPassengerID();
        this.journeys = passenger.getJourneys();
        this.phoneNumber = passenger.getPhoneNumber();
        this.card = passenger.getCard();
        this.rating = passenger.getRating();
    }

    private Passenger(Person person, int PassengerID1, List<Journey> journeys1, String phoneNumber1, Card card1, int rating1) {
        super(person);
        this.PASSENGER_ID = PassengerID1;
        this.journeys = journeys1;
        this.phoneNumber = phoneNumber1;
        this.card = card1;
        this.rating = rating1;
    }

    public int getPassengerID() {
        return this.PASSENGER_ID;
    }

    /**
     * Returns all the journeys passenger has made
     *
     * @return
     */
    public List<Journey> getJourneys() {
        return journeys;
    }

    /**
     * returns passenger phonenumber
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * returns customers credit card
     *
     * @return
     */
    public Card getCard() {
        return card;
    }

    /**
     * returns passenger rating
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     * Add a new journey to the client history
     *
     * @param newJourney
     */
    public void addJourney(Journey newJourney) {
        getJourneys().add(newJourney);
    }

    /**
     * Set the passenger phone numbers
     *
     * @param newPhone
     */
    public void setPhoneNumber(String newPhone) {
        phoneNumber = newPhone;
    }

    /**
     * Add a new card
     *
     * @param newCar
     */
    public void addCard(Card newCar) {
        card = newCar;
    }

    /**
     * Add a new rating to the passenger
     *
     * @param rate
     */
    public void addRating(int rate) {
        setRating((getRating() + rate) / 2);
    }

    /**
     * Set the rating, if you are using this outside the passenger class
     * something is broken
     *
     * @param rating
     */
    private void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String getID() {
        return super.getID();
    }

    public static final class Builder {

        private int PASSENGER_ID;
        private List<Journey> journeys;
        private String phoneNumber;
        private Card card;
        private int rating;
        private Person person;

        public Builder setPassenger(int newID) {
            this.PASSENGER_ID = newID;
            return this;
        }

        public Builder setJourneyHistory(List<Journey> newHistory) {
            this.journeys = newHistory;
            return this;
        }

        public Builder setphoneNumber(String newphoneNumber) {
            this.phoneNumber = newphoneNumber;
            return this;
        }

        public Builder setCard(Card newCar) {
            this.card = newCar;
            return this;
        }

        public Builder setRating(int newRating) {
            this.rating = newRating;
            return this;
        }

        public Builder setPerson(Person newPerson) {
            this.person = newPerson;
            return this;
        }

        public Passenger build() {
            return new Passenger(this.person, this.PASSENGER_ID, this.journeys, this.phoneNumber, this.card, this.rating);
        }
    }
}
