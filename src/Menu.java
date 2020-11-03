/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.CardLayout;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;
import java.sql.Time;
/**
 *
 * @author Rookk
 */
public class Menu extends javax.swing.JFrame {
    Connection conex=null;
    Statement stm=null;
    CardLayout c1= null;

    /**
     * Creates new form Menu
     */
    public Menu(){
        conectar();
        initComponents();
        c1= (CardLayout)(panelCont.getLayout());
        c1.show(panelCont,"1");
        clock();
      
    }
    private void clock(){
        Thread clock= new Thread(){
            public void run(){
                try {
                    while (true){
                        Calendar cal= new GregorianCalendar();

                        int day= cal.get(Calendar.DAY_OF_MONTH);
                        int month= cal.get(Calendar.MONTH)+1;
                        int year= cal.get(Calendar.YEAR);

                        int sec= cal.get(Calendar.SECOND);
                        int min= cal.get(Calendar.MINUTE);
                        int hour= cal.get(Calendar.HOUR_OF_DAY);

                        lblFechaD.setText(year+"-"+month+"-"+day);
                        if (min<10){
                            lblHoraD.setText(hour+":0"+min+":"+sec);
                        
                        }else{
                            lblHoraD.setText(hour+":"+min+":"+sec);
                        }
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tareas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }
    public void llenaCombos(){
        cmbTarea.removeAllItems();
        cmbEmpleado.removeAllItems();
        try{    
            stm=conex.createStatement();
            ResultSet lista = stm.executeQuery("select nombre from empleado");

            while (lista.next()){
                cmbEmpleado.addItem(lista.getString(1));
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
        try{
            stm=conex.createStatement();
            ResultSet lista2 = stm.executeQuery("select detalle from tarea");
            while(lista2.next()){
                cmbTarea.addItem(lista2.getString(1));
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
    public void mostrarTablaEmp(){
        try{
            stm=conex.createStatement();
            jtEmpleados.removeAll();
            ResultSet rs = stm.executeQuery("select empleado.Rut, empleo.nom_empleo, empleado.nombre, empleado.tipo, empleado.fono, empleado.email , empleado.hora_entrada, empleado.hora_salida FROM empleado INNER JOIN empleo ON empleado.Empleo_cod_empleo = empleo.cod_empleo");
            
            DefaultTableModel mod =(DefaultTableModel)jtEmpleados.getModel();
            mod.setRowCount(0);
            while(rs.next()){
                String tp;
                if (rs.getString("tipo").equals("A")){
                    tp="Administrador";
                }else{tp="Empleado";}
                Object data[]={rs.getString("rut"),rs.getString("nom_empleo"),rs.getString("nombre"),tp,rs.getString("fono"),rs.getString("email"),rs.getString("hora_entrada"),rs.getString("hora_salida")};
                mod.addRow(data);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
        }
    }

    
    public void mostrarTablaInv(){
        try{
            stm=conex.createStatement();
            jtItems.removeAll();
            ResultSet rs = stm.executeQuery("select * from item");
            
            DefaultTableModel mod =(DefaultTableModel)jtItems.getModel();
            mod.setRowCount(0);
            while(rs.next()){
                String est;
                if (rs.getString("estado").equals("0")){
                    est= "Disponible";
                }else{est="Prestado";}
                Object data[]={rs.getString("cod_item"),rs.getString("nombre"),rs.getString("cantidad_real"),rs.getString("cantidad_critica"),est};
                mod.addRow(data);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
    }

    
    public void mostrarTablaAT(){
        try{
            stm=conex.createStatement();
            jtAT.removeAll();
            ResultSet rs = stm.executeQuery("SELECT asignacion_tarea.Empleado_Rut , tarea.detalle , asignacion_tarea.fecha , asignacion_tarea.hora_act , asignacion_tarea.observacion FROM asignacion_tarea INNER JOIN tarea ON asignacion_tarea.Tarea_cod_tarea = tarea.cod_tarea ");
            
            DefaultTableModel mod =(DefaultTableModel)jtAT.getModel();
            mod.setRowCount(0);
            while(rs.next()){
                Object data[]={rs.getString("empleado_rut"),rs.getString("detalle"),rs.getString("fecha"),rs.getString("hora_act"),rs.getString("observacion")};
                mod.addRow(data);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
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

        panelCont = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        cmdEliminar = new javax.swing.JButton();
        cmdModificar = new javax.swing.JButton();
        cmdAñadir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItems = new javax.swing.JTable();
        cmdEliminar2 = new javax.swing.JButton();
        cmdModificar2 = new javax.swing.JButton();
        cmdAñadir2 = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        lblTarea = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        cmbTarea = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAT = new javax.swing.JTable();
        lblObs = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        lblFechaD = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblHoraD = new javax.swing.JLabel();
        cmdAñadir3 = new javax.swing.JButton();
        cmdEliminar3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        emp = new javax.swing.JMenu();
        empVer = new javax.swing.JMenuItem();
        invt = new javax.swing.JMenu();
        invtVer = new javax.swing.JMenuItem();
        invtCompras = new javax.swing.JMenuItem();
        asist = new javax.swing.JMenu();
        asistIng = new javax.swing.JMenuItem();
        asistSeg = new javax.swing.JMenuItem();
        tarea = new javax.swing.JMenu();
        tareaAsig = new javax.swing.JMenuItem();
        tareaVer = new javax.swing.JMenuItem();
        solicitud = new javax.swing.JMenu();
        verSoli = new javax.swing.JMenuItem();
        exmenu = new javax.swing.JMenu();
        exmenuCS = new javax.swing.JMenuItem();
        exmenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelCont.setLayout(new java.awt.CardLayout());

        cmdEliminar.setText("Eliminar");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });

        cmdModificar.setText("Modificar");
        cmdModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificarActionPerformed(evt);
            }
        });

        cmdAñadir.setText("Añadir");
        cmdAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadirActionPerformed(evt);
            }
        });

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"19974002-4", "Administrador", "Enzo Silva", "Administrador", "+56912345678", "a@gmail.com", "09:00", "19:00"},
                {"10862755-7", "Chef", "Carlos Perez", "Empleado", "+56912345687", "b@gmail.com", "08:30", "18:00"},
                {"15067621-5", "Ayudante", "Pedro Salinas", "EMpoleado", "+56912345567", "c@@gmail.com", "10:00", "20:00"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Empleo", "Nombre", "Tipo", "Fono", "Email", "Hora Entrada", "Hora Salida"
            }
        ));
        jtEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtEmpleados);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(cmdAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCont.add(panel3, "3");

        jtItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Tenedor", "50", "20", "Disponible"},
                {"2", "Cuchara", "50", "20", "Disponible"},
                {"3", "Sartén", "50", "20", "Disponible"}
            },
            new String [] {
                "Cod Item", "Nombre", "Cantidad Real", "Cantidad Critica", "Estado"
            }
        ));
        jtItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtItems);
        if (jtItems.getColumnModel().getColumnCount() > 0) {
            jtItems.getColumnModel().getColumn(0).setResizable(false);
            jtItems.getColumnModel().getColumn(1).setResizable(false);
            jtItems.getColumnModel().getColumn(2).setResizable(false);
            jtItems.getColumnModel().getColumn(3).setResizable(false);
            jtItems.getColumnModel().getColumn(4).setResizable(false);
        }

