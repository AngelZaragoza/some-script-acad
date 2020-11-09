package Servlets;

import AccesoBaseDatos.GestorBD;
import DTO.DTOComboAlumnos;
import Modelo.Programa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Angel
 */
@WebServlet(name = "Programas", urlPatterns = {"/Programas"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "D:\\GIT\\lciv---parcial-2-AngelZaragoza\\LCIV_Parcial2_Tema3_111610\\web\\uploads"
)
public class Programas extends HttpServlet {

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
            
            //Buscar en BD y devolver lista de Alumnos
            GestorBD gestor = new GestorBD();
            ArrayList<DTOComboAlumnos> combo = gestor.listaAlumnos();
            
            //Setear atributos y enviar petición
            request.setAttribute("titulo", "Subir un Programa");
            request.setAttribute("listaAlumnos", combo);
            RequestDispatcher rd = request.getRequestDispatcher("/datosPrograma.jsp");
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

            //Tomar parámetros del form 
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            String nombrePrograma = request.getParameter("nombrePrograma");
            String descripcion = request.getParameter("descripcion");
            boolean permiteDescarga = false;
            if (request.getParameter("permiteDescarga") != null && request.getParameter("permiteDescarga").equals("on")) {
                permiteDescarga = true;
            }
            
            //Almacenar el path relativo
            String pathDescarga = getServletContext().getContextPath() + "/web/uploads/";

            //Leer el archivo subido y almacenarlo
            for (Part part : request.getParts()) {
                String fileName = getFileName(part);
                if (!fileName.isEmpty()) {
                    fileName = nombrePrograma + "_" + idAlumno + "_" + fileName;
                    pathDescarga += fileName;
                    part.write(fileName);
                }
            }
            
            //Guardar los datos del upload en la BD
            Programa nuevo = new Programa(0, idAlumno, nombrePrograma, descripcion, permiteDescarga, 0, pathDescarga);
            GestorBD gestor = new GestorBD();
            gestor.subirPrograma(nuevo);
            
            //Redirigir al Menú por GET
            response.sendRedirect(getServletContext().getContextPath() + "/MenuAdmin");

        } else {
            //Redirigir al Login por GET
            request.getSession().setAttribute("mensajeError", "Error. Sesión no iniciada");
            response.sendRedirect(getServletContext().getContextPath() + "/Login");

        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
