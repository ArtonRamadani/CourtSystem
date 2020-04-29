/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.LlojiPageses;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class LlojiPagesesTableModel extends AbstractTableModel {
     List<LlojiPageses> list;
    String[] cols = {"Nr.", "Emri"};

    public LlojiPagesesTableModel(List<LlojiPageses> list) {
        this.list = list;
    }

    public LlojiPagesesTableModel() {
    }

    public void addList(List<LlojiPageses> list) {
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

    public LlojiPageses getLlojiPageses(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LlojiPageses lp = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return lp.getQmimiID();
            case 1:
                return lp.getEmri();
            default:
                return null;
        }
    }
}
