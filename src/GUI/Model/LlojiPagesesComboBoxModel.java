/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.LlojiPageses;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RinorJahaj
 */
public class LlojiPagesesComboBoxModel extends AbstractListModel<LlojiPageses> implements ComboBoxModel<LlojiPageses> {

    private List<LlojiPageses> data;
    private LlojiPageses selectedItem;

    public LlojiPagesesComboBoxModel(List<LlojiPageses> data) {
        this.data = data;
    }

    public LlojiPagesesComboBoxModel() {
    }

    public void add(List<LlojiPageses> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public LlojiPageses getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (LlojiPageses) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
