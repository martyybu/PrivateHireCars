/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.Person.DaoImplementation;

import java.util.ArrayList;
import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Person.Dao.PersonDao;
import uk.ac.gre.ma8521e.privatehirecars.Person.Passenger;
import uk.ac.gre.ma8521e.privatehirecars.Person.Person;

/**
 *
 * @author micae
 */
public class PersonDaoImpl implements PersonDao {

    //list is working as a database
    List<Person> students;
    
    public PersonDaoImpl(){
        students = new ArrayList<Person>();
    }

    @Override
    public List<Person> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Passenger getPerson(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
