package uk.ac.gre.ma8521e.privatehirecars.Journey;


/**
 *
 * @author micael
 */
public class Location {

    public final Integer LOCATIONID;
    public final String STREET;
    public final String NO;
    public final String FLOOR;
    public final String POSTCODE;
    public final String COUNTRY;
    public final String CITY;

    public Location(Integer location1,String street1, String no1, String floor1,String postcode1, String city1,String country1) {
        this.LOCATIONID=location1;
        this.POSTCODE=postcode1;
        this.STREET = street1;
        this.NO = no1;
        this.FLOOR = floor1;
        this.COUNTRY = country1;
        this.CITY=city1;
    }

}
