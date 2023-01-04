/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import MODELO.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author barre
 */
public class Complementos {

    public int getmontoventa(String b) {
        Conectar con = new Conectar();
        Connection conn = con.conectar();
        String sql = "SELECT monto FROM VENTAS where nmr_contrato=?";
        PreparedStatement ps;
        ResultSet rs;
        int monto = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            rs = ps.executeQuery();
            while (rs.next()) {
                monto = rs.getInt("monto");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return monto;
    }

    public int getrentabilidad(int c) {
        Conectar con = new Conectar();
        Connection conn = con.conectar();
        String sql = "SELECT rentabilidad FROM planes where id_plan=?";
        PreparedStatement ps;
        ResultSet rs;
        int rentabilidad = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, c);
            rs = ps.executeQuery();
            while (rs.next()) {
                rentabilidad = rs.getInt("rentabilidad");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return rentabilidad;
    }

    public int getfilas() {
        Conectar con = new Conectar();
        PreparedStatement ps;
        ResultSet rs;
        int numerocol = 0;
        Connection conn = con.conectar();
        String sentencia = "SELECT COUNT(*) FROM ventas;";
        try {
            ps = conn.prepareStatement(sentencia);
            rs = ps.executeQuery();
            while (rs.next()) {
                numerocol = rs.getInt("count");
            }

        } catch (Exception e) {
        }

        return numerocol + 1;

    }

    public int getduracionplanes(int w) {

        Conectar con = new Conectar();
        PreparedStatement ps;
        ResultSet rs;
        int duracion = 0;
        Connection conn = con.conectar();
        String sentencia = "select duracion from planes where id_plan=?;";
        try {
            ps = conn.prepareStatement(sentencia);
            ps.setInt(1, w);
            rs = ps.executeQuery();
            while (rs.next()) {
                duracion = rs.getInt("duracion");
            }

        } catch (Exception e) {
        }

        return duracion;

    }

    public void setpagosCorto(int x, int y, int b, Date fechaa) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = fechaa;
        Calendar calendar = new GregorianCalendar();

        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, getduracionplanes(y));
        String resultado = sdf.format(calendar.getTime());
        Conectar Con = new Conectar();
        Connection conn = Con.conectar();
        PreparedStatement ps;
        String sql3 = "INSERT INTO pagos( monto, fecha_pago, retencion, id_venta) VALUES (?, ?, ?, ?);";
        int montoinvertido = x;
        int rentabilidadebruto = (montoinvertido * (getrentabilidad(y))) / 100;
        double retencion = (rentabilidadebruto * 5) / 100;
        int montopago = (int) (rentabilidadebruto - retencion);
        try {

            Date result = sdf.parse(resultado);
            java.sql.Date sqldate = new java.sql.Date(result.getTime());
            ps = conn.prepareStatement(sql3);
            ps.setInt(1, montopago);
            ps.setDate(2, sqldate);
            ps.setDouble(3, retencion);
            ps.setInt(4, b);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    public void setpagoslargo(int x, int y, int b, Date fechaa) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = fechaa;
        Calendar calendar = new GregorianCalendar();
        PreparedStatement ps;

        
        int montoinvertido = x;
        int rentabilidadebruto = (montoinvertido * (getrentabilidad(y))) / 100;
        double retencion = (rentabilidadebruto * 5) / 100;
        int montopago = (int) (rentabilidadebruto - retencion);
        try {
            Conectar Con = new Conectar();
            Connection conn = Con.conectar();

            for (int i = 0; i <getduracionplanes(y) ; i++) {
                calendar.setTime(fecha);
                calendar.add(Calendar.MONTH, i);
                String resultado = sdf.format(calendar.getTime());
                Date result = sdf.parse(resultado);
                java.sql.Date sqldate = new java.sql.Date(result.getTime());
                String sql3 = "INSERT INTO pagos( monto, fecha_pago, retencion, id_venta) VALUES (?, ?, ?, ?);";
                ps = conn.prepareStatement(sql3);
                ps.setInt(1, montopago);
                ps.setDate(2, sqldate);
                ps.setDouble(3, retencion);
                ps.setInt(4, b);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

}
