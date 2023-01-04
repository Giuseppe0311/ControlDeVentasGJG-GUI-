/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author barre
 */
public class Conectar {
    
 Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/GJGSOLUCIONES";
    String usuario = "postgres";
    String clave = "1234";

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    url,
                    usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar", "Error", JOptionPane.ERROR_MESSAGE);

        }
        return conn;
    }

}
