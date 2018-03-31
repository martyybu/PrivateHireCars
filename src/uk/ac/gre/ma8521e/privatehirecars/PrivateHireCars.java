/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars;

import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.PersonDaoImpl;

/**
 *
 * @author micae
 */
public class PrivateHireCars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person = new PersonDaoImpl().getPerson("Andy");
        System.out.println(""+person);
        person.setFirstName("AndyChanged");
        new PersonDaoImpl().updatePerson(person);
        Person person2= new PersonDaoImpl().getPerson("Andy");
        System.out.println(""+person2);
    }
    
}
