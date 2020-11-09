package DTO;

/**
 *
 * @author Angel
 */
public class DTOFacturacionPorCurso {
    private String curso;
    private float totalFacturado;

    public DTOFacturacionPorCurso() {
    }

    public DTOFacturacionPorCurso(String curso, float totalFacturado) {
        this.curso = curso;
        this.totalFacturado = totalFacturado;
    }

    public String getCurso() {
        return curso;
    }

    public float getTotalFacturado() {
        return totalFacturado;
    }
    
    
}
