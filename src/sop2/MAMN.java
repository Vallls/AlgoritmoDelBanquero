/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop2;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valer
 */
public class MAMN extends javax.swing.JFrame {

    int ordenes,rutas;
    int[][] asignados;
    int[][] necesario;
    private DefaultTableModel asg;
    private DefaultTableModel nec;
    SOP2 p1;
    Resultado res;
    public MAMN(int ordenes,int rutas,int[][] asignados,int[][] necesario,SOP2 p1,Resultado res) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ordenes = ordenes;
        this.rutas = rutas;
        this.asignados = asignados;
        this.necesario = necesario;
        this.p1 = p1;
        this.res = res;
        asg = (DefaultTableModel) ASG.getModel();
        nec = (DefaultTableModel) NEC.getModel();
        Object[] array = new Object[this.ordenes];
        
        //Crea filas y columnas en las tablas para que se muestren los resultados de los arrays
        for (int i = 0; i < this.rutas; i++) {

            asg.addColumn("Rutas " + i);
            nec.addColumn("Rutas " + i);
        }

       
        for (int j = 0; j < this.ordenes; j++) {
            asg.addRow(array);
            nec.addRow(array);
        }
        
       
        for (int i = 0; i < this.ordenes; i++) {
            for (int j = 0; j < this.rutas; j++) {
                Object x = (Integer) this.necesario[i][j];
                this.ASG.getModel().setValueAt(x, i, j);
            }
        }

      
        for (int i = 0; i < this.ordenes; i++) {
            for (int j = 0; j < this.rutas; j++) {
                Object x = (Integer) this.asignados[i][j];
                this.NEC.getModel().setValueAt(x, i, j);
            }
        }
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ASG = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        NEC = new javax.swing.JTable();
        Continuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matriz Asignados");

        jLabel2.setText("Matriz Necesarios");

        ASG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ASG);

        NEC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(NEC);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(Continuar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Continuar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        this.p1.esSeguro();
        this.res.setVisible(true);
    }//GEN-LAST:event_ContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ASG;
    private javax.swing.JButton Continuar;
    private javax.swing.JTable NEC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
