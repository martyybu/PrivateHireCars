/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Person.Dao;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Person.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Person.Person;

/**
 *
 * @author micae
 */
public interface PersonDao {

    public List<Person> getAll();

    public Passenger getPerson(int ID);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

}
