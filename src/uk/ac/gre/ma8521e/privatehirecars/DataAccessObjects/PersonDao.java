/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;

/**
 *
 * @author micae
 */
public interface PersonDao {

    public List<Person> getAll();

    public Person getPerson(String ID);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

}
