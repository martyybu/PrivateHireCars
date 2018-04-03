/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateEnquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.EnquiryView;

/**
 *
 * @author micae
 */
public class EnquiryController {

    private EnquiryView view;

    public EnquiryController() {

    }

    void addView(EnquiryView v2) {
        view = v2;
    }

    void setupListeners() {
        view.getlistofTrips().addActionListener(evt -> changeListOfTrips(evt));
        view.getlistOfEnquiries().addActionListener(evt -> changeListOfEnquiries(evt));
        view.getsendBtn().addActionListener(evt ->sendBtn(evt));
    }

    void sendBtn(ActionEvent evt) {
    }

    void changeListOfEnquiries(ActionEvent evt) {
    }

    void changeListOfTrips(ActionEvent evt) {
    }
}
