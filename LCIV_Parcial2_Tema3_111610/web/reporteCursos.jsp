
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
                        <h4 class="card-header text-center bg-info text-white">Total Facturado por cada Curso</h4>
                        <div class="card-body fondo-semitransp">
                            <table class="table table-hover">
                                <thead>
                                    <th>Nombre del Curso</th>
                                    <th class="text-right">Facturación</th>
                                </thead>
                                <tbody>
                                    <c:forEach var="lista" items="${facturado}">
                                        <tr>
                                            <td>${lista.curso}</td>
                                            <td class="text-right">${lista.totalFacturado}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                            
                        </div>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="card">
                        <h4 class="card-header text-center bg-info text-white">Descuentos Realizados</h4>
                        <div class="card-body fondo-semitransp">                    
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item text-center">
                                    Total de Descuentos Otorgados:<br>
                                    <p><h4>$ ${descuentos} </h4></p>
                                </li>                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
