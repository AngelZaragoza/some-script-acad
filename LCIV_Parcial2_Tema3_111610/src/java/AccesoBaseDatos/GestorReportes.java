package AccesoBaseDatos;


import Modelo.*;
import DTO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class GestorReportes {
    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LCIV_Academia_111610";
    private String USER = "sa";
    private String PASS = "tekken5";
    private Connection conn;

    public GestorReportes() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //MANEJO DE LA CONEXION
    private void abrirConexion() {                
        try
        {            
            conn = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception ex)
        {            
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cerrarConexion() {
        try
        {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<DTOFacturacionPorCurso> totalFactPorCurso() {
        
        ArrayList<DTOFacturacionPorCurso> lista = new ArrayList<>();
        
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre, SUM(montoAbonado) AS total " +
                            "FROM Cursos Cu JOIN Inscripciones Ic ON Cu.idCurso = Ic.idCurso " +
                            "GROUP BY nombre " +
                            "ORDER BY nombre");

            while (rs.next()) {                
                String nombre = rs.getString("nombre");
                float total = rs.getFloat("total");

                DTOFacturacionPorCurso cur = new DTOFacturacionPorCurso(nombre, total);
                lista.add(cur);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }        
        
        return lista;
    }
    
    public float totalDescuentos () {
        
        float total = 0;
        
        try {
            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(montoDescuento) AS total FROM Inscripciones");

            if (rs.next()) {                
                total = rs.getFloat("total");
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();        
        }
        
        return total;
    }
}
