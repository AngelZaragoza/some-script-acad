package AccesoBaseDatos;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

public class GestorBD {

    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LCIV_Academia_111610";
    private String USER = "sa";
    private String PASS = "tekken5";
    private Connection conn;

    public GestorBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }



//    public ArrayList<Servicio> obtenerServicios() {
//
//        ArrayList<Servicio> lista = new ArrayList<>();
//        try {
//
//            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
//
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM Servicios");
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String tipo = rs.getString("tipo");
//                String descripcion = rs.getString("descripcion");
//                double edad = rs.getDouble("costo");
//
//                Servicio s = new Servicio(id, tipo, descripcion, edad);
//                lista.add(s);
//            }
//
//            st.close();
//
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
//        }
//        return lista;
//    }
//
//
//    public Throwable msjError(String msj) {
//        //A implementar...
//        return null;
//    }
//
}
