/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Prioriteti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class PrioritetiTableModel extends AbstractTableModel {
     List<Prioriteti> list;
    String[] cols = {"Nr.", "Emri"};

    public PrioritetiTableModel(List<Prioriteti> list) {
        this.list = list;
    }

    public PrioritetiTableModel() {
    }

    public void addList(List<Prioriteti> list) {
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

    public Prioriteti getPrioriteti(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prioriteti p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPrioritetiID();
            case 1:
                return p.getEmertimi();
            default:
                return null;
        }
    }
}
