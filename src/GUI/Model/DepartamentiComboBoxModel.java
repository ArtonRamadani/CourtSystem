/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Departamenti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RinorJahaj
 */
public class DepartamentiComboBoxModel extends AbstractListModel<Departamenti> implements ComboBoxModel<Departamenti> {

    private List<Departamenti> data;
    private Departamenti selectedItem;

    public DepartamentiComboBoxModel(List<Departamenti> data) {
        this.data = data;
    }

    public DepartamentiComboBoxModel() {
    }

    public void add(List<Departamenti> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Departamenti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Departamenti) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
