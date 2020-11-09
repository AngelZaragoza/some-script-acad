package DTO;

/**
 *
 * @author Angel
 */
public class DTOMontosInscripcion {
    private float costoCurso;
    private int porcentDescuento;
    
    // CONSTRUCTORES

    public DTOMontosInscripcion() {}

    public DTOMontosInscripcion(float costoCurso, int porcentDescuento) {
        this.costoCurso = costoCurso;
        this.porcentDescuento = porcentDescuento;
    }
    
    // GETTERS

    public float getCostoCurso() {
        return costoCurso;
    }

    public int getPorcentDescuento() {
        return porcentDescuento;
    }
    
    
}
