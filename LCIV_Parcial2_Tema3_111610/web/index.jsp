

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header.jsp" %>
    </head>    
    <body>
        <%@include file="menu.jsp" %>
        <h1>Bienvenido a la academia</h1>
        
        <h4>${usr}</h4>
        <hr>
        <ul>
            <li>Inicio</li>
            <li>Cursos</li>
            <li>Descargas</li>
            <li>Contacto</li>
        </ul>
        
        <a href="Login">Login Admin</a>
        
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit
                Asperiores dolores sed et. Tenetur quia eos. Autem tempore quibusdam vel necessitatibus optio ad corporis.
        </p>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
