/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import Entidades.TIPOS_PLAN;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author barre
 */
public class ModeloTipoPlan {

    public ArrayList<TIPOS_PLAN> getTiposPlan() {
        Conectar con = new Conectar();
        Connection conn = con.conectar();
        String sql = "SELECT *FROM tipos_plan";
        ArrayList<TIPOS_PLAN> listaaa = new ArrayList<>();
        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TIPOS_PLAN tp = new TIPOS_PLAN();
                tp.setId(rs.getString("idtipoplan"));
                tp.setNombre(rs.getString("nombre_tipoplan"));
                listaaa.add(tp);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.toString());
        }
  return listaaa;
    }
}
