package Modelo;

import DTO.DTOListaProgramas;
import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class VMProgramasSubidos {
    public ArrayList<DTOListaProgramas> datosProgramas;
    public ArrayList<Programa> listaProgramas;

    // CONSTRUCTOR
    
    public VMProgramasSubidos() {
        datosProgramas = null;
        listaProgramas = null;
    }

    public ArrayList<DTOListaProgramas> getDatosProgramas() {
        return datosProgramas;
    }

    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }
    
    
    
}
