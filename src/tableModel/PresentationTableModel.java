/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tableModel;

import entity.Presentation;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maxim
 */
public class PresentationTableModel extends AbstractTableModel 
{
    private List<Presentation> dataset;
    private final String[] columnNames = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"
    };
    
    public PresentationTableModel(List<Presentation> dataset) throws SQLException
    {
        setDataset(dataset);
    }

    @Override
    public int getRowCount() 
    {
        return dataset.size();
    }

    @Override
    public String getColumnName(int column) throws IllegalStateException
    {
       return columnNames[column];
    }
    
    @Override
    public int getColumnCount() throws IllegalStateException 
    {
        return dataset.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)  throws IllegalStateException
    {
        return ((Presentation)dataset.get(rowIndex)).getId();
    }

    private void setDataset(List<Presentation> dataset) 
    {
        this.dataset = dataset;
        fireTableStructureChanged();
    }
}
