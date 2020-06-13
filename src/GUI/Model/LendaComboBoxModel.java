/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Lenda;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RinorJahaj
 */
public class LendaComboBoxModel extends AbstractListModel<Lenda> implements ComboBoxModel<Lenda> {
     private List<Lenda> data;
    private Lenda selectedItem;

    public LendaComboBoxModel(List<Lenda> data) {
        this.data = data;
    }

    public LendaComboBoxModel() {
    }

    public void add(List<Lenda> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Lenda getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Lenda) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
