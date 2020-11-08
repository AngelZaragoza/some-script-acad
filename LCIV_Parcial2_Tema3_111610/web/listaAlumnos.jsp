
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        <br>
        <div class="container shadow-sm p-3 mb-5 bg-white rounded" data-aos="fade-in">
            <div class="row justify-content-center">
                <h3 class="">Listado de Alumnos Cargados</h3>
            </div>
        </div>        
        <hr>
        <div class="container" data-aos="fade-up">
            <table class="table table-hover">
                <thead class="thead-light">
                    <th>Apellido</th>
                    <th>Nombre</th>
                    <th>Legajo</th>
                    <th>Correo Electrónico</th>
                    <th>Dirección</th>
                    <th>Fecha Nacimiento</th>
                    <th>Estado</th>
                    <th colspan="2">Acciones</th>
                </thead>
                <tbody>
                    <c:forEach var="alumno" items="${lista}">
                        <tr>
                            <td>${alumno.apellido}</td>
                            <td>${alumno.nombre}</td>
                            <td>${alumno.legajo}</td>
                            <td>${alumno.email}</td>
                            <td>${alumno.direccion}</td>
                            <td>${alumno.fechaNac}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${alumno.activo}">Activo</c:when>
                                    <c:when test="${not alumno.activo}">De Baja</c:when>
                                </c:choose>
                            </td>
                            <td>
                                <a href="ABMAlumno?modo=editar&idAlumno=${alumno.idAlumno}"
                                   class="btn btn-success"> Editar </a>
                            </td>
                            <td>
                                <a href="#"
                                   class="btn btn-outline-danger">Eliminar</a>
                            </td>                            
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
        </div>
        <%@include file="includes/footer.jsp" %>    
    </body>
</html>
