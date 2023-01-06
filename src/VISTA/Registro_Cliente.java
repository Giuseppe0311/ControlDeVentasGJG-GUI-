/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import MODELO.Conectar;
import java.util.Set;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author barre
 */
public class Registro_Cliente extends javax.swing.JFrame {

    int x, y;

    /**
     * Creates new form Registro_Añadir
     */
    public Registro_Cliente() {
        initComponents();
        
        combodepartamentos();
       
    }

    public void combodepartamentos() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            Conectar con = new Conectar();
            Connection conn = con.conectar();
            String sql = "SELECT name from departamentos;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String departamentos = rs.getString("name");
                JCOMBO_DEPARTAMENTO.addItem(departamentos);
            }
          ps.close();
          conn.close();
          rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
      
    }

    public void comboprovincia() {
        PreparedStatement ps;
        ResultSet rs;
        if (JCOMBO_DEPARTAMENTO.getSelectedIndex() == 0) {

        } else {
            String Seleccion = (String) JCOMBO_DEPARTAMENTO.getSelectedItem();
            System.out.println(Seleccion);
            try {
                Conectar con = new Conectar();
                Connection conn = con.conectar();
                String sql = "SELECT Provincias.name FROM PROVINCIAS INNER JOIN departamentos ON PROVINCIAS.department_id = departamentos.id WHERE Departamentos.name =?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, Seleccion);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String Provincias = rs.getString("name");
                    Jcombo_Provincia.addItem(Provincias);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    public void combodistrito(){
    
        PreparedStatement ps;
        ResultSet rs;
        if (JCOMBO_DEPARTAMENTO.getSelectedIndex() == 0) {

        } else {
            String Seleccion = (String) Jcombo_Provincia.getSelectedItem();
            System.out.println(Seleccion);
            try {
                Conectar con = new Conectar();
                Connection conn = con.conectar();
                String sql = "SELECT Distritos.name  FROM Distritos INNER JOIN provincias ON Distritos.province_id = provincias.id INNER JOIN Departamentos ON Distritos.department_id=Departamentos.id AND   PROVINCIAS.department_id = departamentos.id WHERE provincias.name =?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, Seleccion);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String distritos = rs.getString("name");
                    Jcombo_Distrito.addItem(distritos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jfield_nombre = new javax.swing.JTextField();
        jfield_direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jfield_profesion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jfield_cuentacliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jfield_correo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jfield_cci = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jfield_whatsapp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jfield_dni = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jfield_numruc = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        JCOMBO_DEPARTAMENTO = new javax.swing.JComboBox<>();
        Jcombo_Provincia = new javax.swing.JComboBox<>();
        Jcombo_Distrito = new javax.swing.JComboBox<>();
        JCOmbobanco = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-cliente-de-empresa-100.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/OFICINA.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 310, 300));

        jLabel18.setBackground(new java.awt.Color(255, 0, 0));
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Mis Clientes");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 70, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-user-account-96.png"))); // NOI18N
        jLabel19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel19MouseMoved(evt);
            }
        });
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 170, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 350, 620));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-find-user-male-24.png"))); // NOI18N
        jLabel4.setText("Nombre : ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));
        jPanel2.add(jfield_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 170, -1));
        jPanel2.add(jfield_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 170, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-place-marker-24.png"))); // NOI18N
        jLabel5.setText("Dirección :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-map-pinpoint-24.png"))); // NOI18N
        jLabel6.setText("Distrito :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-map-pin-24.png"))); // NOI18N
        jLabel7.setText("Provincia :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 90, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-map-marker-24.png"))); // NOI18N
        jLabel8.setText("Departamento : ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, -1));

        jfield_profesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfield_profesionActionPerformed(evt);
            }
        });
        jPanel2.add(jfield_profesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-student-male-24.png"))); // NOI18N
        jLabel10.setText("Profesión : ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-merchant-account-24.png"))); // NOI18N
        jLabel9.setText("Banco :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 80, -1));

        jfield_cuentacliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfield_cuentaclienteActionPerformed(evt);
            }
        });
        jPanel2.add(jfield_cuentacliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 170, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-bank-card-missing-24.png"))); // NOI18N
        jLabel11.setText("Cuenta del Cliente :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 140, -1));
        jPanel2.add(jfield_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 170, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-card-security-24.png"))); // NOI18N
        jLabel12.setText("CCI :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, -1));
        jPanel2.add(jfield_cci, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 170, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-at-sign-24.png"))); // NOI18N
        jLabel13.setText("Correo :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 90, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-whatsapp-24.png"))); // NOI18N
        jLabel14.setText("Numero  de Whatsapp :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 160, -1));
        jPanel2.add(jfield_whatsapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 170, -1));

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-fingerprint-24.png"))); // NOI18N
        jLabel15.setText("DNI :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 60, -1));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("INGRESE LOS DATOS DE SU CLIENTE : ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Confirmar");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 60, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-confirm-64 (1).png"))); // NOI18N
        jLabel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel16MouseMoved(evt);
            }
        });
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 100, 90));
        jPanel2.add(jfield_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-return-32_1.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 80, -1));

        jLabel21.setBackground(new java.awt.Color(255, 0, 0));
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Atrás");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 30, -1));
        jPanel2.add(jfield_numruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 170, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8-good-pincode-24.png"))); // NOI18N
        jLabel22.setText("RUC :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_Multiply_32px.png"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabel25.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel25MouseDragged(evt);
            }
        });
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel25MousePressed(evt);
            }
        });
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 440, 30));

        JCOMBO_DEPARTAMENTO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        JCOMBO_DEPARTAMENTO.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JCOMBO_DEPARTAMENTOMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JCOMBO_DEPARTAMENTOMouseMoved(evt);
            }
        });
        JCOMBO_DEPARTAMENTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCOMBO_DEPARTAMENTOMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JCOMBO_DEPARTAMENTOMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JCOMBO_DEPARTAMENTOMousePressed(evt);
            }
        });
        JCOMBO_DEPARTAMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCOMBO_DEPARTAMENTOActionPerformed(evt);
            }
        });
        jPanel2.add(JCOMBO_DEPARTAMENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 160, -1));

        Jcombo_Provincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jcombo_ProvinciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Jcombo_ProvinciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Jcombo_ProvinciaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Jcombo_ProvinciaMousePressed(evt);
            }
        });
        Jcombo_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcombo_ProvinciaActionPerformed(evt);
            }
        });
        jPanel2.add(Jcombo_Provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 170, -1));

        Jcombo_Distrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jcombo_DistritoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Jcombo_DistritoMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Jcombo_DistritoMousePressed(evt);
            }
        });
        jPanel2.add(Jcombo_Distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, -1));

        JCOmbobanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INTERBAK", "BBVA", "BANCO DE LA  NACION", "SCOTIABANK" }));
        jPanel2.add(JCOmbobanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 170, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 700, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jfield_profesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfield_profesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfield_profesionActionPerformed

    private void jLabel19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseMoved
        // TODO add your handling code here:
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_jLabel19MouseMoved

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        MENU men1 = new MENU();
        men1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jfield_cuentaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfield_cuentaclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfield_cuentaclienteActionPerformed

    private void jLabel16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseMoved
        // TODO add your handling code here:
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

    }//GEN-LAST:event_jLabel16MouseMoved

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        int dialog12 = JOptionPane.YES_NO_OPTION;
        int result12 = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog12);
        if (result12 == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        this.setState(MENU.ICONIFIED);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        String DNI = jfield_dni.getText();
        String Nombre = jfield_nombre.getText();
        String Direccion = jfield_direccion.getText();
        String Distrito = (String) Jcombo_Distrito.getSelectedItem();
        String provincia = (String) Jcombo_Provincia.getSelectedItem();
        String Departamento = (String) JCOMBO_DEPARTAMENTO.getSelectedItem();
        String Profesion = jfield_profesion.getText();
        String Banco = (String) JCOmbobanco.getSelectedItem();
        long cuentacliente = Long.parseLong(jfield_cuentacliente.getText());
        long CC1 = Long.parseLong(jfield_cci.getText());
        String correo = jfield_correo.getText();
        long whatsapp = Long.parseLong(jfield_whatsapp.getText());
        long ruc = Long.parseLong(jfield_numruc.getText());
        PreparedStatement ps;

        try {
            Conectar con = new Conectar();
            Connection conn = con.conectar();
            String Sentencia = "INSERT INTO clientes(dni, nombre, direccion, distrito, provincia, departamento, profesion, banco, cuentacliente, cci, correo, whatsapp, ruc,estado)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
            ps = conn.prepareStatement(Sentencia);
            ps.setString(1, DNI);
            ps.setString(2, Nombre);
            ps.setString(3, Direccion);
            ps.setString(4, Distrito);
            ps.setString(5, provincia);
            ps.setString(6, Departamento);
            ps.setString(7, Profesion);
            ps.setString(8, Banco);
            ps.setLong(9, cuentacliente);
            ps.setLong(10, CC1);
            ps.setString(11, correo);
            ps.setLong(12, whatsapp);
            ps.setLong(13, ruc);
            ps.setString(14, "Activo");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "CLIENTE GUARDADO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel25MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);

    }//GEN-LAST:event_jLabel25MouseDragged

    private void jLabel25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel25MousePressed

    private void JCOMBO_DEPARTAMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOActionPerformed

    private void JCOMBO_DEPARTAMENTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOMouseClicked
        // TODO add your handling code here:
       

    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOMouseClicked

    private void Jcombo_ProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_ProvinciaMouseClicked
        // TODO add your handling code here:
        Jcombo_Provincia.removeAllItems();
        comboprovincia();
        
    }//GEN-LAST:event_Jcombo_ProvinciaMouseClicked

    private void Jcombo_ProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcombo_ProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jcombo_ProvinciaActionPerformed

    private void Jcombo_ProvinciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_ProvinciaMouseEntered
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_Jcombo_ProvinciaMouseEntered

    private void Jcombo_ProvinciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_ProvinciaMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Jcombo_ProvinciaMousePressed

    private void JCOMBO_DEPARTAMENTOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOMousePressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOMousePressed

    private void JCOMBO_DEPARTAMENTOMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOMouseDragged

    private void JCOMBO_DEPARTAMENTOMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOMouseMoved

    private void JCOMBO_DEPARTAMENTOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCOMBO_DEPARTAMENTOMouseExited
        // TODO add your handling code here:
    
    }//GEN-LAST:event_JCOMBO_DEPARTAMENTOMouseExited

    private void Jcombo_DistritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_DistritoMouseClicked
        // TODO add your handling code here:
        Jcombo_Distrito.removeAllItems();
        combodistrito();
    }//GEN-LAST:event_Jcombo_DistritoMouseClicked

    private void Jcombo_ProvinciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_ProvinciaMouseExited
        // TODO add your handling code here:
      
    }//GEN-LAST:event_Jcombo_ProvinciaMouseExited

    private void Jcombo_DistritoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_DistritoMouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_Jcombo_DistritoMouseEntered

    private void Jcombo_DistritoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcombo_DistritoMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_Jcombo_DistritoMousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCOMBO_DEPARTAMENTO;
    private javax.swing.JComboBox<String> JCOmbobanco;
    private javax.swing.JComboBox<String> Jcombo_Distrito;
    private javax.swing.JComboBox<String> Jcombo_Provincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jfield_cci;
    private javax.swing.JTextField jfield_correo;
    private javax.swing.JTextField jfield_cuentacliente;
    private javax.swing.JTextField jfield_direccion;
    private javax.swing.JTextField jfield_dni;
    private javax.swing.JTextField jfield_nombre;
    private javax.swing.JTextField jfield_numruc;
    private javax.swing.JTextField jfield_profesion;
    private javax.swing.JTextField jfield_whatsapp;
    // End of variables declaration//GEN-END:variables
}
