/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.LoginView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.SignUp;
import uk.ac.gre.ma8521e.privatehirecars.Login;

/**
 *
 * @author ma8521e
 */
public class LoginController implements ActionListener {

    private LoginView view;

    public LoginController() {
    }

    public void addView(LoginView newView) {
        view = newView;
        setupListeners();

    }

    public void setupListeners() {
        view.getLoginButton().addActionListener(evt -> loginButtonPressed(evt));
        view.getSignupButton().addActionListener(evt -> signupButtonPressed(evt));
    }

    public void loginButtonPressed(ActionEvent evt) {
        String username = view.getUsernameTxt().getText().trim();
        String password = view.getPasswordTxt().getText().trim();
        Login login = new Login(username, password);
        if (login.validateLogin()) {
            JOptionPane.showMessageDialog(view,
                    login.getMessage().get(0));
        } else {
            JOptionPane.showMessageDialog(view,
                    login.getMessage().get(0));
        }

    }

    public void signupButtonPressed(ActionEvent evt) {
        SignUp SignUpView = new SignUp();
        view.dispose();
        SignUpView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
