
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
                <h1>Bienvenido ${usr} </h1>
            </div>
        </div>
        <hr>
        <%@include file="includes/opcionesadmin.jsp" %>        
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
