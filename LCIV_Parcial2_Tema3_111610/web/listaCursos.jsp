
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
                <h3 class="">Listado de Cursos Cargados</h3>
            </div>
        </div>        
        <hr>
        <div class="container" data-aos="fade-up">
            <table class="table table-hover">
                <thead class="thead-light">
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Costo</th>
                    <th>Estado</th>                    
                    <th colspan="2">Acciones</th>
                    <th>Imagen</th>
                </thead>
                <tbody>
                    <c:forEach var="curso" items="${lista}">
                        <tr>
                            <td>${curso.nombre}</td>
                            <td>${curso.descripcion}</td>
                            <td>${curso.costo}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${curso.activo}">Activo</c:when>
                                    <c:when test="${not curso.activo}">De Baja</c:when>
                                </c:choose>
                            </td>                            
                            <td>
                                <a href="ABMCurso?modo=editar&idCurso=${curso.idCurso}"
                                   class="btn btn-success btn-block">Editar Info</a>
                                <br>
                                <a href="Reportes?categ=aluCurso&idCurso=${curso.idCurso}&curso=${curso.nombre}"
                                   class="btn btn-info btn-block">Ver Inscriptos</a>
                            </td>
                            <td>
                                <a href="#"
                                   class="btn btn-outline-danger">Eliminar Curso</a>
                            </td>
                            <td><img src="${curso.imagenUrl}" class="img-fluid"></a></td>
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
        </div>
        <%@include file="includes/footer.jsp" %>    
    </body>
</html>
