package DTO;

/**
 *
 * @author Angel
 */
public class DTOListaProgramas {
    private int idPrograma;
    private String nombreAutor;
    private String nombrePrograma;
    private String descripcionPrograma;
    private int cantidadDescargas;
    private String pathDescarga;

    public DTOListaProgramas() {
    }

    public DTOListaProgramas(int idPrograma, String nombreAutor, String nombrePrograma,
            String descripcionPrograma, int cantidadDescargas, String pathDescarga) {
        this.idPrograma = idPrograma;
        this.nombreAutor = nombreAutor;
        this.nombrePrograma = nombrePrograma;
        this.descripcionPrograma = descripcionPrograma;
        this.cantidadDescargas = cantidadDescargas;
        this.pathDescarga = pathDescarga;
    }

    public int getIdPrograma() {
        return idPrograma;
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

    public String getPathDescarga() {
        return pathDescarga;
    }
    
    
}
