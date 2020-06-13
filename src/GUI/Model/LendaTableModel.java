/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Lenda;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ArtonRamadani
 */
public class LendaTableModel extends AbstractTableModel {
      List<Lenda> list;
    String[] cols = {"Nr.", "Emri", "Detajet", "Avokati", "Data", "KlientiID", "Lloji Pageses"};

    public LendaTableModel(List<Lenda> list) {
        this.list = list;
    }

    public LendaTableModel() {
    }

    public void addList(List<Lenda> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    public void remove(int row) {
        list.remove(row);
    }

    public Lenda getLenda(int index) {
        return list.get(index);
    }
    
   public String getDateToString(Date d){
       DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
       return da.format(d);
   }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lenda l= list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return l.getLendaID();
            case 1:
                return l.getEmri();
            case 2:
                return l.getDetajet();
            case 3:
                return l.getAvokatiFK();
            case 4:
                return getDateToString(l.getData());
            case 5:
                return l.getKlientiFK();
            case 6:
                return l.getLlojiPageses();
            default:
                return null;
        }
    }
}
