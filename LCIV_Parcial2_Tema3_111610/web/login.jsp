
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>        
        <%@include file="includes/header.jsp" %>
    </head>
    <body onload="saludo();">
        <%@include file="includes/menu.jsp" %>
        <div class="container" data-aos="fade-in">
            <div class="row justify-content-center text-center">
                <div class="col col-lg-6">
                    <h2 id="saludo"></h2>
                    <h3>Introduzca su información de Login</h3>
                    <c:if test="${not empty mensajeError}">
                        <h4> ${mensajeError} </h4>
                    </c:if>
                    
                </div>
            </div>
        </div>


        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col col-lg-6">
                    <form id="login" method="post" action="Login">
                        <div class="form-group">
                            <label for="user" class="col-form-label">Usuario:</label>                
                            <input type="text" class="form-control" id="user"
                                   name="txtUsuario" required 
                                   placeholder="Usuario"/>                               
                            <div class="validate"></div>
                        </div>

                        <div class="form-group">
                            <label for="pass" class="col-form-label">Password:</label>
                            <input type="password" class="form-control" id="pass"
                                   name="txtPassword" required
                                   placeholder="Password"/>
                            <div class="validate"></div>
                        </div>                
                        <div class="col-sm-6">                            
                            <input type="submit" class="btn btn-primary btn-block" value="Verificar">                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
                
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
