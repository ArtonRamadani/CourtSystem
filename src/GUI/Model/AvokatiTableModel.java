/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Avokati;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ArtonRamadani
 */
public class AvokatiTableModel extends AbstractTableModel {

    List<Avokati> list;
    String[] cols = {"Nr.", "Emri","Mbiemri", "Email", "Data e Lindjes", "Kontakti", "Profili"};

    public AvokatiTableModel(List<Avokati> list) {
        this.list = list;
    }

    public AvokatiTableModel() {
    }

    public void addList(List<Avokati> list) {
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

    public Avokati getAvokati(int index) {
        return list.get(index);
    }
    
    public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avokati a= list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getAvokatiID();
            case 1:
                return a.getEmri();
            case 2:
                return a.getMbiemri();
            case 3:
                return a.getEmail();
            case 4:
                return getDateToString(a.getDataLindjes());
            case 5:
                return a.getKontakti();
            case 6:
                return a.getProfili();
            default:
                return null;
        }
    }
}
