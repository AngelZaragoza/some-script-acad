package AccesoBaseDatos;

import DTO.*;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    //METODOS DE CONSULTA
    
    //Llenar Combo Alumnos
    //********************
    public ArrayList<DTOComboAlumnos> listaAlumnos() {

        ArrayList<DTOComboAlumnos> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            String sql = "SELECT idAlumno, apellido + ' ' + nombre + ' - Leg: ' + legajo AS nombreCompleto FROM Alumnos";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombreCompleto = rs.getString("nombreCompleto");                

                DTOComboAlumnos al = new DTOComboAlumnos(idAlumno, nombreCompleto);
                lista.add(al);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
    
    //Llenar Combo Cursos
    //********************
    public ArrayList<DTOComboCursos> listaCursos() {

        ArrayList<DTOComboCursos> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            String sql = "SELECT idCurso, nombre + ' - $ ' + LTRIM(STR(costo, 10, 2)) AS nombreCurso"
                    + ", costo FROM Cursos";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String nombreCurso = rs.getString("nombreCurso");                
                float costo = rs.getFloat("costo");
                DTOComboCursos cur = new DTOComboCursos(idCurso, nombreCurso, costo);
                lista.add(cur);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
    
    //Llenar Combo Descuentos
    //********************
    public ArrayList<Descuento> listaDescuentos() {

        ArrayList<Descuento> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Descuentos";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idDescuento = rs.getInt("idDescuento");
                String descripcion = rs.getString("descripcion");
                int porcentDescuento = rs.getInt("porcentDescuento");

                Descuento desc = new Descuento(idDescuento, descripcion, porcentDescuento);
                lista.add(desc);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }

    //Devolver montos para el cálculo en la Inscripción
    //*************************************************
    public DTOMontosInscripcion montosInscripcion(int idCurso, int idDescuento) {
        
        DTOMontosInscripcion resultado = null;
        
        try {

            abrirConexion();
            String sql = "SELECT costo, porcentDescuento FROM Cursos, Descuentos "
                    + "WHERE idCurso = ? AND idDescuento = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ps.setInt(2, idDescuento);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                float costoCurso = rs.getFloat("costo");                
                int porcentDescuento = rs.getInt("porcentDescuento");
                
                resultado = new DTOMontosInscripcion(costoCurso, porcentDescuento);

            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return resultado;
        
    }
    
    
    //Dar de Alta Inscripción
    //************************
    public void agregarInscripcion (Inscripcion nueva) {

        try {
            abrirConexion();            
            String sql = "INSERT INTO Inscripciones (idAlumno, idCurso, idDescuento"
                    + ", fechaInscripcion, montoDescuento, montoAbonado) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nueva.getIdAlumno());
            ps.setInt(2, nueva.getIdCurso());
            ps.setInt(3, nueva.getIdDescuento());
            ps.setString(4, nueva.getFechaInscripcion());
            ps.setFloat(5, nueva.getMontoDescuento());
            ps.setFloat(6, nueva.getMontoAbonado());            

            ps.executeUpdate();
            

        } catch (Exception ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }

    //Registrar subida de un Programa
    //*******************************
    public void subirPrograma (Programa prog) {

        try {
            abrirConexion();            
            String sql = "INSERT INTO Programas (idAlumno, nombrePrograma, descripcion"
                    + ", permiteDescarga, cantidadDescargas, pathDescarga) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, prog.getIdAlumno());
            ps.setString(2, prog.getNombrePrograma());
            ps.setString(3, prog.getDescripcion());
            ps.setBoolean(4, prog.isPermiteDescarga());
            ps.setInt(5, prog.getCantidadDescargas());
            ps.setString(6, prog.getPathDescarga());            

            ps.executeUpdate();
            

        } catch (Exception ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            cerrarConexion();
        }        

    }
    
    public ArrayList<Programa> listaProgramas() {

        ArrayList<Programa> lista = new ArrayList<>();
        try {

            abrirConexion();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Programas";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idDPrograma = rs.getInt("idPrograma");
                int idAlumno = rs.getInt("idAlumno");
                String nombrePrograma = rs.getString("nombrePrograma");
                String descripcion = rs.getString("descripcion");
                boolean permiteDescarga = rs.getBoolean("permiteDescarga");
                int cantidadDescargas = rs.getInt("cantidadDescargas");
                String pathDescarga = rs.getString("pathDescarga");

                Programa prog = new Programa(idDPrograma, idAlumno, nombrePrograma, descripcion, permiteDescarga, cantidadDescargas, pathDescarga);
                lista.add(prog);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return lista;
        
    }
//    
//    //Recuperar Alumno con su id
//    //*************************
//    public Alumno getAlumno(int idAlumno) {
//        
//        Alumno alumno = null;
//        
//        try {
//
//            abrirConexion();
//            String sql = "SELECT * FROM Alumnos WHERE idAlumno = ?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, idAlumno);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                String legajo = rs.getString("legajo");
//                String apellido = rs.getString("apellido");
//                String nombre = rs.getString("nombre");
//                String direccion = rs.getString("direccion");
//                String email = rs.getString("email");
//                String fechaNac = rs.getString("fechaNac");
//                boolean activo = rs.getBoolean("activo");
//
//                alumno = new Alumno(idAlumno, legajo, apellido, nombre, direccion, email, fechaNac, activo);
//            }
//
//            rs.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            cerrarConexion();
//        }
//        
//        return alumno;
//        
//    }

}
