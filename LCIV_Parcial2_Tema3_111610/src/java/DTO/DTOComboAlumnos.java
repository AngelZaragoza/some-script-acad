package DTO;

/**
 *
 * @author Angel
 */
public class DTOComboAlumnos {
    private int idAlumno;
    private String nombreCompleto;
    
    // CONSTRUCTORES
    
    public DTOComboAlumnos() {}

    public DTOComboAlumnos(int idAlumno, String nombreCompleto) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
    }
    
    // GETTERS

    public int getIdAlumno() {
        return idAlumno;
    }    

    public String getNombreCompleto() {
        return nombreCompleto;
    }    
    
    
}
