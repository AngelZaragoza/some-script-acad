
package Servlets;

import AccesoBaseDatos.GestorCursos;
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
@WebServlet(name = "ListadoCursos", urlPatterns = {"/ListadoCursos"})
public class ListadoCursos extends HttpServlet {


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
        
        //Declarar variables y objetos a utilizar
        String modo = request.getParameter("modo");
        ArrayList<Curso> lista;
        GestorCursos gestor = new GestorCursos();
        
        //Chequear si la solicitud viene de un invitado o de un admin
        if (modo.equals("listadoAdmin")) {        
            if (request.getSession().getAttribute("usr") != null) {                
                
                //El parámetro "false" indica que la petición *NO* es de un Invitado
                lista = gestor.listarCursos(false);
                request.setAttribute("lista", lista);
                request.setAttribute("titulo", "Listado de Cursos");
                RequestDispatcher rd = request.getRequestDispatcher("/listaCursos.jsp");
                rd.forward(request, response);
            } else {
                request.getSession().setAttribute("mensajeError", "Error. Sesión no iniciada");
                RequestDispatcher rd = request.getRequestDispatcher("/Login");
                rd.forward(request, response);
            }
        } else if (modo.equals("listadoPublico")) {
            
            //El parámetro "true" indica que la petición *ES* de un Invitado
            lista = gestor.listarCursos(true);
            request.setAttribute("lista", lista);
            request.setAttribute("titulo", "Cursos Disponibles");
            RequestDispatcher rd = request.getRequestDispatcher("/invitadoCursos.jsp");
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
