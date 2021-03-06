/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.*;
import java.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kris
 */
public class Asistencia extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    Menu m;
    /**
     * Creates new form Asistencia
     */
    public Asistencia() {
        
        initComponents();
        
        
        
    }
    public Asistencia(Menu menu){
        conectar();
        initComponents();
        mostrarTabla();
        this.m=menu;
    }
    public void conectar(){
        String url= "jdbc:mysql://localhost:3306/ttdb";
        String Usuario= "root";
        String Pass= "123456";
        try{
            conex=DriverManager.getConnection(url,Usuario,Pass);
            //JOptionPane.showMessageDialog(null,"conectado" ,"conexion",1);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void mostrarTabla(){
        try{
            stm=conex.createStatement();
            jTable1.removeAll();
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            ResultSet rs = stm.executeQuery("select empleado.nombre, empleo.nom_empleo,asistencia.fecha FROM empleado , empleo , asistencia where empleado.Empleo_cod_empleo=empleo.cod_empleo AND empleado.Rut=asistencia.Rut and asistencia.fecha LIKE '%"+dateFormat1.format(date)+"%'"); 
            //ResultSet rs = stm.executeQuery("select empleado.nombre, empleo.nom_empleo,asistencia.fecha FROM empleado , empleo , asistencia where empleado.Empleo_cod_empleo=empleo.cod_empleo AND empleado.Rut=asistencia.Rut AND asistencia.fecha='"+dateFormat1.format(date)+"' "); 

            DefaultTableModel mod =(DefaultTableModel)jTable1.getModel();
            mod.setRowCount(0);
            
            while(rs.next()){
                Object data[]={rs.getString("nombre"),rs.getString("nom_empleo"),rs.getString("fecha")};
                //Object data[]={rs.getString("rut"),rs.getShort("Empleo_cod_empleo"),rs.getString("nombre"),rs.getString("tipo"),rs.getString("fono"),rs.getString("email"),rs.getString("hora_entrada"),rs.getString("hora_salida")};

                mod.addRow(data);
            }
            //JOptionPane.showMessageDialog(null, "selec"+dateFormat1.format(date),"conexion",3);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cmdIngreso = new javax.swing.JButton();
        cmdVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmdSalida = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setName(""); // NOI18N

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Enzo Silva", "Administrador", "2020-08-01 08:50:00", "Entrada"},
                {"Enzo Silva", "Administrador", "2020-08-01 20:30:00", "Salida"},
                {"Pedro Salinas", "Ayudante", "2020-08-01 08:20:00", "Entrada"}
            },
            new String [] {
                "Nombre", "Empleo", "Movimiento", "Tipo"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setName("jtAsistencia"); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("jtAsistencia");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Rut:");

        jTextField1.setName("txtRut"); // NOI18N

        cmdIngreso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdIngreso.setText("Ingreso");
        cmdIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIngresoActionPerformed(evt);
            }
        });

        cmdVolver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmdVolver.setText("Volver al menú");
        cmdVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione el tipo de  movimiento:");

        cmdSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmdSalida.setText("Salida");
        cmdSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalidaActionPerformed(evt);
            }
        });

        jLabel3.setText("*con - verificador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmdIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(cmdVolver)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIngresoActionPerformed
        String rut1=jTextField1.getText();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
           //String sql="insert into asistencia values(" +rut1+ ",'" +dateFormat.format(date)+"') where (select empleado.rut from empleado join asistencia on empleado.rut=asistencia.rut ) ";
        String sql="insert into asistencia values('" +rut1+ "','" +dateFormat.format(date)+"','" +rut1+ "')";
        try{
            stm=conex.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"ingreso registrado" ,"conexion",1);
            setEnabled(true);
            mostrarTabla();
            jTextField1.setText(null); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Existen posibles errores:\n-El rut: "+rut1+" no existe\n-El cuadro de ingreso está en blanco","conexion",3);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdIngresoActionPerformed

    private void cmdVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVolverActionPerformed
        m.setEnabled(true);
        dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_cmdVolverActionPerformed

    private void cmdSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalidaActionPerformed
        String rut1=jTextField1.getText();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
           //String sql="insert into asistencia values(" +rut1+ ",'" +dateFormat.format(date)+"') where (select empleado.rut from empleado join asistencia on empleado.rut=asistencia.rut ) ";
        String sql="insert into asistencia values('" +rut1+ "','" +dateFormat.format(date)+"','" +rut1+ "') ";
        try{
            stm=conex.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"salida registrada" ,"conexion",1);
            setEnabled(true);
            mostrarTabla();
            jTextField1.setText(null); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Existen posibles errores:\n-El rut: "+rut1+" no existe\n-El cuadro de ingreso está en blanco","conexion",3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSalidaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //
    }//GEN-LAST:event_formWindowClosing
      
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
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdIngreso;
    private javax.swing.JButton cmdSalida;
    private javax.swing.JButton cmdVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
