/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valer
 */
public class DatosMatriz extends javax.swing.JFrame {

int 
            maximos[][],
            disponibles[][],
            comprobar[][],
            ordenes,
            rutas;
            DefaultTableModel Max;
            DefaultTableModel Dis;
            boolean err = false , cont = true;

    public DatosMatriz(int rutas, int ordenes) {
        initComponents();
        this.Dis = (DefaultTableModel) this.DIS.getModel();
        this.Max = (DefaultTableModel) this.MAX.getModel();
        this.ordenes = ordenes;
        this.rutas = rutas;
        maximos = new int[this.ordenes][this.rutas];
        disponibles = new int[1][this.rutas];
        comprobar = new int[1][this.rutas];
        Object[] array = new Object[this.ordenes];
    
        //crea filas y columnas en las tablas para insertar los valores del array
        for (int i = 0; i < this.ordenes ; i++) {
            this.Max.addRow(array);
        }
        this.Dis.addRow(array);
        
        for (int j = 0; j < this.rutas ; j++) {
            this.Max.addColumn("Rutas " + (j));
            this.Dis.addColumn("Rutas " + (j));
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MAX = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        DIS = new javax.swing.JTable();
        Continuar = new javax.swing.JButton();

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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matriz Maximos");

        jLabel2.setText("Matriz Disponibles");

        MAX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(MAX);

        DIS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(DIS);

        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Continuar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(Continuar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
 
        //llenado de array disponible
         for (int j = 0; j < this.rutas ; j++) {
            Object a = this.Dis.getValueAt(0,j);
            String s = String.valueOf(a);
            int d = 0;
            try{
                d =  Integer.parseInt(s);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Dato invalido");
                this.err = true;
                this.cont = false;
            }
            
            if (!this.err) {
                if (d <= 0) {
                    this.cont = false;
                    JOptionPane.showMessageDialog(null, "Inserte numero positivo");
                } else {
                    this.disponibles[0][j] = d;
                }
            }
        }  
        
        //llenado de array maximo comprobando que sus valores no puedan ser mayores a los disponibles
        for (int i = 0; i < ordenes; i++) {
                for (int j = 0; j < rutas; j++) {
                    Object n = this.Max.getValueAt(i, j); 
                    String m = String.valueOf(n);
                    int h = 0;
                    
            try{
                h =  Integer.parseInt(m);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Dato invalido");
                this.err = true;
                this.cont = false;
            }
            
            if (!this.err) {
                if (h < 0  || h > this.disponibles[0][j]) {
                    this.cont = false;
                    JOptionPane.showMessageDialog(null, "Introduzca un numero mayor a 0 y menor o igua a disponibles");
                } else {
                    this.maximos[i][j] = h;  
                }
            }
                }
            }
         
         
       if(this.cont){
            Resultado res = new Resultado();
            SOP2 p1 = new SOP2(this.rutas,this.ordenes,this.disponibles,this.maximos, res);
            p1.MatricesFalt();
        }  
         
         
    }//GEN-LAST:event_ContinuarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JTable DIS;
    private javax.swing.JTable MAX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
