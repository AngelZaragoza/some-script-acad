package Servlets;

import Modelo.VMCombosInscripcion;
import AccesoBaseDatos.*;
import DTO.DTOMontosInscripcion;
import Modelo.Inscripcion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel
 */
@WebServlet(name = "Inscripciones", urlPatterns = {"/Inscripciones"})
public class Inscripciones extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usr") != null) {
            
            //Buscar en BD y devolver VM con listas para los combos
            GestorBD gestor = new GestorBD();            
            VMCombosInscripcion combos = new VMCombosInscripcion();
            combos.listaAlumnos = gestor.listaAlumnos();
            combos.listaCursos = gestor.listaCursos();
            combos.listaDescuentos = gestor.listaDescuentos();
            
            //Setear atributos y enviar petición
            request.setAttribute("titulo", "Alta de Inscripción");
            request.setAttribute("combos", combos);
            RequestDispatcher rd = request.getRequestDispatcher("/inscripcion.jsp");
            rd.forward(request, response);            
            
        } else {
            request.getSession().setAttribute("mensajeError", "Error. Sesión no iniciada");
            RequestDispatcher rd = request.getRequestDispatcher("/Login");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usr") != null) {
            //Codificar correctamente los caracteres enviados a la BD
            request.setCharacterEncoding("UTF-8");
            
            //Tomar parámetros del form y tomar montos de la BD
            int idCurso = Integer.parseInt(request.getParameter("idCurso"));
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            int idDescuento = Integer.parseInt(request.getParameter("idDescuento"));            
            String fechaInscripcion = request.getParameter("fechaInscripcion");            
            
            GestorBD gestor = new GestorBD();
            DTOMontosInscripcion montos = gestor.montosInscripcion(idCurso, idDescuento);
            float montoDescuento = (montos.getCostoCurso() * montos.getPorcentDescuento())/100;
            float montoAbonado = (montos.getCostoCurso() - montoDescuento);
            
            //Crear objeto Inscripcion y agregar a la BD
            Inscripcion insc = new Inscripcion(0, idAlumno, idCurso, idDescuento, fechaInscripcion, montoDescuento, montoAbonado);            
            gestor.agregarInscripcion(insc);
            response.sendRedirect(getServletContext().getContextPath() + "/MenuAdmin");
            
        } else {            
            //Redirigir al Login por GET
            request.getSession().setAttribute("mensajeError", "Error. Sesión no iniciada");
            response.sendRedirect(getServletContext().getContextPath() + "/Login");            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
