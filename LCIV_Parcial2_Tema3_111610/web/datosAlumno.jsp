
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        <jsp:useBean id="alumno" class="Modelo.Alumno" scope="request"></jsp:useBean>
        
        <br>
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-in">
            <div class="row justify-content-center text-center">
                <div class="col col-lg-6">
                    <h3>${titulo}</h3>
                </div>
            </div>
        </div>
                
        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col col-lg-6 shadow p-3 mb-5 fondo-semitransp rounded">
                    <form id="alumnos" method="post" action="ABMAlumno">
                        <input type="hidden" name="idAlumno" value="${alumno.idAlumno}"/>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <label for="apellido" class="col-form-label">Apellido:</label>                
                                <input type="text" class="form-control" id="apellido"
                                       name="apellido" required 
                                       value="${alumno.apellido}"
                                       placeholder="Apellido"/>                      
                                <div class="validate"></div>
                            </div>
                            <div class="col-sm-6">
                                <label for="nombre" class="col-form-label">Nombre:</label>                
                                <input type="text" class="form-control" id="nombre"
                                       name="nombre" required 
                                       value="${alumno.nombre}"
                                       placeholder="Nombre"/>                      
                                <div class="validate"></div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-8">
                                <label for="direccion" class="col-form-label">Dirección (opcional):</label>
                                <input type="text" class="form-control" id="direccion"
                                           name="direccion" 
                                           value="${alumno.direccion}"
                                           placeholder="Dirección"/>
                                <div class="validate"></div>
                            </div>
                            <div class="col-sm-4">
                                <label for="legajo" class="col-form-label">Legajo:</label>                
                                <input type="text" class="form-control" id="legajo"
                                       name="legajo" required
                                       value="${alumno.legajo}"
                                       placeholder="Legajo"/>
                                <div class="validate"></div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-8">
                                <label for="email" class="col-form-label">Correo Electrónico:</label>                
                                <input type="email" class="form-control" id="email"
                                       name="email"
                                       value="${alumno.email}"
                                       placeholder="E-Mail"/>
                                <div class="validate"></div>
                            </div>
                            <div class="col-sm-4">
                                <label for="fechaNac" class="col-form-label">Fecha de Nacimiento:</label>                
                                <input type="date" class="form-control" id="fechaNac"
                                       name="fechaNac"
                                       value="${alumno.fechaNac}"/>
                                <div class="validate"></div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                                <div class="form-check">                                    
                                    <input type="hidden" name="activo" 
                                        <c:if test="${alumno.idAlumno == 0}">value="true"</c:if>
                                        <c:if test="${alumno.idAlumno > 0}">value="${alumno.activo}"</c:if>/>
                                    <input type="checkbox" class="form-check-input" id="indicador"
                                        name="indicador" 
                                        <c:if test="${alumno.activo}">checked</c:if>
                                        <c:if test="${alumno.idAlumno == 0}">checked</c:if>
                                        disabled>
                                    <label for="indicador" class="form-check-label">Alumno activo?</label>
                                </div>
                                <div class="validate"></div>
                            </div>                            
                        </div>
                        <br>                        
                        <div class="form-group row">
                            <div class="col-sm-6">                            
                                <input type="submit" class="btn btn-primary btn-block" value="Guardar">                            
                            </div>
                            <div class="col-sm-6">                            
                                <input type="reset" class="btn btn-secondary btn-block" value="Cancelar">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>        
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
