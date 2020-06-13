/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Avokati;
import DAL.AvokatiRepository;
import DAL.CourtException;
import GUI.Model.AvokatiTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ArtonRamadani
 */
public class AvokatiForm extends javax.swing.JInternalFrame {

    AvokatiRepository ar = new AvokatiRepository();
    AvokatiTableModel atm = new AvokatiTableModel();

    public AvokatiForm() {
        initComponents();
        loadTable();
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
                    Avokati a = atm.getAvokati(selectedIndex);
                    idTxt.setText(a.getAvokatiID().toString());
                    emriTxt.setText(a.getEmri());
                    mbiemriTxt.setText(a.getMbiemri());
                    emailTxt.setText(a.getEmail());
                    jDateChooser1.setDate(a.getDataLindjes());
                    kontaktiTxt.setText(a.getKontakti().toString());
                    profiliTxt.setText(a.getProfili());

                }
            }
        });
    }

    public void loadTable() {
        try {
            List<Avokati> lista = ar.findAll();
            atm.addList(lista);
            table.setModel(atm);
            atm.fireTableDataChanged();
        } catch (CourtException ex) {
            Logger.getLogger(AvokatiForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        emriTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        kontaktiTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        kerkoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        profiliTxt = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        mbiemriTxt = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("ID");

        jLabel2.setText("Emri");

        jLabel3.setText("Email");

        jLabel4.setText("Data e Lindjes");

        jLabel5.setText("Kontakt");

        idTxt.setEditable(false);

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        saveBtn.setBackground(new java.awt.Color(0, 102, 255));
        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Ruaj");
        saveBtn.setToolTipText("");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(104, 99, 121));
        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Anulo");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(229, 48, 48));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Fshij");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Profili");

        kerkoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kerkoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kerkoTxtKeyTyped(evt);
            }
        });

        jLabel8.setText("Kerko");

        profiliTxt.setColumns(20);
        profiliTxt.setRows(5);
        jScrollPane2.setViewportView(profiliTxt);

        jLabel6.setText("Mbiemri");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(cancelBtn)
                        .addGap(67, 67, 67)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kontaktiTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emriTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mbiemriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(mbiemriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kontaktiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveBtn)
                        .addComponent(cancelBtn)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kerkoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                Avokati a = atm.getAvokati(row);
                try {
                    ar.delete(a);
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
                Avokati a = new Avokati();
                a.setEmri(emriTxt.getText());
                a.setMbiemri(mbiemriTxt.getText());
                a.setEmail(emailTxt.getText());
                a.setDataLindjes(jDateChooser1.getDate());
                a.setKontakti(Integer.parseInt(kontaktiTxt.getText()));
                a.setProfili(profiliTxt.getText());

                ar.create(a);

            } else {
                Avokati a = atm.getAvokati(row);
                a.setEmri(emriTxt.getText());
                a.setMbiemri(mbiemriTxt.getText());
                a.setEmail(emailTxt.getText());
                a.setDataLindjes(jDateChooser1.getDate());
                a.setKontakti(Integer.parseInt(kontaktiTxt.getText()));
                a.setProfili(profiliTxt.getText());

                ar.edit(a);
            }
            clear();
            loadTable();
        } catch (CourtException ex) {
            JOptionPane.showMessageDialog(this, "E dhena ekziston");
        }


    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (!emriTxt.getText().trim().equals("") && !idTxt.getText().trim().equals("")
                && !emailTxt.getText().trim().equals("") && kontaktiTxt.getText().trim().equals("")
                && !profiliTxt.getText().trim().equals("")) {
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni plotesuar asgje per ta anuluar!");
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void kerkoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kerkoTxtKeyTyped

    }//GEN-LAST:event_kerkoTxtKeyTyped

    private void mbiemriTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbiemriTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbiemriTxtActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        TableColumnModel tcm = table.getColumnModel();
        TableModel modeli = table.getModel();
        int total = tcm.getColumnCount();
        for (int i = 0; i < total; i++) {
            int t = 0;
            int total2 = modeli.getRowCount();
            for (int j = 0; j < total2; j++) {
                if (modeli.getValueAt(j, i) != null) {
                    int t1 = modeli.getValueAt(j, i).toString().length() * 7;
                    if (t1 > t) {
                        t = t1;
                    }
                }
                tcm.getColumn(i).setPreferredWidth(t);
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void kerkoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kerkoTxtKeyReleased
//        AvokatiTableModel tabela = (AvokatiTableModel)table.getModel();
//        String search = emriTxt.getText().toLowerCase();
//        TableRowSorter<AvkatiTableModel> ta = TableRowSorter<AvokatiTableModel>(tabela);
//        table.setRowSorter(ta);
//        ta.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_kerkoTxtKeyReleased

    public void clear() {
        table.clearSelection();
        idTxt.setText("");
        emriTxt.setText("");
        mbiemriTxt.setText("");
        emailTxt.setText("");
        kontaktiTxt.setText("");
        profiliTxt.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField emriTxt;
    private javax.swing.JTextField idTxt;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kerkoTxt;
    private javax.swing.JTextField kontaktiTxt;
    private javax.swing.JTextField mbiemriTxt;
    private javax.swing.JTextArea profiliTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
