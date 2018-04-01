/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Actors;

import uk.ac.gre.ma8521e.privatehirecars.Payment.Card;

/**
 *
 * @author micae
 */
public class Passenger extends Person implements PersonI{

    private final int PASSENGER_ID;
    private Boolean onJourney;
    private Card card;
    private int rating;

    public Passenger(Passenger passenger) {
        super((Person) passenger);
        this.PASSENGER_ID = passenger.getPassengerID();
        this.onJourney = passenger.isOnJourney();
        this.card = passenger.getCard();
        this.rating = passenger.getRating();
    }

    private Passenger(Person person, int PassengerID1, Boolean journeys1, Card card1, int rating1) {
        super(person);
        this.PASSENGER_ID = PassengerID1;
        this.onJourney = journeys1;
        this.card = card1;
        this.rating = rating1;
    }

    public int getPassengerID() {
        return this.PASSENGER_ID;
    }

    /**
     * Returns if the passenger is on a journey
     *
     * @return
     */
    public Boolean isOnJourney() {
        return this.onJourney;
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
     * Set passenger on a journey
     *
     * @param newJourney
     */
    public void setOnJourney(Boolean newJourney) {
        this.onJourney=newJourney;
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
        private Boolean journey;
        private Card card;
        private int rating;
        private Person person;

        public Builder setPassenger(int newID) {
            this.PASSENGER_ID = newID;
            return this;
        }

        public Builder setOnJourney(Boolean onJourney) {
            this.journey = onJourney;
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
            return new Passenger(this.person, this.PASSENGER_ID, this.journey, this.card, this.rating);
        }
    }
}
