package Servlets;

import AccesoBaseDatos.GestorAlumnos;
import Modelo.Alumno;
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
@WebServlet(name = "ABMAlumno", urlPatterns = {"/ABMAlumno"})
public class ABMAlumno extends HttpServlet {
    
    
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
                request.setAttribute("titulo", "Alta de Alumno");
                RequestDispatcher rd = request.getRequestDispatcher("/datosAlumno.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                //Tomar parámetro idAlumno, buscar en BD y devolver objeto Alumno
                int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
                GestorAlumnos gestor = new GestorAlumnos();
                Alumno alumnoEdit = gestor.getAlumno(idAlumno);

                //Setear atributos y enviar petición
                request.setAttribute("titulo", "Editar Alumno");
                request.setAttribute("alumno", alumnoEdit);
                RequestDispatcher rd = request.getRequestDispatcher("/datosAlumno.jsp");
                rd.forward(request, response);
            } else if (modo.equals("cambiarEstado")) {
                //Tomar parámetro idCurso, buscar en BD y cambiar estado
                int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
                // No llegué...
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

            //Tomar parámetros del form y crear objeto Alumno
            String apellido = request.getParameter("apellido");
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String legajo = request.getParameter("legajo");
            String email = request.getParameter("email");
            String fechaNac = request.getParameter("fechaNac");
            boolean activo = Boolean.parseBoolean(request.getParameter("activo"));            

            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));

            Alumno alumno = new Alumno(idAlumno, legajo, apellido, nombre, direccion, email, fechaNac, activo);
            GestorAlumnos gestor = new GestorAlumnos();

            //Chequear si viene desde la opción Alta o Editar
            if (idAlumno == 0) {
                gestor.agregarAlumno(alumno);
            } else {                
                gestor.modificarAlumno(alumno);
            }

            //Redirigir al Listado por GET
            response.sendRedirect(getServletContext().getContextPath() + "/ListadoAlumnos");
        
        } else {            
            //Redirigir al Login por GET
            request.getSession().setAttribute("mensajeError", "Error. Sesión no iniciada");
            response.sendRedirect(getServletContext().getContextPath() + "/Login");
            //RequestDispatcher rd = request.getRequestDispatcher("/Login");
            //rd.forward(request, response);
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
