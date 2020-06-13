/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Avokati;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RinorJahaj
 */
public class AvokatiComboBoxModel extends AbstractListModel<Avokati> implements ComboBoxModel<Avokati> {

    private List<Avokati> data;
    private Avokati selectedItem;

    public AvokatiComboBoxModel(List<Avokati> data) {
        this.data = data;
    }

    public AvokatiComboBoxModel() {
    }

    public void add(List<Avokati> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Avokati getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Avokati) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
