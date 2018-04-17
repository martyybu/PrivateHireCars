/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars;

import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.Journey.Journey;


public class Enquiry {
    private int ID;
    private String enquiry;
    private Journey journey;
    private Person person;
    private Person staff;
    private String answer;
    
    public Enquiry(int ID,String enquiry,String answer,Person staff,Person person,Journey j){
        this.ID=ID;
        this.enquiry=enquiry;
        this.answer=answer;
        this.person=person;
        this.staff=staff;
        this.journey=j;
    }
    
        public Enquiry(String enquiry,String answer,Person staff,Person person,Journey j){
        this.enquiry=enquiry;
        this.answer=answer;
        this.person=person;
        this.staff=staff;
        this.journey=j;
    }
    
    public Journey getJourney(){return this.journey;}
    public int getID(){return this.ID;}
    public Person getPerson(){return this.person;}
    public Person getStaff(){return this.staff;}
    public String getAnswer(){return this.answer;}
    public String getEnquiry(){return this.enquiry;}
    public void changeEnquiry(String enquiry){this.enquiry=enquiry;}
    public void answer(String answer){this.answer=answer;}
    @Override
    public String toString(){return this.enquiry;}
    
}
