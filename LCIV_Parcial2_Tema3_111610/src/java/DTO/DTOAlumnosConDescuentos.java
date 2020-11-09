package DTO;

/**
 *
 * @author Angel
 */
public class DTOAlumnosConDescuentos {
    private String apellido;
    private String nombre;
    private String legajo;

    public DTOAlumnosConDescuentos() {
    }

    public DTOAlumnosConDescuentos(String apellido, String nombre, String legajo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }
    
    
    
}
