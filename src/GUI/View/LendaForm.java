/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Avokati;
import BLL.Klienti;
import BLL.Lenda;
import BLL.LlojiPageses;
import DAL.AvokatiRepository;
import DAL.CourtException;
import DAL.KlientiRepository;
import DAL.LendaRepository;
import DAL.LlojiPagesesRepository;
import GUI.Model.AvokatiComboBoxModel;
import GUI.Model.KlientiComboBoxModel;
import GUI.Model.LendaTableModel;
import GUI.Model.LlojiPagesesComboBoxModel;
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
public class LendaForm extends javax.swing.JInternalFrame {

    LendaRepository lr = new LendaRepository();
    LendaTableModel ltm = new LendaTableModel();
    AvokatiRepository ar = new AvokatiRepository();
    AvokatiComboBoxModel acbm = new AvokatiComboBoxModel();
    KlientiRepository kr = new KlientiRepository();
    KlientiComboBoxModel kcbm = new KlientiComboBoxModel();
    LlojiPagesesRepository lpr = new LlojiPagesesRepository();
    LlojiPagesesComboBoxModel c = new LlojiPagesesComboBoxModel();

    public LendaForm() {
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
                    Lenda l = ltm.getLenda(selectedIndex);
                    idTxt.setText(l.getLendaID() + "");
                    emriTxt.setText(l.getEmri());
                    avokatiCb.setSelectedItem(l.getAvokatiFK());
                    avokatiCb.repaint();
                    klientiCb.setSelectedItem(l.getKlientiFK());
                    klientiCb.repaint();
                    llojiPagesesCb.setSelectedItem(l.getLlojiPageses());
                    llojiPagesesCb.repaint();
                    jDateChooser1.setDate(l.getData());
                    detajetTxt.setText(l.getDetajet());

                }
            }
        });
    }

    public void loadComboBox() {
        try {

            acbm.add(ar.findAll());
            kcbm.add(kr.findAll());
            c.add(lpr.findAll());
            avokatiCb.setModel(acbm);
            avokatiCb.repaint();
            klientiCb.setModel(kcbm);
            klientiCb.repaint();
            llojiPagesesCb.setModel(c);
            llojiPagesesCb.repaint();
        } catch (CourtException ex) {
            Logger.getLogger(LendaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadTable() {
        try {
            List<Lenda> lista = lr.findAll();
            ltm.addList(lista);
            table.setModel(ltm);
            ltm.fireTableDataChanged();
        } catch (CourtException ex) {
            Logger.getLogger(AvokatiForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detajetTxt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        avokatiCb = new javax.swing.JComboBox();
        klientiCb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        kerkoTxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        emriTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        llojiPagesesCb = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Lenda ID:");

        idTxt.setEditable(false);

        jLabel3.setText("Lloji Pageses:");

        detajetTxt.setColumns(20);
        detajetTxt.setRows(5);
        jScrollPane1.setViewportView(detajetTxt);

        jLabel4.setText("Avokati:");

        jLabel5.setText("Klienti:");

        avokatiCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        klientiCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Data");

        jLabel8.setText("Kerko");

        kerkoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kerkoTxtActionPerformed(evt);
            }
        });
        kerkoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kerkoTxtKeyTyped(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table);

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

        jLabel10.setText("Emertimi:");

        jLabel9.setText("Detajet:");

        llojiPagesesCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveBtn)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(cancelBtn)
                                .addGap(64, 64, 64)
                                .addComponent(deleteBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(llojiPagesesCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(klientiCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avokatiCb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emriTxt, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(avokatiCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(klientiCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(llojiPagesesCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn)
                    .addComponent(saveBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kerkoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kerkoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kerkoTxtActionPerformed

    private void kerkoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kerkoTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_kerkoTxtKeyTyped

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = table.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Lenda l = ltm.getLenda(row);
                try {
                    lr.delete(l);
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
                Lenda l = new Lenda();
                l.setEmri(emriTxt.getText());
                l.setAvokatiFK((Avokati) avokatiCb.getSelectedItem());
                l.setKlientiFK((Klienti) klientiCb.getSelectedItem());
                l.setLlojiPageses((LlojiPageses) llojiPagesesCb.getSelectedItem());
                l.setData(jDateChooser1.getDate());
                l.setDetajet(detajetTxt.getText());

                lr.create(l);

            } else {
                Lenda l = ltm.getLenda(row);
                l.setEmri(emriTxt.getText());
                l.setAvokatiFK((Avokati) avokatiCb.getSelectedItem());
                l.setKlientiFK((Klienti) klientiCb.getSelectedItem());
                l.setLlojiPageses((LlojiPageses) llojiPagesesCb.getSelectedItem());
                l.setData(jDateChooser1.getDate());
                l.setDetajet(detajetTxt.getText());

                lr.edit(l);
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
    public void clear() {
        table.clearSelection();
        idTxt.setText("");
        emriTxt.setText("");
        detajetTxt.setText("");
        avokatiCb.setSelectedIndex(-1);
        avokatiCb.repaint();
        klientiCb.setSelectedIndex(-1);
        klientiCb.repaint();
        llojiPagesesCb.setSelectedIndex(-1);
        llojiPagesesCb.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox avokatiCb;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea detajetTxt;
    private javax.swing.JTextField emriTxt;
    private javax.swing.JTextField idTxt;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField kerkoTxt;
    private javax.swing.JComboBox klientiCb;
    private javax.swing.JComboBox llojiPagesesCb;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
