/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Actors;

import uk.ac.gre.ma8521e.privatehirecars.Journey.Car;

/**
 *
 * @author micae
 */
public class Driver extends Person {

    private final int DRIVER_ID;
    private Car car;
    private Boolean onJourney;
    private int rating;

    private Driver(Person person, int DriverID1, Car car1, Boolean journey1, int rating1) {
        super(new Person.Builder()
                .setID(person.getID())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setGender(person.getGender())
                .setYearOfBirth(person.getYearOfBirthday())
                .build());
        this.DRIVER_ID = DriverID1;
        this.rating = rating1;
        this.car = car1;
        this.onJourney = journey1;
    }

    public int getDriverID() {
        return this.DRIVER_ID;
    }

    /**
     * Returns driver's car
     *
     * @return
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * Returns if driver's journeys
     *
     * @return
     */
    public boolean isOnaJourney() {
        return this.onJourney;
    }

    /**
     * Returns driver Rating
     *
     * @return
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Add car driver is using
     *
     * @param newCar
     */
    public void setCar(Car newCar) {
        this.car = newCar;
    }

    /**
     * Driver is on a journey
     *
     * @param newJourney
     */
    public void onJourney(boolean newJourney) {
        this.onJourney = newJourney;
    }

    /**
     * Rates the driver by adding a rating
     *
     * @param newRating
     */
    public void rate(int newRating) {
        setRating((getRating() + newRating) / 2);
    }

    /**
     * Set Rating of the driver This shouldn't be used outside this class
     *
     * @param newRating
     */
    private void setRating(int newRating) {
        this.rating = newRating;
    }

    @Override
    public String getID() {
        return super.getID();
    }

    public static final class Builder {

        private int DRIVER_ID;
        private Car car;
        private Boolean onJourney;
        private int rating;
        private Person person;

        public Builder setID(int newID) {
            this.DRIVER_ID = newID;
            return this;
        }

        public Builder setCar(Car newCar) {
            this.car = newCar;
            return this;
        }

        public Builder setonJourney(Boolean newJourneys) {
            this.onJourney = newJourneys;
            return this;
        }

        public Builder setRating(int newRate) {
            this.rating = newRate;
            return this;
        }

        public Builder setPerson(Person newPerson) {
            this.person = newPerson;
            return this;
        }

        public Driver build() {
            return new Driver(this.person, this.DRIVER_ID,this.car, this.onJourney, this.rating);
        }

    }
}
