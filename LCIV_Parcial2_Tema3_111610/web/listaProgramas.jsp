
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
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-in">
            <div class="row justify-content-center">
                <h3 class="text-center">Listado de Programas subidos por Alumnos</h3>
            </div>
        </div>
        <hr>
        
        <div class="container" data-aos="fade-up">
            <table class="table table-responsive table-hover">
                <thead class="thead-light">
                    <th>ID</th>
                    <th>Nombre del Autor</th>
                    <th>Nombre del Programa</th>
                    <th>Descripción del Programa</th>
                    <th>Veces descargado</th>
                    <th>Link Descarga:</th>
                    <!-- <th>Estado</th>
                    <th colspan="2">Acciones</th> -->
                </thead>
                <tbody class="fondo-semitransp">
                    <c:forEach var="prog" items="${lista}">
                        <tr>
                            <td>${prog.idPrograma}</td>
                            <td>${prog.nombreAutor}</td>
                            <td>${prog.nombrePrograma}</td>
                            <td>${prog.descripcionPrograma}</td>
                            <td>${prog.cantidadDescargas}</td>
                            <td>
                                <a href="Programas?modo=descargar&idPrograma=${prog.idPrograma}"
                                    class="btn btn-success btn-block">Descargar</a>
                            </td>                            
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
        </div>
        <%@include file="includes/footer.jsp" %>    
    </body>
</html>
