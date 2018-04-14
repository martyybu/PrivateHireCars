package uk.ac.gre.ma8521e.privatehirecars.Journey;


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

    public Car(String VIN1, String PLATENO, int noSeats1, String brand1, String Model1,Integer rating) {
        this.VIN = VIN1;
        MODEL = Model1;
        this.PLATENO = PLATENO;
        this.SEATS = noSeats1;
        this.BRAND = brand1;
        this.rating=rating;
    }

    @Override
    public String toString(){
        return this.BRAND+", "+this.MODEL+ ", Seats: "+this.SEATS+"-"+this.VIN;
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
