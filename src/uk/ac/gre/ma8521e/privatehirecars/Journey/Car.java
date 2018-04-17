package uk.ac.gre.ma8521e.privatehirecars.Journey;

import java.util.Objects;

/**
 *
 * @author micael
 */
public class Car {

    public final String VIN;
    public final int SEATS;
    public final String PLATENO;
    public final String BRAND;
    public final String MODEL;
    private Integer rating;

    public Car(String VIN1, String PLATENO, int noSeats1, String brand1, String Model1, Integer rating) {
        this.VIN = VIN1;
        MODEL = Model1;
        this.PLATENO = PLATENO;
        this.SEATS = noSeats1;
        this.BRAND = brand1;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.BRAND + ", " + this.MODEL + ", Seats: " + this.SEATS + "-" + this.VIN;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        // field comparison
        return Objects.equals(VIN, car.VIN);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.VIN);
        return hash;
    }

    /**
     * Rates the car by adding a rating
     *
     * @param newRating
     */
    public void rate(int newRating) {
        setRating((getRating() + newRating) / 2);
    }

    /**
     * Set Rating of the car This shouldn't be used outside this class
     *
     * @param newRating
     */
    private void setRating(int newRating) {
        this.rating = newRating;
    }

    /**
     * Returns car Rating
     *
     * @return
     */
    public int getRating() {
        return this.rating;
    }
}
