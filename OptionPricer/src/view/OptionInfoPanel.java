package view;

import model.OptionRight;
import model.OptionStyle;

import javax.swing.*;

/**
 * This class is used to show the information of which option and what the type
 * of the option for the user.
 * 
 * @author Castiel
 * @since 2015.03.07
 * @version 1.1.0
 */
public class OptionInfoPanel extends JPanel{
    private javax.swing.JLabel optionLabel;
    
    public OptionInfoPanel(){
        this.setBackground(new java.awt.Color(200, 0, 0));
        this.setMaximumSize(new java.awt.Dimension(1000, 50));
        this.setMinimumSize(new java.awt.Dimension(1000, 50));
        this.setPreferredSize(new java.awt.Dimension(1000, 50));
        
        optionLabel = new JLabel();
        optionLabel.setText("Text Option");
        this.add(optionLabel);
    }
    
    public OptionInfoPanel(OptionStyle style, OptionRight right){        
        this.setBackground(new java.awt.Color(200, 0, 0));
        this.setMaximumSize(new java.awt.Dimension(1000, 50));
        this.setMinimumSize(new java.awt.Dimension(1000, 50));
        this.setPreferredSize(new java.awt.Dimension(1000, 50));
        
        optionLabel = new JLabel();
        String info = style + ": " + right;
        optionLabel.setText(info);
        this.add(optionLabel);
    }
}
