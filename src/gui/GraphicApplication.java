/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import tableModel.PresentationTableModel;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maxim
 */
public class GraphicApplication 
{
    private JFrame mainFrame;
    private JPanel pnlTest;
    
    public GraphicApplication() 
    {
        
    }
    
    public void initGUI() 
    {
        mainFrame = new JFrame();
        mainFrame.setSize(new Dimension(500, 500));        
        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //PNL
        pnlTest = new PresentationOverviewPanel();
        pnlTest.setOpaque(true);
        mainFrame.setContentPane(pnlTest);
        
        
        //display the window
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}