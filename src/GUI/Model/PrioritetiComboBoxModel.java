/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Prioriteti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RinorJahaj
 */
public class PrioritetiComboBoxModel extends AbstractListModel<Prioriteti> implements ComboBoxModel<Prioriteti> {
    private List<Prioriteti> data;
    private Prioriteti selectedItem;

    public PrioritetiComboBoxModel(List<Prioriteti> data) {
        this.data = data;
    }

    public PrioritetiComboBoxModel() {
    }

    public void add(List<Prioriteti> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Prioriteti getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Prioriteti) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
