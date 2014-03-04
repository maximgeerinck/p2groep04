/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxim
 */
public class PresentationSortListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JComboBox cb = (JComboBox)e.getSource();
        String option = (String)cb.getSelectedItem();
        
        JOptionPane.showMessageDialog(null, option);
    }
    
}
