/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.LoginView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.SignUp;

/**
 *
 * @author ma8521e
 */
public class LoginController implements ActionListener{
    
    private LoginView view;
    
    public LoginController(){
    }
    
    public void addView(LoginView newView){
        view=newView;
                setupListeners();

    }
    
    public void setupListeners(){
        view.getLoginButton().addActionListener(evt -> loginButtonPressed(evt));
        view.getSignupButton().addActionListener(evt -> signupButtonPressed(evt));
    }
    
    public void loginButtonPressed(ActionEvent evt){

    }
    
    public void signupButtonPressed(ActionEvent evt){
        SignUp SignUpView = new SignUp();
        view.dispose();
        SignUpView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}