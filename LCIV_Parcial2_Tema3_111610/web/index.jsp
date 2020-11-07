
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
        <div class="container" data-aos="fade-left">
            <div class="row justify-content-center">
                <h1>Bienvenido a la Academia</h1>
            </div>
        </div>
        <h4>${usr}</h4>
        <hr>
                
        <p data-aos="fade-up">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit
                Asperiores dolores sed et. Tenetur quia eos. Autem tempore quibusdam vel necessitatibus optio ad corporis.
        </p>
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
