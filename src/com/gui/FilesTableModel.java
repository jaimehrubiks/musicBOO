package com.gui;

import com.gui.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaime Hidalgo García
 */
    public class FilesTableModel extends DefaultTableModel {
        
    public FilesTableModel(Object[] columnNames, int emptyRows){
        super(columnNames, emptyRows);
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if( col == 5 || col == 6 ) return true;
        else return false;
        
        //return true;
    }
    
    @Override
    public Class getColumnClass(int c) {
        if ( getValueAt(0, c) == null ) return Object.class;
        else
        return getValueAt(0, c).getClass();
        //else super.get
    }
    
    
}

