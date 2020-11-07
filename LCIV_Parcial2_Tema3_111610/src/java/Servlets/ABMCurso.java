package Servlets;

import AccesoBaseDatos.GestorCursos;
import Modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ABMCurso", urlPatterns = {"/ABMCurso"})
public class ABMCurso extends HttpServlet {

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
            String modo = request.getParameter("modo");
            if (modo.equals("alta")) {
                request.setAttribute("titulo", "Alta de Curso");
                RequestDispatcher rd = request.getRequestDispatcher("/datosCurso.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                //Tomar parámetro idCurso, buscar en BD y devolver objeto Curso
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                GestorCursos gestor = new GestorCursos();
                Curso cursoEdit = gestor.getCurso(idCurso);
                
                //Setear atributos y enviar petición
                request.setAttribute("titulo", "Editar Curso");
                request.setAttribute("curso", cursoEdit);
                RequestDispatcher rd = request.getRequestDispatcher("/datosCurso.jsp");
                rd.forward(request, response);
                try (PrintWriter out = response.getWriter()) {

                    out.print("<h1>OK</h1>");
                }
            }
        } else {
            request.setAttribute("mensajeError", "Error. Sesión no iniciada");
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

        //Codifica correctamente los caracteres enviados a la BD
        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        float costo = Float.parseFloat(request.getParameter("costo"));
        boolean activo = false;
        if (request.getParameter("activo") != null) {
            activo = true;
        }
        String imagenUrl = request.getParameter("imagenUrl");

        Curso nuevo = new Curso(0, nombre, descripcion, costo, imagenUrl, activo);
        GestorCursos gestor = new GestorCursos();
        gestor.agregarCurso(nuevo);

        response.sendRedirect(getServletContext().getContextPath() + "/MenuAdmin");
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
