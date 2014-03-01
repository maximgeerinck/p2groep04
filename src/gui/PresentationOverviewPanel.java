/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import entity.Presentation;
import tableModel.PresentationTableModel;
import util.HibernateUtil;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Maxim
 */
public class PresentationOverviewPanel extends JPanel
{
    private JTable timeTable;
    private PresentationTableModel presentationModel;

    public PresentationOverviewPanel()
    {
        super(new GridLayout(1,0));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createQuery("SELECT p FROM " + Presentation.class.getSimpleName() + " p");
            presentationModel = new PresentationTableModel((List<Presentation>)q.list());
            timeTable = new JTable(presentationModel);
            JScrollPane scrollPane = new JScrollPane(timeTable);
            JTable rowTable = new RowNumberTable(timeTable);
            scrollPane.setRowHeaderView(rowTable);
            scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
            scrollPane.setSize(new Dimension(400, 400));
            scrollPane.setVisible(true); 
            
            add(scrollPane);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
