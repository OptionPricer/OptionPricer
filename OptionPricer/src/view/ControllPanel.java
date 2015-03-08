package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Option;
import model.OptionRight;

/**
 * This class show the main logic of the algorithms. 
 * 
 * @author Castiel
 * @since 2015.03.07
 * @version 1.0.0
 */
public class ControllPanel extends JPanel implements ActionListener{
    
    public ControllPanel(JFrame jf, Option op){
        mainframe = jf;
        option = op;
        
        this.setBackground(new java.awt.Color(150, 0, 0));
        this.setMaximumSize(new java.awt.Dimension(600, 350));
        this.setMinimumSize(new java.awt.Dimension(600, 350));
        this.setPreferredSize(new java.awt.Dimension(600, 350));     
        
        algorithmsPanel = new JPanel();
        parametersPanel = new JPanel();
        choicePanel = new JPanel();
        
        //construct the algorithmsPanel by the user's choice
        algoInfoLabel = new JLabel();
        algoInfoLabel.setText("Check the algorithms(s) you want to use:");
        bsCheckBox = new JCheckBox();
        bsCheckBox.setText("B-S Formula");
        btCheckBox = new JCheckBox();
        btCheckBox.setText("Binomial Tree");
        niCheckBox = new JCheckBox();
        niCheckBox.setText("Numerical Integration");
        sCheckBox = new JCheckBox();
        sCheckBox.setText("model.SimulationModel");
        
        cusInfoLabel = new JLabel();
        cusInfoLabel.setText("Customized algorithms:");
        
        javax.swing.GroupLayout algorithmsPanelLayout = new javax.swing.GroupLayout(algorithmsPanel);
        algorithmsPanel.setLayout(algorithmsPanelLayout);
        algorithmsPanelLayout.setHorizontalGroup(
            algorithmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algorithmsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(algorithmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, algorithmsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(algorithmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algoInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(niCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(algorithmsPanelLayout.createSequentialGroup()
                        .addComponent(cusInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        algorithmsPanelLayout.setVerticalGroup(
            algorithmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, algorithmsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(algoInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(niCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sCheckBox)
                .addGap(18, 18, 18)
                .addComponent(cusInfoLabel)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        //contruct the parametersPanel
        paraInfoLabel = new JLabel();
        paraInfoLabel.setText("Parameters:");
        s0Label = new JLabel();
        kLabel = new JLabel();
        tLabel = new JLabel();
        rLabel = new JLabel();
        oLabel = new JLabel();
        s0Label.setText("S0:");
        kLabel.setText("K:");
        tLabel.setText("T:");
        rLabel.setText("r:");        
        oLabel.setText("o(σ):");
        sTextField = new JTextField(10);
        kTextField = new JTextField(10);
        tTextField = new JTextField(10);
        rTextField = new JTextField(10);
        oTextField = new JTextField(10);
        
        parametersPanel.setBackground(new java.awt.Color(150,0,0));
        parametersPanel.setLayout(new GridLayout(6,2,2,10));
        parametersPanel.add(paraInfoLabel);
        parametersPanel.add(new JLabel());  //just to keep columns aligned     
        parametersPanel.add(s0Label);
        parametersPanel.add(sTextField);        
        parametersPanel.add(kLabel);
        parametersPanel.add(kTextField);       
        parametersPanel.add(tLabel);
        parametersPanel.add(tTextField);        
        parametersPanel.add(rLabel);
        parametersPanel.add(rTextField);        
        parametersPanel.add(oLabel);
        parametersPanel.add(oTextField);
    
        
        //construct the choicePanel
        noteLabel = new JLabel();
        noteLabel.setText("Note:");
        instruction1Label = new JLabel();
        instruction1Label.setText("S: current stock price;   K: strike price;   "
                + "T term of the option in years;   ");
        instruction2Label = new JLabel();
        instruction2Label.setText("r: risk-free interest rate;   o(σ): "
                + "volatility of the stock price,");
        customizedAlgorithmTextField = new JTextField();
        customizedAlgorithmTextField.setText("[Enter alternate fomula. e.g: S+K+T-r*o]");
        addAlgorithmButton = new JButton();
        addAlgorithmButton.setText("Add");
        //addAlgorithmButton.setSize(new java.awt.Dimension(50, 100));
        graphCheckBox = new JCheckBox();
        graphCheckBox.setText("Show graph");
        calculateButton = new JButton();
        calculateButton.setText("CALCULATE");
        
        choicePanel.setBackground(new java.awt.Color(150,0,0));
        choicePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        choicePanel.add(noteLabel, c);
      
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        choicePanel.add(instruction1Label, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        choicePanel.add(instruction2Label, c);
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 40;
        c.gridx = 0;
        c.gridy = 3;
        choicePanel.add(customizedAlgorithmTextField, c);
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridwidth = 40;
        c.gridx = 1;
        c.gridy = 3;
        choicePanel.add(addAlgorithmButton, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        choicePanel.add(graphCheckBox, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        choicePanel.add(calculateButton, c);
        
        //to the left, 0 and 0 gap
        this.setLayout(new FlowLayout(0, 0, 0));
        add(algorithmsPanel, "center");
        add(parametersPanel, "right");      //right is not useful?
        add(choicePanel, "center");
    
    }
   
    public void initialComponent(){
        addAlgorithmButton.setActionCommand("ADD");
        calculateButton.setActionCommand("CALCULATE");
        
        addAlgorithmButton.addActionListener((ActionListener) this);
        calculateButton.addActionListener((ActionListener) this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ADD")){
            option.setRight(OptionRight.PUT);
            new MainFrame("RESULT", option);   
             
            
        }
        else if(e.getActionCommand().equals("CALCULATE")){
            if(sTextField.getText() == null || kTextField.getText() == null || 
                    tTextField.getText() == null || rTextField.getText() == null 
                    || oTextField.getText() == null){
                System.out.println("parameter error");
            }
            
            else{
                double stf = Double.parseDouble(sTextField.getText());
                double ktf = Double.parseDouble(kTextField.getText());
                double ttf = Double.parseDouble(tTextField.getText());
                double rtf = Double.valueOf(rTextField.getText());
                double otf = Double.valueOf(oTextField.getText()).doubleValue();
                
                option.setsNought(stf);
                option.setStrikeP(ktf);
                option.setTerm(ttf);
                option.setRiskFreeRate(rtf);
                option.setVolatility(otf);
                
                if(bsCheckBox.isSelected() || btCheckBox.isSelected() ||
                        niCheckBox.isSelected() || sCheckBox.isSelected()){ 
                }
                    
                mainframe.dispose();
            }
        }
          
        
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JFrame mainframe;
    private Option option;
    private String bsf = "B-S Formula";
    private String bt = "Binomial Tree";
    private String ni = "Numerical Integration";
    private String si = "model.SimulationModel";
    
    private javax.swing.JPanel algorithmsPanel;
    private javax.swing.JPanel parametersPanel;  //parameters
    private javax.swing.JPanel choicePanel;     //add, graph and calculate
    
//    private javax.swing.JButton backButton;
    private javax.swing.JTextField customizedAlgorithmTextField;
    private javax.swing.JButton addAlgorithmButton;
    private javax.swing.JCheckBox graphCheckBox;
    private javax.swing.JButton calculateButton;
    
    private javax.swing.JLabel algoInfoLabel;
    private javax.swing.JCheckBox bsCheckBox;
    private javax.swing.JCheckBox btCheckBox;
    private javax.swing.JCheckBox niCheckBox;
    private javax.swing.JCheckBox sCheckBox;
    
    private javax.swing.JLabel s0Label;
    private javax.swing.JTextField sTextField;
    private javax.swing.JLabel kLabel;
    private javax.swing.JTextField kTextField;
    private javax.swing.JLabel tLabel;
    private javax.swing.JTextField tTextField;
    private javax.swing.JLabel rLabel;
    private javax.swing.JTextField rTextField;
    private javax.swing.JLabel oLabel;
    private javax.swing.JTextField oTextField;
    
    private javax.swing.JLabel cusInfoLabel;
    
    private javax.swing.JLabel paraInfoLabel;
   
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel instruction1Label;
    private javax.swing.JLabel instruction2Label;

//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel optionLabel;
//    private javax.swing.JLabel promptLabel1;
//    private javax.swing.JLabel promptLabel2;
//    private javax.swing.JLabel promptLabel3;
    // End of variables declaration//GEN-END:variables
}
