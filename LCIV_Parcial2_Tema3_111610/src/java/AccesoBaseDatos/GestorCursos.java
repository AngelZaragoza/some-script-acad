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
    
    //METODOS DE ALTA 

    public void agregarCurso(Curso nuevo) {

        try {
            abrirConexion();            
            String sql = "INSERT INTO Cursos(nombre, descripcion, costo, imagenURL, activo) values(?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nuevo.getNombre());
            st.setString(2, nuevo.getDescripcion());
            st.setFloat(3, nuevo.getCosto());
            st.setString(4, nuevo.getImagenUrl());
            st.setBoolean(5, nuevo.isActivo());

            st.executeUpdate();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }
    
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

            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorCursos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }


}
