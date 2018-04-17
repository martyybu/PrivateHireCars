package uk.ac.gre.ma8521e.privatehirecars.Journey;

import java.math.BigDecimal;
import java.util.Date;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Payment.Payment;

/**
 *
 * @author micael
 */
public class Journey {

    private int ID;
    private String startingLocation;
    private String destination;
    private Date date2;
    private Passenger passenger;
    private Driver driver;
    private Car car;
    private Integer duration;
    private Integer journeyRating;
    private Integer carRating;
    private Integer driverRating;
    private JourneyState state;
    private Payment payment;
    private BigDecimal price;
    private JourneyNotification notification;
    private String review;

    public Journey(Journey journey) {
        this.startingLocation = journey.getStartingLocation();
        this.destination = journey.getDestination();
        this.date2 = journey.getDate();
        this.passenger = journey.getPassenger();
        this.driver = journey.getDriver();
        this.car = journey.getCar();
        this.duration = journey.getDuration();
        this.journeyRating = journey.getRating();
        this.state = journey.getState();
        this.payment = journey.getPayment();
        this.price = journey.getPrice();
        this.notification = journey.getNotifications();
    }

    private Journey(String startingLocation, String destination, Date date, Passenger passenger, Driver driver, Car car, Integer duration,
            Integer rating, JourneyState state, Payment payment, BigDecimal price, JourneyNotification notification) {
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.date2 = date;
        this.passenger = passenger;
        this.driver = driver;
        this.car = car;
        this.duration = duration;
        this.journeyRating = rating;
        this.state = state;
        this.payment = payment;
        this.price = price;
        this.notification = notification;
    }

    /**
     * Returns notification specified by the user
     *
     * @return
     */
    public JourneyNotification getNotifications() {
        return notification;
    }

    public int getID() {
        return this.ID;
    }

    public void addID(int newInt) {
        this.ID = newInt;
    }

    /**
     * #
     * Returns the customer review
     *
     * @return
     */
    public String getReview() {
        return this.review;
    }

    /**
     * Returns the starting Location
     *
     * @return
     */
    public String getStartingLocation() {
        return this.startingLocation;
    }

    /**
     * Returns the destination location
     *
     * @return
     */
    public String getDestination() {
        return this.destination;
    }

    /**
     * Returns the date2 of the journey
     *
     * @return
     */
    public Date getDate() {
        return this.date2;
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
        price = (new BigDecimal(duration).multiply(BigDecimal.valueOf(0.4))).add(BigDecimal.valueOf(4));
        return price;
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
    public Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns the rating of this journey;
     *
     * @return
     */
    public int getRating() {
        return this.journeyRating;
    }

    /**
     * Returns the rating of this car set by the passenger;
     *
     * @return
     */
    public int getCarRating() {
        return this.carRating;
    }

    /**
     * Returns the rating set by the passenger of this driver;
     *
     * @return
     */
    public int getDriverRating() {
        return this.driverRating;
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
    public void setStartingLocation(String newLocation) {
        this.startingLocation = newLocation;
    }

    /**
     *
     * Set the destination location
     *
     * @param newLocation
     */
    public void setDestination(String newLocation) {
        this.destination = newLocation;
    }

    /**
     * Set the date2 of journey
     *
     * @param newDate
     */
    public void setDate(Date newDate) {
        this.date2 = newDate;
    }

    /**
     * Add a passenger toi the Journey
     *
     * @param passenger
     */
    public void addPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void addReview(String review) {
        this.review = review;
    }

    /**
     * Set journeyNotification
     *
     * @param jn
     */
    public void setJourneyNotification(JourneyNotification jn) {
        this.notification = jn;
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
    public void setDuration(Integer newDuration) {
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

    public void setJourneyRating(int newRating) {
        this.journeyRating = newRating;
    }

    public void setCarRating(int newRating) {
        this.carRating = newRating;
        this.car.rate(newRating);
    }

    public void setDriverRating(int newRating) {
        this.driverRating = newRating;
        this.driver.rate(newRating);
    }

    /**
     * Set the journeyState
     *
     * @param newState
     */
    public void setJourneyState(JourneyState newState) {
        this.state = newState;
    }

    @Override
    public String toString() {
        return this.getStartingLocation() + " - " + this.getDestination();
    }

    public static final class Builder {

        private String startingLocation;
        private String destination;
        private Date date2;
        private Passenger passenger;
        private Driver driver;
        private Car car;
        private Integer duration;
        private Integer rating;
        private JourneyState state;
        private Payment payment;
        private BigDecimal price;
        private JourneyNotification notification;

        public Builder setTo(String loc) {
            this.startingLocation = loc;
            return this;
        }

        public Builder setFrom(String loc) {
            this.destination = loc;
            return this;
        }

        public Builder setDate(Date date) {
            this.date2 = date;
            return this;
        }

        public Builder setPassenger(Passenger passenger) {
            this.passenger = passenger;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setCar(Car car) {
            this.car = car;
            return this;
        }

        public Builder setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder setRating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public Builder setState(JourneyState state) {
            this.state = state;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setNotification(JourneyNotification jn) {
            this.notification = jn;
            return this;
        }

        public Journey build() {
            return new Journey(startingLocation, destination, date2, passenger, driver, car, duration, rating, state,
                    payment, price, notification);
        }

    }
}
