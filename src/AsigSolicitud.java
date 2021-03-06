/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kris
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

public class AsigSolicitud extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    
    /**
     * Creates new form AsigSolicitud
     */
    
    public AsigSolicitud() {
        
        initComponents();
       
    }
    private VerSolicitudes vs;
    public AsigSolicitud(VerSolicitudes vs){
        conectar();
        initComponents();
        mostrarTabla();
        llenaCombo();
        this.vs=vs;
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
            ResultSet rs = stm.executeQuery("select cod_soli,nombre,rut_soli,asunto,estado FROM solicitud_prestamo"); 
            
            DefaultTableModel mod =(DefaultTableModel)jTable1.getModel();
            mod.setRowCount(0);
            
            while(rs.next()){
                Object data[]={rs.getString("cod_soli"),rs.getString("nombre"),rs.getString("rut_soli"),rs.getString("asunto"),rs.getString("estado")};
                

                mod.addRow(data);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
        }
        rbtDevuelto.setSelected(true);
    }
    public void llenaCombo(){
    try{    
        cmbItem.removeAllItems();
        stm=conex.createStatement();
        ResultSet lista = stm.executeQuery("select nombre from item");
        
        while (lista.next()){
            cmbItem.addItem(lista.getString(1));
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
    }}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbItem = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        cmdAsignar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbtPrestado = new javax.swing.JRadioButton();
        rbtDevuelto = new javax.swing.JRadioButton();
        cmdVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Juan Perez", "10862755-7", "Bienvenida", "Revisada"},
                {"2", "Carlos Santana", "19974002-4", "Despedida", "Revisada"},
                {"3", "Ivan Salas", "15067621-5", "Celebración", "Pendiente"},
                {"4", "Pedro Colina", "20848655-4", "Certificación", "Pendiente"}
            },
            new String [] {
                "Código", "Nombre", "Rut", "Asunto", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cmbItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenedor", "Item 2", "Item 3", "Item 4" }));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        cmdAsignar.setText("Asignar");
        cmdAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsignarActionPerformed(evt);
            }
        });

        jLabel1.setText("cantidad necesaria del item: ");

        buttonGroup1.add(rbtPrestado);
        rbtPrestado.setText("Prestado");

        buttonGroup1.add(rbtDevuelto);
        rbtDevuelto.setText("Devuelto");

        cmdVolver.setText("Volver");
        cmdVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado de la asignación:");

        jLabel3.setText("Seleccione uno de los items");

        jLabel4.setText("*Si desea cambiar el estado de un item");

        jLabel5.setText("seleccione la solicitud, si no conoce su codigo, véase en detalle");

        jLabel6.setText("y seleccione el item devuelto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(cmdVolver)
                        .addGap(86, 86, 86)
                        .addComponent(cmdAsignar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbtPrestado)
                                        .addComponent(rbtDevuelto))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(rbtPrestado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtDevuelto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAsignar)
                    .addComponent(cmdVolver))
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
    
    private void cmdAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsignarActionPerformed
       String cant =jTextField1.getText();
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       String itemC="";
       String soliC="";
       
       String item1 = cmbItem.getSelectedItem().toString();
        try{
            stm=conex.createStatement();
            ResultSet rs = stm.executeQuery("select cod_item from item where nombre='"+item1+"'");
            rs.next();
            itemC=rs.getString(1);
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
        String estado="";
        
       if (rbtPrestado.isSelected()){
            estado= "P";
        }else{
            estado= "D";
        }
        //short item = Short.parseShort(item1);
        int ind= jTable1.getSelectedRow();
        DefaultTableModel mod =(DefaultTableModel)jTable1.getModel();
        if (ind!=-1) {
            short cantidad = Short.parseShort(cant);
            String codSoli= mod.getValueAt(ind, 0).toString();
            try{
                stm=conex.createStatement();
                ResultSet rs = stm.executeQuery("select cod_soli from solicitud_prestamo where cod_soli='"+codSoli+"'");
                rs.next();
                soliC=rs.getString(1);

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex,"conexion",3);
                }
            String sql="insert into detalle_solicitud_prestamo (Solicitud_Prestamo_cod_soli, Item_cod_item, fecha, estado, cantidad)values ("+soliC+","+itemC+",'"+dateFormat.format(date)+"','"+estado+"',"+cantidad+")ON DUPLICATE KEY UPDATE cantidad = cantidad +"+cantidad+",estado='"+estado+"'";
            try{
                stm=conex.createStatement();
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"asignacion registrada" ,"conexion",1);



                buttonGroup1.clearSelection();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex,"conexion",3);
            }
        
        }else if( cant!=""){
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad, en caso de ser un cero\ningrese un cero","conexion",3);
        }else
        
        {
            JOptionPane.showMessageDialog(null,"Seleccione una solicitud de la tabla","conexion",3);
        }
    }//GEN-LAST:event_cmdAsignarActionPerformed

    private void cmdVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVolverActionPerformed
        vs.setEnabled(true);
        dispose();
    }//GEN-LAST:event_cmdVolverActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
       char car = evt.getKeyChar();
        if((car<'0' || car>'9') ) evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(AsigSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsigSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsigSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsigSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsigSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JButton cmdAsignar;
    private javax.swing.JButton cmdVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rbtDevuelto;
    private javax.swing.JRadioButton rbtPrestado;
    // End of variables declaration//GEN-END:variables
}
