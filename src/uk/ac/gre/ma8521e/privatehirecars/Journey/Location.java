package uk.ac.gre.ma8521e.privatehirecars.Journey;


/**
 *
 * @author micael
 */
public class Location {

    final Integer STREET;
    final String NO;
    final String FLOOR;
    final String COUNTRY;
    final String CITY;

    public Location(Integer street1, String no1, String floor1, String city1,String country1) {
        this.STREET = street1;
        this.NO = no1;
        this.FLOOR = floor1;
        this.COUNTRY = country1;
        this.CITY=city1;
    }

}
