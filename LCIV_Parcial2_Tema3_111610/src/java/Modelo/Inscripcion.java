package Modelo;

/**
 *
 * @author Angel
 */
public class Inscripcion {
    private int idInscripcion;
    private int idAlumno;
    private int idCurso;
    private int idDescuento;
    private String fechaInscripcion;
    private float montoDescuento;
    private float montoAbonado;
    
    // CONSTRUCTORES

    public Inscripcion(int idInscripcion, int idAlumno, int idCurso, int idDescuento, String fechaInscripcion, float montoDescuento, float montoAbonado) {
        this.idInscripcion = idInscripcion;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.idDescuento = idDescuento;
        this.fechaInscripcion = fechaInscripcion;
        this.montoDescuento = montoDescuento;
        this.montoAbonado = montoAbonado;
    }
    
    //GETTERS Y SETTERS

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public float getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(float montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public float getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(float montoAbonado) {
        this.montoAbonado = montoAbonado;
    }
    
    
}
