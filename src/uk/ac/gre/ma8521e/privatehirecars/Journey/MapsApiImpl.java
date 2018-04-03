/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Journey;

import java.util.Random;

/**
 *
 * @author micae
 */
public class MapsApiImpl implements MapsApi {

    @Override
    public Location getLocation(String string) {
        return new Location(1, "Ullin Street", "7", "0", "E146PN", "UK", "London");
    }

    @Override
    public int getDistanceBetweenLocation(Location loc1, Location loc2) {
        Random random = new Random();
        int randomNumber = 0 + random.nextInt((10000 - 1) + 1);
        return randomNumber;
    }

    @Override
    public int getDuration(Location loc1, Location loc2) {
        Random random = new Random();
        int randomNumber = 0 + random.nextInt((60 - 1) + 1);
        return randomNumber;
    }
}
