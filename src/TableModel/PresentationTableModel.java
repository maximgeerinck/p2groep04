/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TableModel;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maxim
 */
public class PresentationTableModel extends AbstractTableModel 
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private String[] columnNames = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"
    };
    
    private boolean connectedToDatabase = false;

    public PresentationTableModel(String url, String username, String password, String query) throws SQLException
    {
        connection = DriverManager.getConnection(url, username, password);
        
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        
        connectedToDatabase = true;
        
        setQuery(query);
    }
    
    public Class getColumnClass(int column) throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to the database");
        
        try 
        {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return Object.class;
    }
    
    @Override
    public int getRowCount() 
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to the database");
        
        return numberOfRows;
    }

    @Override
    public String getColumnName(int column) throws IllegalStateException
    {
       return columnNames[column];
    }
    
    @Override
    public int getColumnCount() throws IllegalStateException 
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to the database");
        
        try 
        {
            return metaData.getColumnCount();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)  throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to the database");
        
        try 
        {
            resultSet.absolute(rowIndex + 1);
            return resultSet.getObject(columnIndex + 1);
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return "";
    }

    private void setQuery(String query) throws SQLException, IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to the database");
        
        resultSet = statement.executeQuery(query);
        
        metaData = resultSet.getMetaData();
        
        resultSet.last();
        numberOfRows = resultSet.getRow();
        
        fireTableStructureChanged();
        
    }
    
    public void disconnectFromDatabase()
    {
        if(!connectedToDatabase)
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            finally
            {
                connectedToDatabase = false;
            }
        }
    }
    
}
