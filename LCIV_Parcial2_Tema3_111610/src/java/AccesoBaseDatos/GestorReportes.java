package AccesoBaseDatos;

import DTO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public class GestorReportes {

    private String CONN;
    private String USER;
    private String PASS;
    private Connection conn;
    private InitialContext contexto; //Para leer claves del archivo web.xml    

    public GestorReportes() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //Recuperar claves del archivo de configuración web.xml
            contexto = new InitialContext();
            CONN = (String) contexto.lookup("java:comp/env/conn-string");
            USER = (String) contexto.lookup("java:comp/env/conn-user");
            PASS = (String) contexto.lookup("java:comp/env/conn-pass");
        } catch (Exception ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);           
        }
    }

    //MANEJO DE LA CONEXION
    private void abrirConexion() {
        try {
            conn = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // REPORTES DE CURSOS
    public ArrayList<DTOFacturacionPorCurso> totalFactPorCurso() {

        ArrayList<DTOFacturacionPorCurso> lista = new ArrayList<>();

        try {

            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre, SUM(montoAbonado) AS total "
                    + "FROM Cursos Cu JOIN Inscripciones Ic ON Cu.idCurso = Ic.idCurso "
                    + "GROUP BY nombre "
                    + "ORDER BY nombre");

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

    public float totalDescuentos() {

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

    // REPORTES DE ALUMNOS
    public ArrayList<DTODatosBasicosAlumnos> alumnosConDescuentos() {

        ArrayList<DTODatosBasicosAlumnos> lista = new ArrayList<>();

        try {

            abrirConexion();
            Statement st = conn.createStatement();
            String sql = "SELECT apellido, nombre, legajo \n"
                    + "FROM Alumnos A JOIN Inscripciones Ic ON A.idAlumno = Ic.idAlumno\n"
                    + "WHERE idDescuento <> 1 \n"
                    + "GROUP BY apellido, nombre, legajo\n"
                    + "ORDER BY apellido";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String legajo = rs.getString("legajo");

                DTODatosBasicosAlumnos alu = new DTODatosBasicosAlumnos(apellido, nombre, legajo);
                lista.add(alu);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DTODatosBasicosAlumnos> alumnosPorCurso(int idCurso) {

        ArrayList<DTODatosBasicosAlumnos> lista = new ArrayList<>();

        try {

            abrirConexion();
            String sql = "SELECT apellido, nombre, legajo \n" +
                        "    FROM LCIV_Academia_111610.dbo.Alumnos Al\n" +
                        "    JOIN LCIV_Academia_111610.dbo.Inscripciones Ic\n" +
                        "        ON Al.idAlumno = Ic.idAlumno\n" +
                        "    WHERE Ic.idCurso = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String legajo = rs.getString("legajo");

                DTODatosBasicosAlumnos alu = new DTODatosBasicosAlumnos(apellido, nombre, legajo);
                lista.add(alu);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }

        return lista;
    }
}
