package MODELO;

import Entidades.Clientes;
import Entidades.Planes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author barre
 */
public class ModeloPlanes {
   
       public ArrayList<Planes> getPlanes() {
        Conectar con = new Conectar();
        Connection conn = con.conectar();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT*FROM planes";
        ArrayList<Planes> listaplanes = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                   Planes planes = new Planes();
                   planes.setIdplan(rs.getInt("id_plan"));
                   planes.setNombrePlan(rs.getString("nombre_plan"));
                   planes.setTipo_moneda(rs.getString("tipo_moneda"));
                   planes.setDuraciondias(rs.getInt("duracion"));
                   listaplanes.add(planes);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaplanes;

    }
}
