/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import uk.ac.gre.ma8521e.privatehirecars.Actors.Person;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.DriverDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.DaoImplementation.PersonDaoImpl;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers.LoginController;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.LoginView;

/**
 *
 * @author micae
 */
public class PrivateHireCars {
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                LoginView loginView = new LoginView();
                loginView.setLocation(new Point((screenSize.width/2)-loginView.getWidth()/2,(screenSize.height/2)-loginView.getHeight()/2));
                LoginController loginController = new LoginController();
                loginController.addView(loginView);
                loginView.setVisible(true);
                System.out.println(""+new DriverDaoImpl().getAllDrivers());
            }
        });
    }
    
}
