package Modelo;

import DTO.DTOComboAlumnos;
import DTO.DTOComboCursos;
import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class VMCombosInscripcion {
    public ArrayList<DTOComboAlumnos> listaAlumnos;
    public ArrayList<DTOComboCursos> listaCursos;
    public ArrayList<Descuento> listaDescuentos;

    // CONSTRUCTOR
    
    public VMCombosInscripcion() {
        listaAlumnos = null;
        listaCursos = null;
        listaDescuentos = null;
    }

    public ArrayList<DTOComboAlumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public ArrayList<DTOComboCursos> getListaCursos() {
        return listaCursos;
    }

    public ArrayList<Descuento> getListaDescuentos() {
        return listaDescuentos;
    }
    
    
    
}
