package DTO;

/**
 *
 * @author Angel
 */
public class DTOComboCursos {
    private int idCurso;
    private String nombreCurso;
    private float costo;
    
    // CONSTRUCTORES
    
    public DTOComboCursos() {}

    public DTOComboCursos(int idCurso, String nombreCurso, float costo) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.costo = costo;
    }
    
    // GETTERS

    public int getIdCurso() {
        return idCurso;
    }    

    public String getNombreCurso() {
        return nombreCurso;
    }    

    public float getCosto() {
        return costo;
    }    
    
}
