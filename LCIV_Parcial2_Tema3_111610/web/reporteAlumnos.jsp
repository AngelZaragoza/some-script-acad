
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        
        <br>
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-left">
            <div class="row justify-content-center">
                <h3>${titulo}</h3>
            </div>
        </div>
        <hr>
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col-sm-7">
                    <div class="card">
                        <h4 class="card-header text-center bg-info text-white">
                            <%-- Muestra un título u otro dependiendo desde viene la petición --%>
                            <c:choose>
                                <c:when test="${not empty nombreCurso}">
                                    ${nombreCurso}: Lista de Alumnos
                                </c:when>
                                <c:otherwise>
                                    Lista de Alumnos beneficiados con algún Descuento
                                </c:otherwise>
                            </c:choose>
                        </h4>
                        <div class="card-body fondo-semitransp">
                            <table class="table table-hover">
                                <thead>                                    
                                    <th>Apellido</th>
                                    <th>Nombre</th>
                                    <th class="text-center">Legajo</th>
                                </thead>
                                <tbody class="fondo-semitransp">                                    
                                    <c:forEach var="lista" items="${listaAlumnos}">
                                        <tr>                                            
                                            <td>${lista.apellido}</td>
                                            <td>${lista.nombre}</td>
                                            <td class="text-center">${lista.legajo}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>                
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
