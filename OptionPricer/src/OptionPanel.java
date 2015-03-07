/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Castiel
 * @since 2015.03.03
 * @version 1.0.0
 */
public class OptionPanel extends JPanel{

    public OptionPanel(){
        selectPanel = new JPanel();
        backgroundPanel = new JPanel();
        infoLabel = new javax.swing.JLabel();
        EuropeanRadioButton = new javax.swing.JRadioButton();
        AmericanRadioButton = new javax.swing.JRadioButton();
        AsianRadioButton = new javax.swing.JRadioButton();
        callButton = new javax.swing.JButton();
        putButton = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectPanel.setBackground(new Color(150, 0, 0));
        backgroundPanel.setBackground(Color.white);

        infoLabel.setText("Please choose an option you want:");

        EuropeanRadioButton.setText("European");

        AmericanRadioButton.setText("American");

        AsianRadioButton.setText("Asian");

        callButton.setText("CALL");

        putButton.setText("PUT");

        javax.swing.GroupLayout selectPanelLayout = new javax.swing.GroupLayout(selectPanel);
        selectPanel.setLayout(selectPanelLayout);
        //selectPanel.setSize(500,500);
        selectPanelLayout.setHorizontalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, true)
                    .addGroup(selectPanelLayout.createSequentialGroup()
                        .addGroup(selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AsianRadioButton)
                            .addComponent(AmericanRadioButton)
                            .addComponent(EuropeanRadioButton)
                            .addComponent(infoLabel))
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(callButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(putButton)
                        .addGap(80, 80, 80))))
        );

        selectPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {callButton, putButton});

        selectPanelLayout.setVerticalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoLabel)
                .addGap(20, 20, 20)
                .addComponent(EuropeanRadioButton)
                .addGap(20, 20, 20)
                .addComponent(AmericanRadioButton)
                .addGap(20, 20, 20)
                .addComponent(AsianRadioButton)
                .addGap(45, 45, 45)
                .addGroup(selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callButton)
                    .addComponent(putButton))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        // Modifier: for the gap between selectPanel and backgroundPanel
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(100, 300)
                .addComponent(selectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        add(selectPanel, "center");
        add(backgroundPanel, "center");
    }

//    public static JPanel testJP(){
//        JPanel t = new JPanel();
//        t.setSize(300,300);
//        t.setBackground(Color.BLUE);
//
//        return t;
//    }

//     public static void main(String[] args){
//        JFrame a = new JFrame();
//        a.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        a.setVisible(true);
//        a.setSize(1000, 500);
//        OptionPanel op = new OptionPanel();
////        JPanel tp = testJP();
////        tp.setBackground(Color.red);
////        tp.setSize(200, 200);
//        op.setSize(500, 500);
//        //a.add(tp);
//        //a.add(op);
//        a.setContentPane(op);
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AmericanRadioButton;
    private javax.swing.JRadioButton AsianRadioButton;
    private javax.swing.JRadioButton EuropeanRadioButton;
    private javax.swing.JButton callButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton putButton;
    public JPanel selectPanel;
    private JPanel backgroundPanel;
    // End of variables declaration//GEN-END:variables
}
