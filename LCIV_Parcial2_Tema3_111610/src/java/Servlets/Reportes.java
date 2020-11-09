package Servlets;

import AccesoBaseDatos.*;
import DTO.*;
import Modelo.Curso;
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
@WebServlet(name = "Reportes", urlPatterns = {"/Reportes"})
public class Reportes extends HttpServlet {

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
            
            //Codificar correctamente los caracteres enviados a la BD
            request.setCharacterEncoding("UTF-8");
            String categ = request.getParameter("categ");
            
            //Crear Objetos a usar dependiendo del caso
            GestorReportes gestor = new GestorReportes();
            ArrayList<DTODatosBasicosAlumnos> listaAlumnos;
            RequestDispatcher rd;
            
            switch (categ) {
                case "cursos":
                    //Consultar en BD y devolver datos para el reporte                
                    ArrayList<DTOFacturacionPorCurso> facturado = gestor.totalFactPorCurso();
                    float totalDescuentos = gestor.totalDescuentos();

                    //Setear atributos y enviar petición
                    request.setAttribute("facturado", facturado);
                    request.setAttribute("descuentos", totalDescuentos);
                    request.setAttribute("titulo", "Reportes sobre Cursos");
                    rd = request.getRequestDispatcher("/reporteCursos.jsp");
                    rd.forward(request, response);
                    break;
                
                case "descuentos":
                    //Consultar en BD y devolver datos para el reporte
                    listaAlumnos = gestor.alumnosConDescuentos();

                    //Setear atributos y enviar petición
                    request.setAttribute("titulo", "Reportes sobre Descuentos");
                    request.setAttribute("listaAlumnos", listaAlumnos);
                    rd = request.getRequestDispatcher("/reporteAlumnos.jsp");
                    rd.forward(request, response);
                    break;
                
                case "aluCurso":
                    //Consultar en BD y devolver datos para el reporte
                    int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                    String nombreCurso = request.getParameter("curso");
                    listaAlumnos = gestor.alumnosPorCurso(idCurso);

                    //Setear atributos y enviar petición
                    request.setAttribute("titulo", "Alumnos por Curso");
                    request.setAttribute("nombreCurso", nombreCurso);
                    request.setAttribute("listaAlumnos", listaAlumnos);
                    rd = request.getRequestDispatcher("/reporteAlumnos.jsp");
                    rd.forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
            }            

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

        //NADA POR AHORA
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
