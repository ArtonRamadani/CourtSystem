/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Punonjes;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ArtonRamadani
 */
public class PunonjesComboBoxModel extends AbstractListModel<Punonjes> implements ComboBoxModel<Punonjes> {
    private List<Punonjes> data;
    private Punonjes selectedItem;

    public PunonjesComboBoxModel(List<Punonjes> data) {
        this.data = data;
    }

    public PunonjesComboBoxModel() {
    }

    public void add(List<Punonjes> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Punonjes getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Punonjes) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
