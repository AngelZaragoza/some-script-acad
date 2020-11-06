
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <br>
        <h1>Bienvenido ${usr} ! </h1>
        <hr>
        <%@include file="includes/opcionesadmin.jsp" %>
        
        <a href="ABMCurso">Alta de Curso</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
