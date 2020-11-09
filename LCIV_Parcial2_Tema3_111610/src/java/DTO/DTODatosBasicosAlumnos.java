package DTO;

/**
 *
 * @author Angel
 */
public class DTODatosBasicosAlumnos {
    private String apellido;
    private String nombre;
    private String legajo;

    public DTODatosBasicosAlumnos() {
    }

    public DTODatosBasicosAlumnos(String apellido, String nombre, String legajo) {
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
