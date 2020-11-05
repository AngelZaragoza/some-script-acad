package Modelo;

/**
 *
 * @author Angel
 */
public class Descuento {
    private int idDescuento;
    private String descripcion;
    private int porcentDescuento;
    
    // CONSTRUCTOR

    public Descuento(int idDescuento, String descripcion, int porcentDescuento) {
        this.idDescuento = idDescuento;
        this.descripcion = descripcion;
        this.porcentDescuento = porcentDescuento;
    }
    
    // GETTERS

    public int getIdDescuento() {
        return idDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPorcentDescuento() {
        return porcentDescuento;
    }    
    
}
