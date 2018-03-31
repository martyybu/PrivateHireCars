package uk.ac.gre.ma8521e.privatehirecars.Journey;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Payment.Payment;

/**
 *
 * @author micael
 */
public class Journey {

    private Location startingLocation;
    private Location destination;
    private Date date;
    private Time time;
    private Passenger passenger;
    private Driver driver;
    private Car car;
    private Time duration;
    private int rating;
    private JourneyState state;
    private Payment payment;
    private BigDecimal price;

    public Journey() {
    }

    /**
     * Returns the starting Location
     *
     * @return
     */
    public Location getStartingLocation() {
        return this.startingLocation;
    }

    /**
     * Returns the destination location
     *
     * @return
     */
    public Location getDestination() {
        return this.destination;
    }

    /**
     * Returns the date of the journey
     *
     * @return
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns the time of the journey
     *
     * @return
     */
    public Time getTime() {
        return this.time;
    }

    /**
     * Returns teh passenger for this journey
     *
     * @return
     */
    public Passenger getPassenger() {
        return this.passenger;
    }

    /**
     * Returns tthe price for the journey
     *
     * @return
     */
    public BigDecimal getPrice() {
        if(this.state==JourneyState.FINISHED){
            price = duration*0.50+4;
            return price;
        }else{
            return null;
        }
    }

    /**
     * Returns the driver for this journey
     *
     * @return
     */
    public Driver getDriver() {
        return this.driver;
    }

    /**
     * Returns the car for this journey
     *
     * @return
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * Returns the duration of this journey
     *
     * @return
     */
    public Time getDuration() {
        return this.duration;
    }

    /**
     * Returns the rating of this journey;
     *
     * @return
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Returns the state of this journey
     *
     * @return
     */
    public JourneyState getState() {
        return this.state;
    }

    /**
     * Returns receipt of the journey
     *
     * @return
     */
    public String[] getReceipt() {
        return this.getPayment().getReceipt();
    }

    /**
     * Returns the payment
     *
     * @return
     */
    public Payment getPayment() {
        return this.payment;
    }

    /**
     * Set the starting Location
     *
     * @param newLocation
     */
    public void setStartingLocation(Location newLocation) {
        this.startingLocation = newLocation;
    }

    /**
     *
     * Set the destination location
     *
     * @param newLocation
     */
    public void setDestination(Location newLocation) {
        this.destination = newLocation;
    }

    /**
     * Set the date of journey
     *
     * @param newDate
     */
    public void setDate(Date newDate) {
        this.date = newDate;
    }

    /**
     * Set time of journey
     *
     * @param newTime
     */
    public void setTime(Time newTime) {
        this.time = newTime;
    }

    /**
     * Add a passenger toi the Journey
     *
     * @param passenger
     */
    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Set a driver of the journey
     *
     * @param newDriver
     */
    public void setDriver(Driver newDriver) {
        this.driver = newDriver;
    }

    /**
     * Set the car for the journey
     *
     * @param newCar
     */
    public void setCar(Car newCar) {
        this.car = newCar;
    }

    /**
     * Set duration of the journey
     *
     * @param newDuration
     */
    public void setDuration(Time newDuration) {
        this.duration = newDuration;
    }

    /**
     * Set the payment of the journey
     *
     * @param newPayment
     */
    public void setPayment(Payment newPayment) {
        this.payment = newPayment;
    }

    /**
     * Set the journeyState
     *
     * @param newState
     */
    public void setJourneyState(JourneyState newState) {
        this.state = newState;
    }

}
