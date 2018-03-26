/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Person;

import uk.ac.gre.ma8521e.privatehirecars.Journey;
import uk.ac.gre.ma8521e.privatehirecars.Car;
import java.util.List;

/**
 *
 * @author micae
 */
public class Driver extends Person implements PersonI{

    private final int DRIVER_ID;
    private List<Car> cars;
    private List<Journey> journeys;
    private int rating;

    private Driver(Person person, int DriverID1, List<Car> cars1, List<Journey> journeys1, int rating1) {
        super(new Person.Builder()
                .setID(person.getID())
                .setFirstName(person.getFirstName())
                .setLastName(person.getLastName())
                .setGender(person.getGender())
                .setYearOfBirth(person.getYearOfBirthday())
                .build());
        this.DRIVER_ID = DriverID1;
        this.cars = cars1;
        this.journeys = journeys1;
        this.rating = rating1;
    }

    @Override
    public int getID() {
        return this.DRIVER_ID;
    }

    /**
     * Returns drivers cars
     *
     * @return
     */
    public List<Car> getCars() {
        return this.cars;
    }

    /**
     * Returns driver's journeys
     *
     * @return
     */
    public List<Journey> getJourneys() {
        return this.journeys;
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
     * Adds a new car to the owned car list
     *
     * @param newCar
     */
    public void addCar(Car newCar) {
        getCars().add(newCar);
    }

    /**
     * Adds a journey to the journey history
     *
     * @param newJourney
     */
    public void addJourney(Journey newJourney) {
        getJourneys().add(newJourney);
    }

    /**
     * Removes car from owned list
     *
     * @param removeCar
     */
    public void removeCar(Car removeCar) {
        getCars().remove(removeCar);
    }

    /**
     * remove journey from your history
     *
     * @param removeJourney
     */
    public void removeJourney(Journey removeJourney) {
        getJourneys().remove(removeJourney);
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


    public static final class Builder {

        private int DRIVER_ID;
        private List<Car> cars;
        private List<Journey> journeys;
        private int rating;
        private Person person;
        
        public Builder setID(int newID){
            this.DRIVER_ID=newID;
            return this;
        }
        
        public Builder setCars(List<Car> newCars){
            this.cars=newCars;
            return this;
        }
        
        public Builder setJourneys(List<Journey> newJourneys){
            this.journeys=newJourneys;
            return this;
        }
        
        public Builder setRating(int newRate){
            this.rating=newRate;
            return this;
        }
        
        public Builder setPerson(Person newPerson){
            this.person=newPerson;
            return this;
        }
        
    }

}
