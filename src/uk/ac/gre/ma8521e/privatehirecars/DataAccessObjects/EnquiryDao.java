/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.DataAccessObjects;

import java.util.List;
import uk.ac.gre.ma8521e.privatehirecars.Enquiry;

/**
 *
 * @author micae
 */
public interface EnquiryDao {
    
    public Enquiry getEnquiry(int ID);
    public List<Enquiry> getPersonEnquiries(int personID);
    public void updateEnquiry(Enquiry enquiry);
    public void insertEnquiry(Enquiry enquiry);
}
