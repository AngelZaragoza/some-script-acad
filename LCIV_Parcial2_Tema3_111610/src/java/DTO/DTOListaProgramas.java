package DTO;

/**
 *
 * @author Angel
 */
public class DTOListaProgramas {
    private String nombreAutor;
    private String nombrePrograma;
    private String descripcionPrograma;
    private int cantidadDescargas;

    public DTOListaProgramas() {
    }

    public DTOListaProgramas(String nombreAutor, String nombrePrograma, String descripcionPrograma, int cantidadDescargas) {
        this.nombreAutor = nombreAutor;
        this.nombrePrograma = nombrePrograma;
        this.descripcionPrograma = descripcionPrograma;
        this.cantidadDescargas = cantidadDescargas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public String getDescripcionPrograma() {
        return descripcionPrograma;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }
    
    
}
