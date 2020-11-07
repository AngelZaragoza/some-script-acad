
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
        <div class="container" data-aos="fade-in">
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
                    <th>Activo</th>
                    <th colspan="2">Acciones</th>
                </thead>
                <tbody>
                    <c:forEach var="curso" items="${lista}">
                        <tr>
                            <td>${curso.nombre}</td>
                            <td>${curso.descripcion}</td>
                            <td>${curso.costo}</td>
                            <td>${curso.activo}</td>
                            <td><a href="ABMCurso?modo=editar&idCurso=${curso.idCurso}">Editar</a></td>
                            <td><img src="${curso.imagenUrl}" class="img-fluid"></a></td>
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
        </div>
        <%@include file="includes/footer.jsp" %>    
    </body>
</html>
