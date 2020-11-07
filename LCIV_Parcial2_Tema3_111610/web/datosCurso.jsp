
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <%@include file="includes/header.jsp" %>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        <jsp:useBean id="curso" class="Modelo.Curso" scope="request"></jsp:useBean>
            <div class="container" data-aos="fade-in">
                <div class="row justify-content-center text-center">
                    <div class="col col-lg-6">
                        <h3>${titulo}</h3>
                    </div>
                </div>
            </div>

            <div class="container" data-aos="fade-up">
                <div class="row justify-content-center">
                    <div class="col col-lg-6">
                        <form id="cursos" method="post" action="ABMCurso">
                            <input type="hidden" name="idCurso" value="${curso.idCurso}"/>
                        <div class="form-group">
                            <label for="curso" class="col-form-label">Nombre del Curso:</label>                
                            <input type="text" class="form-control" id="curso"
                                   name="nombre" required 
                                   value="${curso.nombre}"
                                   placeholder="Curso"/>                      
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion" class="col-form-label">Descripción de contenidos:</label>
                            <textarea class="form-control" id="descripcion"
                                      name="descripcion"
                                      rows="3" required
                                      placeholder="Descripción">${curso.descripcion}</textarea>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6">
                                <label for="costo" class="col-form-label">Costo:</label>                
                                <input type="number" class="form-control" id="costo"
                                       name="costo" required
                                       value="${curso.costo}"/>
                                <div class="validate"></div>
                            </div>                            
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-4">
                                <label for="activo" class="form-check-label">Curso disponible?</label>                
                            </div>
                            <div class="col-sm">
                                <input type="checkbox" class="form-check-input" id="activo"
                                       name="activo"
                                       <c:if test="${curso.activo}">
                                        checked
                                       </c:if>
                                       />                                        
                            </div>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">
                            <label for="imagenUrl" class="col-form-label">URL Imagen (opcional):</label>                
                            <input type="text" class="form-control" id="imagenUrl"
                                   name="imagenUrl"
                                   value="${curso.imagenUrl}"/>
                            <div class="validate"></div>
                        </div>
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
