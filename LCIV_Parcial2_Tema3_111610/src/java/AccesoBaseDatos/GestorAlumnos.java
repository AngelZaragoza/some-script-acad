package AccesoBaseDatos;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public class GestorAlumnos {

    private String CONN;
    private String USER;
    private String PASS;
    private Connection conn;
    private InitialContext contexto; //Para leer claves del archivo web.xml    

    public GestorAlumnos() {
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
        try
        {            
            conn = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception ex)
        {            
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Dar de Alta Alumno
    //*****************
    public void agregarAlumno(Alumno nuevo) {

        try {
            abrirConexion();            
            String sql = "INSERT INTO Alumnos(legajo, apellido, nombre, direccion"
                    + ", email, fechaNac, activo) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nuevo.getLegajo());
            ps.setString(2, nuevo.getApellido());
            ps.setString(3, nuevo.getNombre());
            ps.setString(4, nuevo.getDireccion());
            ps.setString(5, nuevo.getEmail());
            ps.setString(6, nuevo.getFechaNac());
            ps.setBoolean(7, nuevo.isActivo());

            ps.executeUpdate();
            

        } catch (Exception ex) {
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }
    
    //Modificar datos de un Alumno
    //***************************
    public void modificarAlumno(Alumno alumno) {

        try {
            abrirConexion();            
            String sql = "UPDATE Alumnos SET legajo = ?, apellido = ?, nombre = ?"
                    + ", direccion = ?, email = ?, fechaNac = ?, activo = ? WHERE idAlumno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, alumno.getLegajo());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getDireccion());
            ps.setString(5, alumno.getEmail());
            ps.setString(6, alumno.getFechaNac());
            ps.setBoolean(7, alumno.isActivo());
            ps.setInt(8, alumno.getIdAlumno());

            ps.executeUpdate();
            

        } catch (Exception ex) {
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }
    
    //Listar los Alumnos
    //*****************.
    public ArrayList<Alumno> listadoAlumnos() {

        ArrayList<Alumno> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Alumnos");

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String legajo = rs.getString("legajo");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String fechaNac = rs.getString("fechaNac");
                boolean activo = rs.getBoolean("activo");

                Alumno al = new Alumno(idAlumno, legajo, apellido, nombre, direccion, email, fechaNac, activo);
                lista.add(al);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
    
    //Recuperar Alumno con su id
    //*************************
    public Alumno getAlumno(int idAlumno) {
        
        Alumno alumno = null;
        
        try {

            abrirConexion();
            String sql = "SELECT * FROM Alumnos WHERE idAlumno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String legajo = rs.getString("legajo");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String fechaNac = rs.getString("fechaNac");
                boolean activo = rs.getBoolean("activo");

                alumno = new Alumno(idAlumno, legajo, apellido, nombre, direccion, email, fechaNac, activo);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return alumno;
        
    }

}
