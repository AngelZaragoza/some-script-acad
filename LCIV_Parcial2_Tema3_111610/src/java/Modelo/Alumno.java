package Modelo;

/**
 *
 * @author Angel
 */
public class Alumno {
    private int idAlumno;
    private String legajo;
    private String apellido;
    private String nombre;
    private String direccion;
    private String email;
    private String fechaNac;
    private boolean activo;
    
    // CONSTRUCTORES

    public Alumno() {}

    public Alumno(int idAlumno, String legajo, String apellido, String nombre, String direccion, String email, String fechaNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
    
    // GETTERS Y SETTERS

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
