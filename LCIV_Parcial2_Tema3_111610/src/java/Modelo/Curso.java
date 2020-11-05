
package Modelo;

/**
 *
 * @author Angel
 */
public class Curso {
    private int idCurso;
    private String nombre;
    private String descripcion;
    private float costo;
    private String imagenUrl;
    private boolean activo; 

    //CONSTRUCTORES

    public Curso() {}

    
    public Curso(int idCurso, String nombre, String descripcion, float costo, String imagenUrl, boolean activo) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.imagenUrl = imagenUrl;
        this.activo = activo;
    }
    
    //GETTERS Y SETTERS
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
