package model;//package view;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import view.ControllPanel;
import view.OptionInfoPanel;
import view.OptionPanel;
import view.ResultPanel;

/**
 * This main frame is the basic container for all other sub frames.
 * 
 * @author Castiel
 * @since 2015.03.02
 * @version 1.0.0
 * 
 */
public class MainFrame extends JFrame{ 
    public MainFrame(){
        setTitle("model.Option Pricer");
        this.setBackground(new java.awt.Color(150, 0, 0));
        setSize(1000, 700);
        
        Container c = getContentPane();
        
        initHeadPanel();
        
        //pack();  
      
        c.setLayout(new FlowLayout(1, 10, 10));
        c.add(headPanel);
        OptionPanel op = new OptionPanel(this);
        c.add(op);              
        
//        // main controll area
//        view.OptionInfoPanel oip = new view.OptionInfoPanel("American model.Option", "CALL");
//        c.add(oip);
//        JButton backButton = new JButton();
//        backButton.setText("");
//        c.add(backButton);
        
//        view.ControllPanel cp = new view.ControllPanel();
//        c.add(cp);
        
        // result area
//        view.OptionInfoPanel oip = new view.OptionInfoPanel("American model.Option", "CALL");
//        c.add(oip);
//        JButton backButton = new JButton();
//        backButton.setText("");
//        c.add(backButton);
//        
//        view.ResultPanel rp = new view.ResultPanel();
//        c.add(rp);
                     
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);    
    }
    
    public MainFrame(String operation, Option op){
        setTitle("model.Option Pricer");
        this.setBackground(new java.awt.Color(150, 0, 0));
        setSize(1000, 700);
        
        Container c = getContentPane();      
        initHeadPanel();
      
        c.setLayout(new FlowLayout(1, 10, 10));
        c.add(headPanel);             
        
        if(operation.equals("CONTROLL")){
            // main controll area
            OptionInfoPanel oip = new OptionInfoPanel(op.getStyle(), op.getRight());
            c.add(oip);
            JButton backButton = new JButton();
            backButton.setText("");
            c.add(backButton);

            ControllPanel cp = new ControllPanel(this, op);
            c.add(cp);
        }
        
        else if(operation.equals("RESULT")){
            // result area
            OptionInfoPanel oip = new OptionInfoPanel(op.getStyle(), op.getRight());
            c.add(oip);
            JButton backButton = new JButton();
            backButton.setText("");
            c.add(backButton);
            
            ResultPanel rp = new ResultPanel(op);
            c.add(rp);
        }
   
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);    
    }
    
    private void initHeadPanel(){
        headPanel = new javax.swing.JPanel();
        headLabel = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        headPanel.setBackground(new java.awt.Color(150, 0, 0));
        headPanel.setMaximumSize(new java.awt.Dimension(1000, 100));
        headPanel.setMinimumSize(new java.awt.Dimension(1000, 100));
        headPanel.setPreferredSize(new java.awt.Dimension(1000, 100));

        headLabel.setBackground(new java.awt.Color(150, 0, 0));
        headLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/cmu_wordmark.jpg"))); // NOI18N
        headLabel.setMaximumSize(new java.awt.Dimension(150, 100));
        headLabel.setMinimumSize(new java.awt.Dimension(150, 100));
        headLabel.setPreferredSize(new java.awt.Dimension(150, 100));

        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    }
    
    
    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headLabel;
    private javax.swing.JPanel headPanel;
    // End of variables declaration//GEN-END:variables
}