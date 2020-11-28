package Servlets;

import AccesoBaseDatos.GestorCursos;
import Modelo.Curso;
import java.io.IOException;
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
            GestorCursos gestor = new GestorCursos();
            
            if (modo.equals("alta")) {
                request.setAttribute("titulo", "Alta de Curso");
                RequestDispatcher rd = request.getRequestDispatcher("/datosCurso.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                
                //Tomar parámetro idCurso, buscar en BD y devolver objeto Curso
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));                
                Curso cursoEdit = gestor.getCurso(idCurso);

                //Setear atributos y enviar petición
                request.setAttribute("titulo", "Editar Curso");
                request.setAttribute("curso", cursoEdit);
                RequestDispatcher rd = request.getRequestDispatcher("/datosCurso.jsp");
                rd.forward(request, response);
            } else if (modo.equals("cambiarEstado")) {
                
                //Tomar parámetro idCurso, buscar en BD y cambiar estado
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                // No llegué...
                Curso cursoEstado = gestor.getCurso(idCurso);
                request.setAttribute("titulo", "Estado de Curso");
                request.setAttribute("curso", cursoEstado);
                RequestDispatcher rd = request.getRequestDispatcher("/confirmaCurso.jsp");
                rd.forward(request, response);
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

        if (request.getSession().getAttribute("usr") != null) {
            //Codificar correctamente los caracteres enviados a la BD
            request.setCharacterEncoding("UTF-8");
            GestorCursos gestor = new GestorCursos();

            if(request.getParameter("cambiarEstado") != null) {
                //Tomar sólo los parámetros que se usarán
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
                
                //Invertir el estado del parámetro "activo" para eliminar o reactivar curso 
                gestor.cambiarEstadoCurso(idCurso, !activo);
            } else {
                //Tomar parámetros del form y crear objeto Curso
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                float costo = Float.parseFloat(request.getParameter("costo"));            
                String imagenUrl = request.getParameter("imagenUrl");
                boolean activo = Boolean.parseBoolean(request.getParameter("activo"));            
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));

                Curso curso = new Curso(idCurso, nombre, descripcion, costo, imagenUrl, activo);                

                //Chequear si viene desde la opción Alta o Editar y llamar al método correspondiente
                if (idCurso == 0) {
                    gestor.agregarCurso(curso);
                } else {                
                    gestor.modificarCurso(curso);
                }
            }
            //Redirigir al Listado por GET
            response.sendRedirect(getServletContext().getContextPath() + "/ListadoCursos?modo=listadoAdmin");
        
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
