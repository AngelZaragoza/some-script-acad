
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
        <div class="container" data-aos="fade-left">
            <div class="row justify-content-center">
                <h3>${titulo}</h3>
            </div>
        </div>
        <div class="container shadow-sm p-3 mb-5 bg-white rounded" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col-sm-7">
                    <div class="card">
                        <h4 class="card-header text-center bg-info text-white">Lista de Alumnos beneficiados con algún Descuento</h4>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <th>Apellido</th>
                                    <th>Nombre</th>
                                    <th class="text-center">Legajo</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="lista" items="${descAlumnos}">
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
