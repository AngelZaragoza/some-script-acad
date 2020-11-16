
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>    
    <body>
        <%@include file="includes/menu.jsp" %>
        <br>
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-in">
            <div class="row justify-content-center">
                <h3 class="text-center">Cursos disponibles en la Academia SomeScript</h3>
            </div>
        </div>
        <div class="container" data-aos="fade-up">
            <div class="row" data-aos-delay="100">
                <div class="card-deck">
                    
                    <c:forEach var="curso" items="${lista}">                    
                        <div class="col-lg-4 col-md-6">
                            <div class="card fondo-semitransp">
                                <div class="card-body">
                                    <img src="${curso.imagenUrl}" class="card-img-top">
                                    <h4 class="card-title text-center bg-secondary text-white border-light mb-3">${curso.nombre}</h4>
                                    <p class="card-text">${curso.descripcion}</p>                                
                                </div>
                                <div class="card-footer">
                                    <p class="h4">Costo: $ ${curso.costo}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div> 

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
