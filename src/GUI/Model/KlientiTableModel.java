/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RinorJahaj
 */
public class KlientiTableModel extends AbstractTableModel {

    List<Klienti> list;
    String[] cols = {"Nr.", "Emri", "Mbiemri", "Email", "Kontakti", "Adresa"};

    public KlientiTableModel(List<Klienti> list) {
        this.list = list;
    }

    public KlientiTableModel() {
    }

    public void addList(List<Klienti> list) {
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

    public Klienti getKlienti(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKlientiID();
            case 1:
                return k.getEmri();
            case 2:
                return k.getMbiemri();
            case 3:
                return k.getEmail();
            case 4:
                return k.getKontakti();
            case 5:
                return k.getAdresa();
            default:
                return null;
        }
    }
}
