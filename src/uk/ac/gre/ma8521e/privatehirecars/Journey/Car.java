package uk.ac.gre.ma8521e.privatehirecars.Journey;

import uk.ac.gre.ma8521e.privatehirecars.Actors.Driver;

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

    public Car(String VIN1, String PLATENO, int noSeats1, String brand1, String Model1) {
        this.VIN = VIN1;
        MODEL = Model1;
        this.PLATENO = PLATENO;
        this.SEATS = noSeats1;
        this.BRAND = brand1;
    }

    @Override
    public String toString(){
        return this.BRAND+", "+this.MODEL+ ", Seats: "+this.SEATS+"-"+this.VIN;
    }
    
}
