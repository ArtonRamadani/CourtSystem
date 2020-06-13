/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;
import BLL.Departamenti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class DepartamentiTableModel extends AbstractTableModel {
     List<Departamenti> list;
    String[] cols = {"Nr.", "Emri"};

    public DepartamentiTableModel(List<Departamenti> list) {
        this.list = list;
    }

    public DepartamentiTableModel() {
    }

    public void addList(List<Departamenti> list) {
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

    public Departamenti getDepartamenti(int index) {
        return list.get(index);
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Departamenti d= list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getDepartamentiID();
            case 1:
                return d.getEmri();
            default:
                return null;
        }
    }
}
