package com.gui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaime Hidalgo García
 */
    public class TableModel extends DefaultTableModel {
        
        private static int maxResults = 20;
        private boolean[][] editable_cells;    
        
    public TableModel(Object[] columnNames, int emptyRows){
        super(columnNames, emptyRows);
        this.editable_cells = new boolean[maxResults][maxResults];
        
    }
    
    public void reset_editables(){
        for( int i = 0; i < editable_cells.length ; i++)
            for( int j =0 ; j < editable_cells[i].length ; j++)
                editable_cells[i][j] = true;
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if(editable_cells[row][col]==false) return false;
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
    
    public void setCellEditable(int row, int col, boolean value) {
        this.editable_cells[row][col] = value; // set cell true/false
        this.fireTableCellUpdated(row, col);
    }
    
    
}

