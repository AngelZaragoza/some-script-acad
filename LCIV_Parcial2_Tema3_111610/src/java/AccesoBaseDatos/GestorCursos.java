package AccesoBaseDatos;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

public class GestorCursos {

    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LCIV_Academia_111610";
    private String USER = "sa";
    private String PASS = "tekken5";
    private Connection conn;

    public GestorCursos() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
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
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Dar de Alta Curso
    //*****************
    public void agregarCurso(Curso nuevo) {

        try {
            abrirConexion();            
            String sql = "INSERT INTO Cursos(nombre, descripcion, costo, imagenURL, activo) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nuevo.getNombre());
            ps.setString(2, nuevo.getDescripcion());
            ps.setFloat(3, nuevo.getCosto());
            ps.setString(4, nuevo.getImagenUrl());
            ps.setBoolean(5, nuevo.isActivo());

            ps.executeUpdate();
            

        } catch (Exception ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }
    
    //Listar los Cursos
    //*****************
    public ArrayList<Curso> listadoCursos() {

        ArrayList<Curso> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Cursos");

            while (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float costo = rs.getFloat("costo");
                boolean activo = rs.getBoolean("activo");
                String imagenUrl = rs.getString("imagenUrl");

                Curso cur = new Curso(idCurso, nombre, descripcion, costo, imagenUrl, activo);
                lista.add(cur);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
    
    //Recuperar Curso con su id
    //*************************
    public Curso getCurso(int idCurso) {
        
        Curso cur = null;
        
        try {

            abrirConexion();
            String sql = "SELECT * FROM Cursos WHERE idCurso = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float costo = rs.getFloat("costo");
                boolean activo = rs.getBoolean("activo");
                String imagenUrl = rs.getString("imagenUrl");

                cur = new Curso(idCurso, nombre, descripcion, costo, imagenUrl, activo);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return cur;
        
    }

}
