/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pk.java.konrad.view;

import com.pk.java.konrad.model.Dekorator;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Konrad
 */
public class StatSelectView extends View
{

    private final Date[] daty = { new Date(), new Date() };
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Creates new form UzupelnijDziennikJPanel
     */
    public StatSelectView() 
    {
        initComponents();
        
        jLabIncVal1.setVisible(false);
        jLabIncVal2.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanelGorny = new java.awt.Panel();
        jLabNazwaCwiczenia = new javax.swing.JLabel();
        jLabStatystyki = new javax.swing.JLabel();
        jBtnWstecz = new javax.swing.JButton();
        jPanelDolny = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDo = new javax.swing.JTextField();
        jLabDrugi = new javax.swing.JLabel();
        jBtnPokazStatystyki = new javax.swing.JButton();
        jTextFieldOd = new javax.swing.JTextField();
        jLabPierwszy = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabIncVal2 = new javax.swing.JLabel();
        jLabIncVal1 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jPanelGorny.setBackground(new java.awt.Color(153, 204, 255));

        jLabNazwaCwiczenia.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabNazwaCwiczenia.setForeground(new java.awt.Color(255, 255, 255));
        jLabNazwaCwiczenia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNazwaCwiczenia.setText("Bieg");

        jLabStatystyki.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabStatystyki.setForeground(new java.awt.Color(255, 255, 255));
        jLabStatystyki.setText("Statystyki");
        jLabStatystyki.setToolTipText("");

        jBtnWstecz.setText("Wstecz");
        jBtnWstecz.setMargin(new java.awt.Insets(2, 10, 2, 14));

        javax.swing.GroupLayout jPanelGornyLayout = new javax.swing.GroupLayout(jPanelGorny);
        jPanelGorny.setLayout(jPanelGornyLayout);
        jPanelGornyLayout.setHorizontalGroup(
            jPanelGornyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGornyLayout.createSequentialGroup()
                .addComponent(jLabStatystyki)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabNazwaCwiczenia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jBtnWstecz))
        );
        jPanelGornyLayout.setVerticalGroup(
            jPanelGornyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGornyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabNazwaCwiczenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(jPanelGornyLayout.createSequentialGroup()
                .addGroup(jPanelGornyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabStatystyki)
                    .addComponent(jBtnWstecz))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelDolny.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelDolnyLayout = new javax.swing.GroupLayout(jPanelDolny);
        jPanelDolny.setLayout(jPanelDolnyLayout);
        jPanelDolnyLayout.setHorizontalGroup(
            jPanelDolnyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDolnyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDolnyLayout.setVerticalGroup(
            jPanelDolnyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDolnyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextFieldDo.setText("dd-MM-yyyy");

        jLabDrugi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabDrugi.setText(" Do:");

        jBtnPokazStatystyki.setText("Pokaż Statystyki");

        jTextFieldOd.setText("dd-MM-yyyy");

        jLabPierwszy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabPierwszy.setText("Od:");

        jLabel2.setText("(dd-MM-yyyy)");

        jLabIncVal2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabIncVal2.setForeground(new java.awt.Color(255, 0, 51));
        jLabIncVal2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabIncVal2.setText("Błędna data");

        jLabIncVal1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabIncVal1.setForeground(new java.awt.Color(255, 0, 51));
        jLabIncVal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabIncVal1.setText("Błędna data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGorny, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDolny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabPierwszy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabDrugi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jTextFieldOd)
                    .addComponent(jTextFieldDo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabIncVal1)
                    .addComponent(jLabIncVal2)
                    .addComponent(jBtnPokazStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelGorny, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabPierwszy)
                    .addComponent(jLabIncVal1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabDrugi)
                    .addComponent(jLabIncVal2))
                .addGap(18, 18, 18)
                .addComponent(jBtnPokazStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanelDolny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnPokazStatystyki;
    private javax.swing.JButton jBtnWstecz;
    private javax.swing.JLabel jLabDrugi;
    private javax.swing.JLabel jLabIncVal1;
    private javax.swing.JLabel jLabIncVal2;
    private javax.swing.JLabel jLabNazwaCwiczenia;
    private javax.swing.JLabel jLabPierwszy;
    private javax.swing.JLabel jLabStatystyki;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelDolny;
    private java.awt.Panel jPanelGorny;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldDo;
    private javax.swing.JTextField jTextFieldOd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setModel(List<Object> model) {
        if(model.size()>0) jLabIncVal1.setVisible((Boolean)(model.get(0)));
        if(model.size()>1) jLabIncVal2.setVisible((Boolean)(model.get(1)));
        if(model.size()>2) daty[0]=(Date)model.get(2);
        if(model.size()>3) daty[1]=(Date)model.get(3);
        if(model.size()>4) jLabNazwaCwiczenia.setText((String)model.get(4));
        jTextFieldOd.setText(formatter.format(daty[0]));
        jTextFieldDo.setText(formatter.format(daty[1]));
    }

    @Override
    public void dodajActionListener(ActionListener l) {
        jBtnPokazStatystyki.addActionListener(l);
        jBtnWstecz.addActionListener(l);
    }

    @Override
    public ArrayList<Object> getModel() {
        ArrayList<Object> l = new ArrayList<>();
        
        try {
            daty[0]=formatter.parse(jTextFieldOd.getText());
            l.add(daty[0]);
        } catch (ParseException ex) {
            Logger.getLogger(StatSelectView.class.getName()).log(Level.SEVERE, null, ex);
            l.add(null);
        }
        
        try {
            daty[1]=formatter.parse(jTextFieldDo.getText());
            l.add(daty[1]);
        } catch (ParseException ex) {
            Logger.getLogger(StatSelectView.class.getName()).log(Level.SEVERE, null, ex);
            l.add(null);
        }
        
        l.add(jLabNazwaCwiczenia.getText());
        return l;
    }
}
