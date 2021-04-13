
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>
    <body onload="saludo();">
        <%@include file="includes/menu.jsp" %>
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
                    <form id="programas" method="post" enctype="multipart/form-data">                        
                        <div class="form-group">                            
                            <label for="alumno" class="col-form-label">Alumno:</label>
                            <select class="form-control" name="idAlumno" id="alumno">
                                <option value="0">Seleccione un Alumno...</option>
                                <c:forEach var="cur" items="${listaAlumnos}">
                                    <option value="${cur.idAlumno}">${cur.nombreCompleto}</option>
                                </c:forEach>
                            </select>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">
                            <label for="programa" class="col-form-label">Nombre del Programa:</label>                
                            <input type="text" class="form-control" id="programa"
                                   name="nombrePrograma" required                                    
                                   placeholder="Nombre o Título"/>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion" class="col-form-label">Descripción del Programa:</label>
                            <textarea class="form-control" id="descripcion"
                                      name="descripcion"
                                      rows="3" required
                                      placeholder="Características del programa o app"></textarea>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">                            
                                <label for="archivo" class="col-form-label">Seleccione el archivo a subir (máximo 5 MB):</label>
                                <input type="file" class="form-control" id="archivo"
                                       name="archivo" required/>
                                <div class="validate"></div>                            
                        </div>                        
                        <div class="form-row">                            
                            <div class="col-sm-6">
                                <div class="form-check">                                    
                                    <input type="checkbox" class="form-check-input" id="descarga"
                                       name="permiteDescarga" checked/>
                                    <label for="descarga" class="form-check-label">Descarga pública disponible?</label>
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
