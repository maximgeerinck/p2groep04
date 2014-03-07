package tableModel;

import javax.swing.table.*;
import java.util.*;
import entity.*;

/**
 * @author Maxim
 */
public class PresentationTableModel extends AbstractTableModel {

	private final String[] columnNames = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday"
    };
	private Collection<Presentation> dataset;

	/**
	 * 
	 * @param dataset
	 */
	public PresentationTableModel(java.util.List<Presentation> dataset) throws java.sql.SQLException {
		// TODO - implement PresentationTableModel.PresentationTableModel
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRowCount() {
		// TODO - implement PresentationTableModel.getRowCount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param column
	 */
	@Override
	public String getColumnName(int column) throws IllegalStateException {
		// TODO - implement PresentationTableModel.getColumnName
		throw new UnsupportedOperationException();
	}

	@Override
	public int getColumnCount() throws IllegalStateException {
		// TODO - implement PresentationTableModel.getColumnCount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) throws IllegalStateException {
		// TODO - implement PresentationTableModel.getValueAt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dataset
	 */
	private void setDataset(java.util.List<Presentation> dataset) {
		// TODO - implement PresentationTableModel.setDataset
		throw new UnsupportedOperationException();
	}

}