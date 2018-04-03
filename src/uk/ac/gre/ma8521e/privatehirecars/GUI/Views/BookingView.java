/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.gre.ma8521e.privatehirecars.GUI.Views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ma8521e
 */
public class BookingView extends javax.swing.JPanel {

    /**
     * Creates new form BookingView
     */
    public BookingView() {
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

        jPanel2 = new javax.swing.JPanel();
        title_Pane = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        Bookings = new javax.swing.JComboBox<>();
        Name7 = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        Name1 = new javax.swing.JLabel();
        Name5 = new javax.swing.JLabel();
        Name6 = new javax.swing.JLabel();
        Name3 = new javax.swing.JLabel();
        Name8 = new javax.swing.JLabel();
        Name9 = new javax.swing.JLabel();
        reviewText = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        send = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Name10 = new javax.swing.JLabel();
        fromLbl = new javax.swing.JLabel();
        toLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        durationLbl = new javax.swing.JLabel();
        driverLbl = new javax.swing.JLabel();
        ratingCombo = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(930, 550));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title_Pane.setBackground(new java.awt.Color(110, 89, 222));

        Name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Your bookings");

        javax.swing.GroupLayout title_PaneLayout = new javax.swing.GroupLayout(title_Pane);
        title_Pane.setLayout(title_PaneLayout);
        title_PaneLayout.setHorizontalGroup(
            title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_PaneLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bookings, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(820, Short.MAX_VALUE))
        );
        title_PaneLayout.setVerticalGroup(
            title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_PaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Name)
                .addGap(18, 18, 18)
                .addComponent(Bookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel2.add(title_Pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 990, -1));

        Name7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name7.setText("Date:");
        jPanel2.add(Name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        priceLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceLbl.setForeground(new java.awt.Color(51, 51, 51));
        priceLbl.setText("Price");
        jPanel2.add(priceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));

        Name1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name1.setForeground(new java.awt.Color(51, 51, 51));
        Name1.setText("To:");
        jPanel2.add(Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        Name5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name5.setForeground(new java.awt.Color(51, 51, 51));
        Name5.setText("Duration:");
        jPanel2.add(Name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        Name6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name6.setForeground(new java.awt.Color(51, 51, 51));
        Name6.setText("Driver:");
        jPanel2.add(Name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        Name3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name3.setText("Price:");
        jPanel2.add(Name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        Name8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name8.setText("Rating:");
        jPanel2.add(Name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        Name9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name9.setText("Review:");
        jPanel2.add(Name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        textArea.setColumns(20);
        textArea.setRows(5);
        reviewText.setViewportView(textArea);

        jPanel2.add(reviewText, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 340, 120));

        send.setText("Send Review");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        jPanel2.add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setText("Receipt");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, -1));

        Name10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Name10.setForeground(new java.awt.Color(51, 51, 51));
        Name10.setText("From:");
        jPanel2.add(Name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        fromLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fromLbl.setForeground(new java.awt.Color(51, 51, 51));
        fromLbl.setText("Street");
        jPanel2.add(fromLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        toLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toLbl.setForeground(new java.awt.Color(51, 51, 51));
        toLbl.setText("Street");
        jPanel2.add(toLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        dateLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(51, 51, 51));
        dateLbl.setText("Date");
        jPanel2.add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        durationLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        durationLbl.setForeground(new java.awt.Color(51, 51, 51));
        durationLbl.setText("Duration");
        jPanel2.add(durationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        driverLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        driverLbl.setForeground(new java.awt.Color(51, 51, 51));
        driverLbl.setText("Driver");
        jPanel2.add(driverLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        ratingCombo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ratingCombo.setForeground(new java.awt.Color(255, 204, 0));
        ratingCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "**", "***", "****", "*****" }));
        jPanel2.add(ratingCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendActionPerformed

    public JLabel getDateLbl() {
        return this.dateLbl;
    }

    public JLabel getDriverLbl() {
        return this.driverLbl;
    }

    public JLabel getDurationLbl() {
        return this.durationLbl;
    }
    
    public JLabel getfromLbl(){
        return this.fromLbl;
    }
    
    public JLabel getToLbl(){
        return this.toLbl;
    }
    
    public JLabel getPriceLbl(){
        return this.priceLbl;
    }
    
    public JButton getSendButton(){
        return this.send;
    }
    
    public JButton getReceiptButton(){
        return this.jButton1;
    }
    
    public JTextArea getReviewTxt(){
        return this.textArea;
    }
    
    public JComboBox<String> getRatingLbl(){
        return this.ratingCombo;
    }
    
    public JComboBox<String> getBookingsCombo(){
        return this.Bookings;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Bookings;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Name1;
    private javax.swing.JLabel Name10;
    private javax.swing.JLabel Name3;
    private javax.swing.JLabel Name5;
    private javax.swing.JLabel Name6;
    private javax.swing.JLabel Name7;
    private javax.swing.JLabel Name8;
    private javax.swing.JLabel Name9;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel driverLbl;
    private javax.swing.JLabel durationLbl;
    private javax.swing.JLabel fromLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JComboBox<String> ratingCombo;
    private javax.swing.JScrollPane reviewText;
    private javax.swing.JButton send;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel title_Pane;
    private javax.swing.JLabel toLbl;
    // End of variables declaration//GEN-END:variables
}
