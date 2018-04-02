/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.PersonDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.LoginView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.SignUpView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Models.Login;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.MainView;
import uk.ac.gre.ma8521e.privatehirecars.PrivateHireCars;

/**
 *
 * @author ma8521e
 */
public class LoginController {

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
            view.dispose();
            MainView mainView = new MainView();
            mainView.setVisible(true);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            mainView.setLocation(new Point((screenSize.width / 2) - mainView.getWidth() / 2, (screenSize.height / 2) - mainView.getHeight() / 2));
            MainController mC =new MainController(new PersonDaoImpl().getPerson(username));
            MainController.person=new PersonDaoImpl().getPerson(username);
            mC.addView(mainView);
        } else {
            JOptionPane.showMessageDialog(view,
                    login.getMessage().get(0));
        }

    }

    public void signupButtonPressed(ActionEvent evt) {
        SignUpView SignUpView = new SignUpView();
        view.dispose();
        SignUpController sC = new SignUpController();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SignUpView.setLocation(new Point((screenSize.width / 2) - SignUpView.getWidth() / 2, (screenSize.height / 2) - SignUpView.getHeight() / 2));
        sC.addView(SignUpView);
        SignUpView.setVisible(true);

    }
}
