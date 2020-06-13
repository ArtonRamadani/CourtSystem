/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Detyra;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ArtonRamadani
 */
public class DetyraTableModel extends AbstractTableModel {
     List<Detyra> list;
    String[] cols = {"Nr.", "Lenda", "Punetori", "Emri", "Data", "Prioriteti", "Pershkrimi"};

    public DetyraTableModel(List<Detyra> list) {
        this.list = list;
    }

    public DetyraTableModel() {
    }

    public void addList(List<Detyra> list) {
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

    public Detyra getDetyra(int index) {
        return list.get(index);
    }
    
    public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Detyra d= list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getDetyraID();
            case 1:
                return d.getLendaID();
            case 2:
                return d.getPunetoriID();
            case 3:
                return d.getEmri();
            case 4:
                return getDateToString(d.getData());
            case 5:
                return d.getPrioritetiID();
            case 6:
                return d.getPershkrimi();
            default:
                return null;
        }
    }
}
