/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;

/**
 *
 * @author micae
 */
public interface JourneyDao {

    public List<Journey> getAllJourneys();

    public Journey getJourney(int ID);

    public void updateJourney(Journey journey);

    public void deleteJourney(Journey journey);
}
