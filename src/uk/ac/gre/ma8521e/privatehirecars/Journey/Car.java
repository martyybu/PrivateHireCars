package uk.ac.gre.ma8521e.privatehirecars.Journey;

import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;

/**
 *
 * @author micael
 */
public class Car {

    final String VIN;
    final int SEATS;
    final int PLATENO;
    final String BRAND;
    final Driver DRIVER;

    public Car(String VIN1, int PLATENO, int noSeats1, String brand1, Driver driver1) {
        this.VIN = VIN1;
        this.PLATENO = PLATENO;
        this.SEATS = noSeats1;
        this.BRAND = brand1;
        this.DRIVER = driver1;
    }

}
