/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import Entidades.Clientes;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author barre
 */
public class ModeloClientes {

    public ArrayList<Clientes> getClientes() {
        Conectar con = new Conectar();
        Connection conn = con.conectar();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT*FROM CLIENTES";
        ArrayList<Clientes> listaclientes = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                   Clientes clientes = new Clientes();
                   clientes.setId(rs.getString("dni"));
                   clientes.setNombre(rs.getString("nombre"));
                   listaclientes.add(clientes);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaclientes;

    }
}
