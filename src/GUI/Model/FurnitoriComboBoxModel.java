/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Furnitori;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ArtonRamadani
 */
public class FurnitoriComboBoxModel extends AbstractListModel<Furnitori> implements ComboBoxModel<Furnitori> {

    private List<Furnitori> data;
    private Furnitori selectedItem;

    public FurnitoriComboBoxModel(List<Furnitori> data) {
        this.data = data;
    }

    public FurnitoriComboBoxModel() {
    }

    public void add(List<Furnitori> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Furnitori getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Furnitori) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
