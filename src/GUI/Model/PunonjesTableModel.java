/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Punonjes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class PunonjesTableModel extends AbstractTableModel {

    List<Punonjes> list;
    String[] cols = {"Nr.", "Emri", "Mbiemri", "Email", "Kontakti", "Departamenti"};

    public PunonjesTableModel(List<Punonjes> list) {
        this.list = list;
    }

    public PunonjesTableModel() {
    }

    public void addList(List<Punonjes> list) {
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

    public Punonjes getPunonjes(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Punonjes p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPunonjesID();
            case 1:
                return p.getEmri();
            case 2:
                return p.getEmail();
            case 3:
                return p.getKontakti();
            case 4:
                return p.getDeparamentiFK();
            default:
                return null;
        }
    }

}
