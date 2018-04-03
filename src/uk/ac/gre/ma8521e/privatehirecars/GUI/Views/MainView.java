/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Views;

import javax.swing.JPanel;

/**
 *
 * @author ma8521e
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView1
     */
    public MainView() {
        initComponents();
    }
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        sideMenu = new javax.swing.JPanel();
        btn_profile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_bookings = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_createbookings = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_createEnquiries = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1210, 550));
        setPreferredSize(new java.awt.Dimension(1210, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        bg.setMaximumSize(new java.awt.Dimension(1283, 550));
        bg.setMinimumSize(new java.awt.Dimension(1283, 550));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideMenu.setBackground(new java.awt.Color(54, 33, 89));
        sideMenu.setAutoscrolls(true);
        sideMenu.setRequestFocusEnabled(false);
        sideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_profile.setBackground(new java.awt.Color(85, 65, 118));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/gre/ma8521e/privatehirecars/GUI/Images/icons8_User_Account_15px.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Profile");

        javax.swing.GroupLayout btn_profileLayout = new javax.swing.GroupLayout(btn_profile);
        btn_profile.setLayout(btn_profileLayout);
        btn_profileLayout.setHorizontalGroup(
            btn_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_profileLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        btn_profileLayout.setVerticalGroup(
            btn_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_profileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideMenu.add(btn_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 40));

        btn_bookings.setBackground(new java.awt.Color(64, 43, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/gre/ma8521e/privatehirecars/GUI/Images/icons8_Booking_15px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Bookings");

        javax.swing.GroupLayout btn_bookingsLayout = new javax.swing.GroupLayout(btn_bookings);
        btn_bookings.setLayout(btn_bookingsLayout);
        btn_bookingsLayout.setHorizontalGroup(
            btn_bookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_bookingsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        btn_bookingsLayout.setVerticalGroup(
            btn_bookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_bookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideMenu.add(btn_bookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 240, 40));

        btn_createbookings.setBackground(new java.awt.Color(64, 43, 100));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/gre/ma8521e/privatehirecars/GUI/Images/icons8_Plus_15px_2.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Create a Booking");

        javax.swing.GroupLayout btn_createbookingsLayout = new javax.swing.GroupLayout(btn_createbookings);
        btn_createbookings.setLayout(btn_createbookingsLayout);
        btn_createbookingsLayout.setHorizontalGroup(
            btn_createbookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_createbookingsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        btn_createbookingsLayout.setVerticalGroup(
            btn_createbookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_createbookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideMenu.add(btn_createbookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 40));

        btn_createEnquiries.setBackground(new java.awt.Color(64, 43, 100));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/gre/ma8521e/privatehirecars/GUI/Images/icons8_Plus_15px_2.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Create Enquiry");

        javax.swing.GroupLayout btn_createEnquiriesLayout = new javax.swing.GroupLayout(btn_createEnquiries);
        btn_createEnquiries.setLayout(btn_createEnquiriesLayout);
        btn_createEnquiriesLayout.setHorizontalGroup(
            btn_createEnquiriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_createEnquiriesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        btn_createEnquiriesLayout.setVerticalGroup(
            btn_createEnquiriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_createEnquiriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideMenu.add(btn_createEnquiries, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("PrivateHire Cars");
        sideMenu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("PrivateHire Cars");
        sideMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        bg.add(sideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 550));

        jPanel2.setLayout(new java.awt.CardLayout());
        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 930, 550));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getBookings() {
        return btn_bookings;
    }

    public JPanel getCreateEnquiries() {
        return this.btn_createEnquiries;
    }

    public JPanel getCreateBookings() {
        return this.btn_createbookings;
    }

    public JPanel getProfile() {
        return this.btn_profile;
    }

    public JPanel getLeftPanel() {
        return this.jPanel2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btn_bookings;
    private javax.swing.JPanel btn_createEnquiries;
    private javax.swing.JPanel btn_createbookings;
    private javax.swing.JPanel btn_profile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel sideMenu;
    // End of variables declaration//GEN-END:variables
}
