

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rookk
 */
public final class Tareas extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    Menu m;
    /**
     * Creates new form Tareas
     */
    public Tareas(){
        initComponents();
    }
    public Tareas(Menu menu) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.m= menu;
        jtTareas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jtTareas.getSelectedRow() > -1) {
                    txtDetalle.setText(jtTareas.getValueAt(jtTareas.getSelectedRow(), 1).toString());
                }
            }
        });
        conectar();
        mostrarTabla();
        
    }
    public void mostrarTabla(){
        try{
            stm=conex.createStatement();
            jtTareas.removeAll();
            ResultSet rs = stm.executeQuery("select * from tarea");
            
            DefaultTableModel mod =(DefaultTableModel)jtTareas.getModel();
            mod.setRowCount(0);
            while(rs.next()){
                Object data[]={rs.getString("cod_tarea"),rs.getString("detalle")};
                mod.addRow(data);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
    }
    
    
    public final void conectar(){
        String url= "jdbc:mysql://localhost:3306/ttdb";
        String Usuario= "root";
        String Pass= "123456";
        try{
            conex=DriverManager.getConnection(url,Usuario,Pass);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTareas = new javax.swing.JTable();
        lblDetalle = new javax.swing.JLabel();
        cmdAñadir = new javax.swing.JButton();
        cmdModificar = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        cmdVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Tarea", "Detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTareas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtTareas);
        if (jtTareas.getColumnModel().getColumnCount() > 0) {
            jtTareas.getColumnModel().getColumn(0).setResizable(false);
            jtTareas.getColumnModel().getColumn(1).setResizable(false);
        }

        lblDetalle.setText("Detalle:");

        cmdAñadir.setText("Añadir");
        cmdAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadirActionPerformed(evt);
            }
        });

        cmdModificar.setText("Modificar");
        cmdModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificarActionPerformed(evt);
            }
        });

        cmdEliminar.setText("Eliminar");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        cmdVolver.setText("Volver");
        cmdVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVolverActionPerformed(evt);
            }
        });

        txtDetalle.setColumns(1);
        txtDetalle.setRows(3);
        txtDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDetalleKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDetalle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(cmdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadirActionPerformed

        String d = txtDetalle.getText();
        jtTareas.clearSelection();
        String sql = "insert into tarea(detalle) values('"+d+"')";
        switch(JOptionPane.showConfirmDialog(null, "Seguro desea AÑADIR esta tarea?","confirmacion",2)){
            case 0:
                try{
                    stm=conex.createStatement();
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Añadido Correctamente","conexion",3);
                    mostrarTabla();
                    txtDetalle.setText("");
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex,"conexion",3);
                }
            default:
                break;
            
        }
            
    }//GEN-LAST:event_cmdAñadirActionPerformed

    private void cmdModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificarActionPerformed
        int index = jtTareas.getSelectedRow();
        if (index<0){
            JOptionPane.showMessageDialog(null, "Seleccione una tarea","conexion",3);
        }else{
            switch (JOptionPane.showConfirmDialog(null, "Seguro desea MODIFICAR esta tarea?","confirmacion",2)){
                case 0:
                    DefaultTableModel mod =(DefaultTableModel)jtTareas.getModel();
                    String cod = mod.getValueAt(index, 0).toString();
                    String det = txtDetalle.getText();
                    String sql= "update tarea set detalle='"+det+"' where cod_tarea="+cod;

                    try{
                        stm=conex.createStatement();
                        stm.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Modificado Correctamente","conexion",3);
                        mostrarTabla();
                        jtTareas.clearSelection();
                        txtDetalle.setText("");

                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex,"conexion",3);
                    }
                default:
                    break;
            }
            
        }
    }//GEN-LAST:event_cmdModificarActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        int index = jtTareas.getSelectedRow();
        if (index<0){
            JOptionPane.showMessageDialog(null, "Seleccione una tarea","conexion",3);
        }else{
            switch (JOptionPane.showConfirmDialog(null, "Seguro desea ELIMINAR esta tarea?","confirmacion",2)){
                case 0:
                    DefaultTableModel mod =(DefaultTableModel)jtTareas.getModel();
                    String cod = mod.getValueAt(index, 0).toString();
                    String sql= "delete from tarea where cod_tarea="+cod;

                    try{
                        stm=conex.createStatement();
                        stm.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Eliminado Correctamente","conexion",3);
                        jtTareas.clearSelection();
                        txtDetalle.setText("");
                        mostrarTabla();
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, ex,"conexion",3);
                    }
                default:
                    break;
            }
            
        }
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVolverActionPerformed
        m.setEnabled(true);
        m.llenaCombos();
        dispose();
    }//GEN-LAST:event_cmdVolverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        m.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void txtDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleKeyTyped
        char C = evt.getKeyChar();
        if (!(Character.isAlphabetic(C)||Character.isSpaceChar(C))){
            evt.consume();
        }
    }//GEN-LAST:event_txtDetalleKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAñadir;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdModificar;
    private javax.swing.JButton cmdVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTareas;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}
