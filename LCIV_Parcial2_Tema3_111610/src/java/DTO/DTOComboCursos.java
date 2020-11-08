package DTO;

/**
 *
 * @author Angel
 */
public class DTOComboCursos {
    private int idCurso;
    private String nombreCurso;
    
    // CONSTRUCTORES
    
    public DTOComboCursos() {}

    public DTOComboCursos(int idCurso, String nombreCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
    }
    
    // GETTERS

    public int getIdCurso() {
        return idCurso;
    }    

    public String getNombreCurso() {
        return nombreCurso;
    }    
    
    
}
