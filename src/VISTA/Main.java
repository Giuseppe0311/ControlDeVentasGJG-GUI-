/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VISTA;


import MODELO.Conectar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Main {
  public static void main(String[] args) {
      Conectar con = new Conectar();
      Connection conn = con.conectar();
      String sql = "SELECT idventa FROM VENTAS where nmr_contrato=?";
      PreparedStatement ps;
      ResultSet rs ; 
      int id = 0 ;
      try {
          ps = conn.prepareStatement(sql);
          ps.setString(1,"XRLO9" );
          rs = ps.executeQuery();
          while (rs.next()) {              
              id = rs.getInt("idventa");
              
          }
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.toString());
      }
             System.out.println(id+"holaaaaa");

  }
}


