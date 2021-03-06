
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rookk
 */
public class Item extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    int modo=0;
    String itemcod;
    /**
     * Creates new form Item
     */
    public Item() {
        initComponents();
    }
    private Menu m;
    public Item(Menu m){
        conectar();
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.m = m;
        
        modo=1;
    }
    public Item(Menu m,String cod, String nom, String creal,String ccrit, String est){
        conectar();
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        itemcod= cod;
        this.txtNombre.setText(nom);
        this.txtCantidadC.setText(ccrit);
        this.txtCantidadR.setText(creal);
        
        if (est.equals("Disponible")){
            this.rbtNo.setSelected(true);
        }else{this.rbtSi.setSelected(true);}
        
        this.m = m;

        modo=2;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCreal = new javax.swing.JLabel();
        lblCcritica = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCantidadR = new javax.swing.JTextField();
        txtCantidadC = new javax.swing.JTextField();
        cmdCancelar = new javax.swing.JButton();
        cmdEnviar = new javax.swing.JButton();
        lblPr = new javax.swing.JLabel();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblNombre.setText("Nombre: ");

        lblCreal.setText("Cantidad Real: ");

        lblCcritica.setText("Cantidad Critica: ");

        lblEstado.setText("Estado: ");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCantidadR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadRKeyTyped(evt);
            }
        });

        txtCantidadC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadCKeyTyped(evt);
            }
        });

        cmdCancelar.setText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        cmdEnviar.setText("Enviar");
        cmdEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarActionPerformed(evt);
            }
        });

        lblPr.setText("Prestado");

        buttonGroup1.add(rbtSi);
        rbtSi.setText("Si");

        buttonGroup1.add(rbtNo);
        rbtNo.setText("No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addComponent(cmdEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblCreal)
                            .addComponent(lblCcritica))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtCantidadR)
                            .addComponent(txtCantidadC)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(18, 18, 18)
                        .addComponent(lblPr)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSi)
                        .addGap(18, 18, 18)
                        .addComponent(rbtNo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreal)
                    .addComponent(txtCantidadR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCcritica)
                    .addComponent(txtCantidadC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblPr)
                    .addComponent(rbtSi)
                    .addComponent(rbtNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        m.setEnabled(true);
        dispose();
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        m.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void cmdEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarActionPerformed

        String nom = txtNombre.getText();
        String ccrit = txtCantidadC.getText();
        String creal = txtCantidadR.getText();
        byte est;
        if (rbtSi.isSelected()){
            est=1;
        }else{est=0;}
        
        String sql;
        String al;
        
        if (modo==1){
            sql= "insert into item(nombre, cantidad_real, cantidad_critica, estado) values('" +nom+ "'," +creal+ "," + ccrit+ ",'" +est+ "')";
            al= "Añadido Correctamente";
        }else{
            sql= "update item set nombre='" +nom+ "', cantidad_real=" +creal+ ", cantidad_critica=" +ccrit+ ", estado=" +est+" where item.cod_item=" +itemcod;
                al= "Modificado Correctamente";
        }
        try{
            stm=conex.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, al,"conexion",3);
            m.setEnabled(true);
            m.mostrarTablaInv();
            dispose();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex,"conexion",3);
        }
    }//GEN-LAST:event_cmdEnviarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char C = evt.getKeyChar();
        if (!(Character.isAlphabetic(C)||Character.isSpaceChar(C))){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCantidadRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadRKeyTyped
        char C = evt.getKeyChar();
        if (!(Character.isDigit(C))){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadRKeyTyped

    private void txtCantidadCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCKeyTyped
        char C = evt.getKeyChar();
        if (!(Character.isDigit(C))){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadCKeyTyped

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
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Item().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCcritica;
    private javax.swing.JLabel lblCreal;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPr;
    private javax.swing.JRadioButton rbtNo;
    private javax.swing.JRadioButton rbtSi;
    private javax.swing.JTextField txtCantidadC;
    private javax.swing.JTextField txtCantidadR;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
