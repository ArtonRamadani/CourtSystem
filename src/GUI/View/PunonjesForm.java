/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Departamenti;
import BLL.Punonjes;
import DAL.CourtException;
import DAL.DepartamentiRepository;
import DAL.PunonjesRepository;
import GUI.Model.DepartamentiComboBoxModel;
import GUI.Model.PunonjesTableModel;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RinorJahaj
 */
public class PunonjesForm extends javax.swing.JInternalFrame {

    PunonjesRepository pr = new PunonjesRepository();
    PunonjesTableModel ptm = new PunonjesTableModel();
    DepartamentiRepository dr = new DepartamentiRepository();
    DepartamentiComboBoxModel dcbm = new DepartamentiComboBoxModel();

    public PunonjesForm() {
        initComponents();
        loadTable();
        loadComboBox();
        tabelaSelectedIndexChange();
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Punonjes p = ptm.getPunonjes(selectedIndex);
                    idTxt.setText(p.getPunonjesID() + "");
                    emriTxt.setText(p.getEmri());
                    mbiemriTxt.setText(p.getMbiemri());
                    emailTxt.setText(p.getEmail());
                    kontaktiTxt.setText(p.getKontakti() + "");
                    depCb.setSelectedItem(p.getDeparamentiFK());
                    depCb.repaint();

                }
            }
        });
    }

    public void loadComboBox() {
        try {
            dcbm.add(dr.findAll());
            depCb.setModel(dcbm);

        } catch (CourtException ex) {
            Logger.getLogger(LendaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadTable() {
        try {
            List<Punonjes> lista = pr.findAll();
            ptm.addList(lista);
            table.setModel(ptm);
            ptm.fireTableDataChanged();
        } catch (CourtException ex) {
            Logger.getLogger(PunonjesForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        emriTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        kontaktiTxt = new javax.swing.JTextField();
        depCb = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        kerkoTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        mbiemriTxt = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Punjones ID");

        jLabel2.setText("Emri");

        jLabel3.setText("Email");

        jLabel4.setText("Kontakti");

        jLabel6.setText("Departamenti");

        idTxt.setEditable(false);

        depCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel7.setText("Kerko");

        saveBtn.setBackground(new java.awt.Color(0, 102, 255));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Ruaj");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(229, 48, 48));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Fshij");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(104, 99, 121));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Anulo");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Mbiemri");

        mbiemriTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbiemriTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emriTxt)
                            .addComponent(kontaktiTxt)
                            .addComponent(depCb, 0, 131, Short.MAX_VALUE)
                            .addComponent(emailTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mbiemriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(cancelBtn)
                                .addGap(69, 69, 69)
                                .addComponent(deleteBtn)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(mbiemriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kontaktiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(depCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = table.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Punonjes p = ptm.getPunonjes(row);
                try {
                    pr.delete(p);
                } catch (CourtException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                clear();
                loadTable();
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            int row = table.getSelectedRow();
            if (row == -1) {
                Punonjes p = new Punonjes();
                p.setEmri(emriTxt.getText());
                p.setMbiemri(mbiemriTxt.getText());
                p.setEmail(emailTxt.getText());
                p.setKontakti(Integer.parseInt(kontaktiTxt.getText()));
                p.setDeparamentiFK((Departamenti) depCb.getSelectedItem());

                pr.create(p);

            } else {
                Punonjes p = ptm.getPunonjes(row);
                p.setEmri(emriTxt.getText());
                p.setMbiemri(mbiemriTxt.getText());
                p.setEmail(emailTxt.getText());
                p.setKontakti(Integer.parseInt(kontaktiTxt.getText()));
                p.setDeparamentiFK((Departamenti) depCb.getSelectedItem());

                pr.edit(p);
            }
            clear();
            loadTable();
        } catch (CourtException ex) {
            JOptionPane.showMessageDialog(this, "E dhena ekziston");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void mbiemriTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbiemriTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbiemriTxtActionPerformed
    public void clear() {
        table.clearSelection();
        emriTxt.setText("");
        mbiemriTxt.setText("");
        emailTxt.setText("");
        kontaktiTxt.setText("");
        depCb.setSelectedIndex(-1);
        depCb.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox depCb;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField emriTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kerkoTxt;
    private javax.swing.JTextField kontaktiTxt;
    private javax.swing.JTextField mbiemriTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
