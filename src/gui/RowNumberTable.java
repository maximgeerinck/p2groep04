package gui;

import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.*;
import javax.swing.table.*;

/**
 * @author Maxim JTable that allows the use of row headers
 * @source: http://tips4java.wordpress.com/2008/11/18/row-number-table/
 */
public class RowNumberTable extends JTable implements ChangeListener, PropertyChangeListener {

	private javax.swing.JTable main;
	private String[] rowHeaders = {
       "10u - 10u30",
       "11u - 11u30",
       "12u - 12u30",
       "13u - 13u30",
       "14u - 14u30"
    };

	/**
	 * 
	 * @param table
	 */
	public RowNumberTable(javax.swing.JTable table) {
            main = table;
            main.addPropertyChangeListener(this);

            setFocusable(false);
            setAutoCreateColumnsFromModel(false);
            setSelectionModel(main.getSelectionModel());

            TableColumn column = new TableColumn();
            column.setHeaderValue(" ");
            addColumn(column);
            column.setCellRenderer(new RowNumberRenderer());

            getColumnModel().getColumn(0).setPreferredWidth(100);
            setPreferredScrollableViewportSize(getPreferredSize());
	}

	@Override
	public void addNotify() {
            super.addNotify();

            Component c = getParent();

                    //  Keep scrolling of the row table in sync with the main table.
            if (c instanceof JViewport) {
                JViewport viewport = (JViewport) c;
                viewport.addChangeListener(this);
            }
	}

	/**
	 * Delegate method to main table
	 */
	@Override
	public int getRowCount() {
            return main.getRowCount();
	}

	/**
	 * 
	 * @param row
	 */
	@Override
	public int getRowHeight(int row) {
            int rowHeight = main.getRowHeight(row);

            if (rowHeight != super.getRowHeight(row)) {
                super.setRowHeight(row, rowHeight);
            }

            return rowHeight;
	}

	/**
	 * No model is being used for this table so just use the row number
	 * as the value of the cell.
	 * @param row
	 * @param column
	 */
	@Override
    public Object getValueAt(int row, int column) {
        return this.rowHeaders[row];
    }

    /*
     *  Don't edit data in the main TableModel by mistake
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /*
     *  Do nothing since the table ignores the model
     */
    @Override
    public void setValueAt(Object value, int row, int column) {
    }
//
//  Implement the ChangeListener
//

    public void stateChanged(ChangeEvent e) {
        //  Keep the scrolling of the row table in sync with main table

        JViewport viewport = (JViewport) e.getSource();
        JScrollPane scrollPane = (JScrollPane) viewport.getParent();
        scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
    }
//
//  Implement the PropertyChangeListener
//

    public void propertyChange(PropertyChangeEvent e) {
        //  Keep the row table in sync with the main table

        if ("selectionModel".equals(e.getPropertyName())) {
            setSelectionModel(main.getSelectionModel());
        }

        if ("rowHeight".equals(e.getPropertyName())) {
            repaint();
        }
    }

    /*
     *  Attempt to mimic the table header renderer
     */
    private static class RowNumberRenderer extends DefaultTableCellRenderer {

        public RowNumberRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();

                if (header != null) {
                    setForeground(header.getForeground());
                    setBackground(header.getBackground());
                    setFont(header.getFont());
                }
            }

            if (isSelected) {
                setFont(getFont().deriveFont(Font.BOLD));
            }

            setText((value == null) ? "" : value.toString());
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));

            return this;
        }
    }
}