
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--<title>LCIV - Academia</title>-->
        <%@include file="header.jsp" %>
    </head>
    <body onload="saludo();">
        <div class="container" data-aos="fade-in">
            <div class="row justify-content-center text-center">
                <div class="col col-lg-6">
                    <h2 id="saludo"></h2>
                    <h3>Introduzca su información de Login</h3>
                    <%if (request.getAttribute("mensajeError") != null
                                && !request.getAttribute("mensajeError").equals("")) { %>
                    <br/>
                    <h4> ${mensajeError} </h4>
                    <br/>
                    <%
                        }
                    %>
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
                        <div>                            
                            <input type="submit" value="Verificar">
                            <button type="submit">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                
        <%@include file="footer.jsp" %>
    </body>
</html>
