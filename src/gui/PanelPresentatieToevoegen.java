/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Maxim
 */
public class PanelPresentatieToevoegen extends JPanel implements ActionListener
{
    Map<String, JComponent> components;
    
    public PanelPresentatieToevoegen()
    {
        super();
        components = new HashMap<>();
        setBorder(BorderFactory.createTitledBorder("Toevoegen"));        
        setLayout(new GridLayout(8, 2));
        
        initForm();
    }
    
    /**
     * lokaal
     * aanwezigen
     * presentator (user)
     * onderwerp
     * Tijdstip
     * Campus
     */
    public void initForm()
    {                              
        components.put("lblFilterLokalen", new JLabel("Lokaal"));
        components.put("txtFilterLokalen", new JTextField());
        components.put("lblPromotor", new JLabel("Promotor"));
        components.put("txtPromotor", new JTextField());
        components.put("lblCoPromotor", new JLabel("Co-promotor"));
        components.put("txtCoPromotor", new JTextField());
        components.put("lblPresentator", new JLabel("Presentator"));
        components.put("txtPresentator", new JTextField());
        components.put("lblOnderwerp", new JLabel("Onderwerp"));
        components.put("txtOnderwerp", new JTextField());
        components.put("lblTijdstip", new JLabel("Tijdstip"));
        components.put("txtTijdstip", new JTextField());
        components.put("lblCampus", new JLabel("Campus"));
        components.put("cbCampus", new JComboBox(new String[]{"Aalst", "Gent"}));
        
        JButton btnSubmit = new JButton("Voeg toe");
        btnSubmit.addActionListener(this);
        components.put("btnSubmit", new JButton());
        
        
        for(Entry e : components.entrySet()) 
        {            
            add((JComponent)e.getValue());            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals(components.get("btnSubmit"))) 
        {
            JOptionPane.showMessageDialog(null, "voeg form toe");
            
        }
    }
}
