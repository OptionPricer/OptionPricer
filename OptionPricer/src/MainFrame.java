package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
        setTitle("Option Pricer");
        this.setBackground(new java.awt.Color(150, 0, 0));
        setSize(1000, 700);
        
        Container c = getContentPane();
        
        initHeadPanel();
        
        //pack();  
      
        c.setLayout(new FlowLayout(1, 10, 10));
        c.add(headPanel);
        OptionPanel op = new OptionPanel();
//        c.add(op);
                
        
        OptionInfoPanel oip = new OptionInfoPanel("American Option", "CALL");
        c.add(oip);
        
        JButton backButton = new JButton();
        backButton.setText("");
        c.add(backButton);
        //c.add(backButton, javax.swing.GroupLayout.Alignment.BASELINE);
        ControllPanel cp = new ControllPanel();
        c.add(cp);
        
        
        
        
        
        
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(testp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addContainerGap()
//                .addComponent(op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(testp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addContainerGap(0, Short.MAX_VALUE)
//                .addComponent(op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(0, Short.MAX_VALUE))
//                
//        );

        
//        Container c = getContentPane();
//        //c.setLayout(new FlowLayout(1, 20, 30));   //alignment, horizGap, vertGap
//        c.setLayout(new GridLayout(2, 1));
//        JPanel backgroundP = new JPanel(new GridLayout());
//        backgroundP.add(new JLabel("background label"));
//        c.add(backgroundP);
//        
//        for (int i = 0; i < 10; i++){
//            c.add(new JButton("button" + i));
//        }
//        setSize(1000, 1000);
//        setVisible(true);
//        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);    
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
    
    private void initMainPanel(JPanel controlPanel){
//        backgroundPanel = new javax.swing.JPanel();
//        
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
//        backgroundPanel.setLayout(backgroundPanelLayout);
//        backgroundPanelLayout.setHorizontalGroup(
//            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
//                .addContainerGap(270, 270)
//                .addComponent(controlFrame)
//                .addGap(80, 80, 80))
//        );
//        backgroundPanelLayout.setVerticalGroup(
//            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(backgroundPanelLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(controlFrame)
//                .addContainerGap(50, Short.MAX_VALUE))
//        );
//
//         
    }
    
    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headLabel;
    private javax.swing.JPanel headPanel;
    // End of variables declaration//GEN-END:variables
}