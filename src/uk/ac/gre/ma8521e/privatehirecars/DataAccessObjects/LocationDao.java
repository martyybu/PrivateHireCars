package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import uk.ac.gre.ma8521e.privatehirecars.Journey.Location;

/**
 *
 * @author micae
 */
public interface LocationDao {
    
    public Location getLocation(Integer ID);
    
    public void createLocation(Location loc);
}
