/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import listener.PresentationSortListener;

/**
 *
 * @author Maxim
 */
public class CalendarSortPanel extends JPanel
{
    public CalendarSortPanel()
    {
        super();
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Filters"));
        addControls();
    }
    
    public void addControls()
    {
        ActionListener presentationListener = new PresentationSortListener();
        
        // picklist promotoren
        JComboBox cbPromotoren = new JComboBox(new String[]{"Bram1", "Bram2"});
        cbPromotoren.addActionListener(presentationListener);
                
        // picklist domein
        JComboBox cbDomein = new JComboBox(new String[]{"it1", "it2"});
        cbDomein.addActionListener(presentationListener);
        // picklist co-promotor
        JComboBox cbCoPromotoren = new JComboBox(new String[]{"Roy1", "Roy2"});      
        cbCoPromotoren.addActionListener(presentationListener);
        
        // picklist beschikbaarheid
        JComboBox cbBeschikbaarheid = new JComboBox(new String[]{"ja", "nee"});
        cbBeschikbaarheid.addActionListener(presentationListener);
        
        add(cbPromotoren);
        add(cbDomein);
        add(cbCoPromotoren);
        add(cbBeschikbaarheid);
    }    
}
