/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Furnitori;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class FurnitoriTableModel extends AbstractTableModel {

    List<Furnitori> list;
    String[] cols = {"Nr.", "Emertimi"};

    public FurnitoriTableModel(List<Furnitori> list) {
        this.list = list;
    }

    public FurnitoriTableModel() {
    }

    public void addList(List<Furnitori> list) {
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

    public Furnitori getFurnitori(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Furnitori f = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getFurnitoriID();
            case 1:
                return f.getEmri();
            default:
                return null;
        }
    }
}
