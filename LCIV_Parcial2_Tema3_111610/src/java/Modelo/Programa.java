package Modelo;

/**
 *
 * @author Angel
 */
public class Programa {
    private int idPrograma;
    private int idAlumno;
    private String nombrePrograma;
    private String descripcion;
    private boolean permiteDescarga;
    private int cantidadDescargas;
    private String pathDescarga;
    
    // CONSTRUCTORES

    public Programa() {
    }

    public Programa(int idPrograma, int idAlumno, String nombrePrograma, String descripcion, boolean permiteDescarga, int cantidadDescargas, String pathDescarga) {
        this.idPrograma = idPrograma;
        this.idAlumno = idAlumno;
        this.nombrePrograma = nombrePrograma;
        this.descripcion = descripcion;
        this.permiteDescarga = permiteDescarga;
        this.cantidadDescargas = cantidadDescargas;
        this.pathDescarga = pathDescarga;
    }
    
    // GETTERS Y SETTERS

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPermiteDescarga() {
        return permiteDescarga;
    }

    public void setPermiteDescarga(boolean permiteDescarga) {
        this.permiteDescarga = permiteDescarga;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public String getPathDescarga() {
        return pathDescarga;
    }

    public void setPathDescarga(String pathDescarga) {
        this.pathDescarga = pathDescarga;
    }
    
    
    
}