        cmdEliminar2.setText("Eliminar");
        cmdEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminar2ActionPerformed(evt);
            }
        });

        cmdModificar2.setText("Modificar");
        cmdModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModificar2ActionPerformed(evt);
            }
        });

        cmdAñadir2.setText("Añadir");
        cmdAñadir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadir2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdAñadir2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAñadir2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCont.add(panel2, "2");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        panelCont.add(panel1, "1");

        lblTarea.setText("Tareas:");

        lblEmpleado.setText("Empleados:");

        cmbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedro Salinas" }));

        cmbTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trapear" }));

        jtAT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"15067621-5", "Trapear", "2020-08-01", "10:15:10", "Trapear espacio"}
            },
            new String [] {
                "Rut Empleado", "Tarea", "Fecha", "Hora", "Observación"
            }
        ));
        jtAT.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtAT);

        lblObs.setText("Observacion:");

        txtObs.setColumns(1);
        txtObs.setRows(3);
        jScrollPane4.setViewportView(txtObs);

        lblFechaD.setText("-");

        lblFecha.setText("Fecha:");

        lblHora.setText("Hora actual:");

        lblHoraD.setText("-");

        cmdAñadir3.setText("Añadir");
        cmdAñadir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAñadir3ActionPerformed(evt);
            }
        });

        cmdEliminar3.setText("Eliminar");
        cmdEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpleado)
                            .addComponent(lblTarea))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblObs)
                    .addComponent(jScrollPane4)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHora)
                            .addComponent(lblFecha))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaD)
                            .addComponent(lblHoraD)))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(cmdAñadir3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdEliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTarea)
                            .addComponent(cmbTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpleado)
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdAñadir3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdEliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(lblFechaD))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHora)
                            .addComponent(lblHoraD))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCont.add(panel4, "4");

        emp.setText("Empleados");

        empVer.setText("Ver Empleados");
        empVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empVerActionPerformed(evt);
            }
        });
        emp.add(empVer);

        jMenuBar1.add(emp);

        invt.setText("Inventario");

        invtVer.setText("Ver Items");
        invtVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invtVerActionPerformed(evt);
            }
        });
        invt.add(invtVer);

        invtCompras.setText("Ingreso de Compras");
        invtCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invtComprasActionPerformed(evt);
            }
        });
        invt.add(invtCompras);

        jMenuBar1.add(invt);

        asist.setText("Asistencia");

        asistIng.setText("Ingreso/Salida");
        asistIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asistIngActionPerformed(evt);
            }
        });
        asist.add(asistIng);

        asistSeg.setText("Seguimiento");
        asistSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asistSegActionPerformed(evt);
            }
        });
        asist.add(asistSeg);

        jMenuBar1.add(asist);

        tarea.setText("Tareas");

        tareaAsig.setText("Asignar Tareas");
        tareaAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareaAsigActionPerformed(evt);
            }
        });
        tarea.add(tareaAsig);

        tareaVer.setText("Ver Tareas");
        tareaVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareaVerActionPerformed(evt);
            }
        });
        tarea.add(tareaVer);

        jMenuBar1.add(tarea);

        solicitud.setText("Solicitudes");

        verSoli.setText("Ver solicitudes");
        verSoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSoliActionPerformed(evt);
            }
        });
        solicitud.add(verSoli);

        jMenuBar1.add(solicitud);

        exmenu.setText("Sesion");

        exmenuCS.setText("Cerrar Sesion");
        exmenuCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exmenuCSActionPerformed(evt);
            }
        });
        exmenu.add(exmenuCS);

        exmenuSalir.setText("Salir");
        exmenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exmenuSalirActionPerformed(evt);
            }
        });
        exmenu.add(exmenuSalir);

        jMenuBar1.add(exmenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        int ind= jtEmpleados.getSelectedRow();
        DefaultTableModel mod =(DefaultTableModel)jtEmpleados.getModel();
        int count=0;
        String n = "Seguro quiere eliminar estos datos? :";
        while (count<6){
            n=n+ mod.getValueAt(ind, count).toString()+" ";
            count++;
        }
        String del= mod.getValueAt(ind, 0).toString();
        switch (JOptionPane.showConfirmDialog(null, n,"confirmacion",2)){
            case 0:
                try{
                    stm=conex.createStatement();
                    stm.executeUpdate("delete from empleado where Rut='"+del+"'");
                    
                    mostrarTablaEmp();
            
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
                }
            default:
                break;
        }
        
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void empVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empVerActionPerformed
        mostrarTablaEmp();
        c1.show(panelCont, "3");
    }//GEN-LAST:event_empVerActionPerformed

    private void cmdModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificarActionPerformed
        int ind= jtEmpleados.getSelectedRow();
        DefaultTableModel mod =(DefaultTableModel)jtEmpleados.getModel();
        
        String r= mod.getValueAt(ind, 0).toString();
        String c= mod.getValueAt(ind, 1).toString();
        String n= mod.getValueAt(ind, 2).toString();
        String t= mod.getValueAt(ind, 3).toString();
        String f= mod.getValueAt(ind, 4).toString();
        String e= mod.getValueAt(ind, 5).toString();
        String he= mod.getValueAt(ind, 6).toString();
        String hs= mod.getValueAt(ind, 7).toString();
        Emp empleado = new Emp(this,r,c,n,t,f,e,he,hs);
        empleado.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_cmdModificarActionPerformed
    
    private void cmdAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadirActionPerformed
        Emp empleado = new Emp(this);
        empleado.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_cmdAñadirActionPerformed

    private void invtVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invtVerActionPerformed
        mostrarTablaInv();
        c1.show(panelCont, "2");
    }//GEN-LAST:event_invtVerActionPerformed

    private void cmdEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminar2ActionPerformed
        int ind= jtItems.getSelectedRow();
        DefaultTableModel mod =(DefaultTableModel)jtItems.getModel();
        int count=0;
        String n = "Seguro quiere eliminar estos datos? :";
        while (count<5){
            n=n+ mod.getValueAt(ind, count).toString()+" ";
            count++;
        }
        String del= mod.getValueAt(ind, 0).toString();
        switch (JOptionPane.showConfirmDialog(null, n,"confirmacion",2)){
            case 0:
                try{
                    stm=conex.createStatement();
                    stm.executeUpdate("delete from item where cod_item="+del);
                    
                    mostrarTablaInv();
            
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "selec"+ex,"conexion",3);
                }
            default:
                break;
        }
    }//GEN-LAST:event_cmdEliminar2ActionPerformed

    private void cmdAñadir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadir2ActionPerformed
        Item item = new Item(this);
        item.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_cmdAñadir2ActionPerformed

    private void cmdModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModificar2ActionPerformed
        int ind= jtItems.getSelectedRow();
        if (ind == -1){
            JOptionPane.showMessageDialog(null,"Si desea modificar un item, selecciónelo en la tabla\ny después presione Modificar ","Alerta",3);
        }
        DefaultTableModel mod =(DefaultTableModel)jtItems.getModel();
        
        String cod= mod.getValueAt(ind, 0).toString();
        String nom= mod.getValueAt(ind, 1).toString();
        String creal= mod.getValueAt(ind, 2).toString();
        String ccrit= mod.getValueAt(ind, 3).toString();
        String est= mod.getValueAt(ind, 4).toString();
        
        Item item = new Item(this,cod,nom,creal,ccrit,est);
        item.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_cmdModificar2ActionPerformed

    private void exmenuCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exmenuCSActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Seguro desea cerrar sesion?","Confirmación",JOptionPane.YES_NO_OPTION)){
            case 0:
                Inicio in = new Inicio();
                in.setVisible(true);
                this.dispose();
            default:
                break;
        }
        
        
    }//GEN-LAST:event_exmenuCSActionPerformed

    private void exmenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exmenuSalirActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Seguro desea salir?","Confirmación",JOptionPane.YES_NO_OPTION)){
            case 0:
                System.exit(0);
            default:
                break;
        }
    }//GEN-LAST:event_exmenuSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmed = JOptionPane.showConfirmDialog(null, 
        "Seguro desea salir?","Confirmación", 
        JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void tareaAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareaAsigActionPerformed
        c1.show(panelCont, "4");
        llenaCombos();
        mostrarTablaAT();
    }//GEN-LAST:event_tareaAsigActionPerformed

    private void cmdAñadir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAñadir3ActionPerformed
        String t = cmbTarea.getSelectedItem().toString();
        String e = cmbEmpleado.getSelectedItem().toString();
        String o = txtObs.getText();
        String f = lblFechaD.getText();
        String h = lblHoraD.getText();//.substring(0,5);
        //java.sql.Time sqlTime = new java.sql.Time();
        String ee="";
        String tt="";
        
        try{
            stm=conex.createStatement();
            ResultSet rs = stm.executeQuery("select cod_tarea from tarea where detalle='"+t+"'");
            rs.next();
            tt= rs.getString(1);
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
        try{
            stm=conex.createStatement();
            ResultSet rs = stm.executeQuery("select rut from empleado where nombre='"+e+"'");
            rs.next();
            ee= rs.getString(1);

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
        switch(JOptionPane.showConfirmDialog(null,"Quieres asignar esta tarea al empleado "+e,"confirmacion",2)){
            case 0:
                try{
                    stm=conex.createStatement();
                    stm.executeUpdate("insert into asignacion_tarea values('"+ee+"',"+tt+",'"+f+"','"+h+"','"+o+"')");
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,ex,"conexion",3);
                }
                mostrarTablaAT();
            default:
                break;
        }
        
    }//GEN-LAST:event_cmdAñadir3ActionPerformed

    private void cmdEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminar3ActionPerformed
        int ind= jtAT.getSelectedRow();
        DefaultTableModel mod =(DefaultTableModel)jtAT.getModel();
        int count=0;
        String n = "Seguro quiere eliminar estos datos? :";
        while (count<5){
            n=n+ mod.getValueAt(ind, count).toString()+" ";
            count++;
        }
        String rut = mod.getValueAt(ind, 0).toString();
        String tarea = mod.getValueAt(ind, 1).toString();
        String fecha = mod.getValueAt(ind, 2).toString();
        String hora = mod.getValueAt(ind, 3).toString();
        try{
            stm=conex.createStatement();
            ResultSet rs = stm.executeQuery("select cod_tarea from tarea where detalle='"+tarea+"'");
            rs.next();
            tarea= rs.getString(1);
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,ex,"conexion",3);
        }
        switch (JOptionPane.showConfirmDialog(null, n,"confirmacion",2)){
            case 0:
                try{
                    stm=conex.createStatement();
                    stm.executeUpdate("delete from asignacion_tarea where empleado_rut='"+rut+"' and Tarea_cod_tarea="+tarea+" and fecha='"+fecha+"' and hora_act='"+hora+"'");
                    
                    mostrarTablaAT();
            
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,ex,"conexion",3);
                }
            default:
                break;
        }
    }//GEN-LAST:event_cmdEliminar3ActionPerformed

    private void tareaVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareaVerActionPerformed
        Tareas t = new Tareas(this);
        t.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_tareaVerActionPerformed

    private void invtComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invtComprasActionPerformed
        Compra comp = new Compra(this);
        comp.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_invtComprasActionPerformed

    private void asistIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asistIngActionPerformed
        Asistencia asis = new Asistencia(this);
        asis.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_asistIngActionPerformed

    private void asistSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asistSegActionPerformed
        SegAsistencia seg=new SegAsistencia(this);
        seg.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_asistSegActionPerformed

    private void verSoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSoliActionPerformed
        VerSolicitudes verSol=new VerSolicitudes(this);
        verSol.setVisible(true);
        this.setEnabled(false);
        
    }//GEN-LAST:event_verSoliActionPerformed
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu asist;
    private javax.swing.JMenuItem asistIng;
    private javax.swing.JMenuItem asistSeg;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbTarea;
    private javax.swing.JButton cmdAñadir;
    private javax.swing.JButton cmdAñadir2;
    private javax.swing.JButton cmdAñadir3;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdEliminar2;
    private javax.swing.JButton cmdEliminar3;
    private javax.swing.JButton cmdModificar;
    private javax.swing.JButton cmdModificar2;
    private javax.swing.JMenu emp;
    private javax.swing.JMenuItem empVer;
    private javax.swing.JMenu exmenu;
    private javax.swing.JMenuItem exmenuCS;
    private javax.swing.JMenuItem exmenuSalir;
    private javax.swing.JMenu invt;
    private javax.swing.JMenuItem invtCompras;
    private javax.swing.JMenuItem invtVer;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtAT;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JTable jtItems;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaD;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHoraD;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panelCont;
    private javax.swing.JMenu solicitud;
    private javax.swing.JMenu tarea;
    private javax.swing.JMenuItem tareaAsig;
    private javax.swing.JMenuItem tareaVer;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JMenuItem verSoli;
    // End of variables declaration//GEN-END:variables
}
