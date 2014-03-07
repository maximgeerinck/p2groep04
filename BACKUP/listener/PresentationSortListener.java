package listener;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * @author Maxim
 */
public class PresentationSortListener implements ActionListener {

    /**
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() instanceof JComboBox)
        {
            JComboBox cb = (JComboBox)e.getSource();
            String option = (String)cb.getSelectedItem();

            JOptionPane.showMessageDialog(null, option);
        } 
        else if(e.getSource() instanceof JButton)
        {
            JButton btnSRC = (JButton)e.getSource();
            
        }
        
    }

}