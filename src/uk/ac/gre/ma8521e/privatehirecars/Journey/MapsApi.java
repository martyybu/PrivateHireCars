/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Journey;

/**
 *
 * @author micae
 */
public interface MapsApi {
    
    public Location getLocation(String string);
    
    public int getDistanceBetweenLocation(Location loc1,Location loc2);
    
}
