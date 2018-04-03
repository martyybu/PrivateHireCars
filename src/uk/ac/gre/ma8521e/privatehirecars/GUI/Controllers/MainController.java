package uk.ac.gre.ma8521e.privatehirecars.GUI.Controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.BookingView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateBooking;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.CreateEnquiry;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.MainView;
import uk.ac.gre.ma8521e.privatehirecars.GUI.Views.Profile;

/**
 *
 * @author ma8521e
 */
public class MainController {

    MainView view;

    public MainController() {

    }

    public void addView(MainView view2) {
        view = view2;
        setupListener();

    }

    public void setupListener() {
        view.getBookings().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                clickedBookings(evt);
            }
        });
        view.getCreateBookings().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                clickedCreateBookings(evt);
            }
        });
        view.getCreateEnquiries().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                clickedCreateEnquiries(evt);
            }
        });
        view.getProfile().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                clickedProfile(evt);
            }
        });
    }

    public void changeLeftPanel(JPanel jpanel) {
        //Reset jpanel
        view.getLeftPanel().removeAll();
        view.validate();
        view.repaint();
        //adding Panel
        view.getLeftPanel().add(jpanel);
        view.validate();
        view.repaint();
    }

    public void clickedBookings(MouseEvent event) {
        resetColor(view.getCreateBookings());
        resetColor(view.getCreateEnquiries());
        resetColor(view.getProfile());
        setColor(view.getBookings());
        BookingView bookingView = new BookingView();
        changeLeftPanel(bookingView);
    }

    public void clickedCreateEnquiries(MouseEvent event) {
        resetColor(view.getCreateBookings());
        setColor(view.getCreateEnquiries());
        resetColor(view.getProfile());
        resetColor(view.getBookings());
        CreateEnquiry createEnquiryView = new CreateEnquiry();
        changeLeftPanel(createEnquiryView);
    }

    public void clickedProfile(MouseEvent event) {
        resetColor(view.getCreateBookings());
        resetColor(view.getCreateEnquiries());
        setColor(view.getProfile());
        resetColor(view.getBookings());
        Profile profileView = new Profile();
        changeLeftPanel(profileView);
    }

    public void clickedCreateBookings(MouseEvent event) {
        setColor(view.getCreateBookings());
        resetColor(view.getCreateEnquiries());
        resetColor(view.getProfile());
        resetColor(view.getBookings());
        CreateBooking createBooking = new CreateBooking();
        changeLeftPanel(createBooking);
    }

    public void resetColor(JPanel jpanel) {
        jpanel.setBackground(new Color(64, 43, 100));
    }

    public void setColor(JPanel jpanel) {
        jpanel.setBackground(new Color(85, 65, 118));
    }
}