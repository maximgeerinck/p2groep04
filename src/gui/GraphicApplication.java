/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import TableModel.PresentationTableModel;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maxim
 */
public class GraphicApplication 
{
    
    static final String DATABASE_URL = "jdbc:mysql://localhost/project2";
    static final String USERNAME = "root";
    static final String PASSWORD = "PASSWORD";
    static final String DEFAULT_QUERY = "SELECT * FROM presentations";
    
    private JFrame mainFrame;
    private JTable timeTable;
    private PresentationTableModel presentationModel;
    
    public GraphicApplication() 
    {
        try
        {
            mainFrame = new JFrame();
            mainFrame.setSize(new Dimension(500, 500));
            mainFrame.setVisible(true);

            //Table
            presentationModel = new PresentationTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            timeTable = new JTable(presentationModel);
            JScrollPane scrollPane = new JScrollPane(timeTable);
            JTable rowTable = new RowNumberTable(timeTable);
            scrollPane.setRowHeaderView(rowTable);
            scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
            
        
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    
}