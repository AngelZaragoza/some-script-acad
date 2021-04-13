
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>
    <body>
        <%@include file="includes/menu.jsp" %>
        <jsp:useBean id="curso" class="Modelo.Curso" scope="session"></jsp:useBean>
        <%-- Crear una variable que chequea el estado del objeto para "poner" la acción en texto --%>
        <c:set var="accion" value="Eliminar" scope="request"></c:set>
        <c:if test="${not curso.activo}">
            <c:set var="accion" value="Reactivar" scope="request"></c:set>
        </c:if>               
        <br>
        <div class="container shadow-sm p-3 mb-5 fondo-semitransp rounded" data-aos="fade-in">
            <div class="row justify-content-center">
                <div class="col col-lg-6">
                    <h3 class="text-center">Cambio de ${titulo} </h3>                
                    <h4 class="text-center">${accion} el siguiente Curso? </h4>
                </div>
            </div>
        </div>
        <hr>
        <div class="container" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col col-lg-6 shadow p-3 mb-5 fondo-semitransp rounded">
                    <form id="cambiar" action="ABMCurso?cambiarEstado" method="post">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <label for="idCurso" class="col-form-label">Id. Curso:</label>
                                    <input type="text" class="form-control" id="idCurso"
                                           name="idCurso" value="${curso.idCurso}" readonly/>
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <div class="form-group">
                                    <label for="nombre" class="col-form-label">Nombre del Curso:</label>
                                    <input type="text" class="form-control" id="nombre"
                                           name="nombre" value="${curso.nombre}" readonly/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <label for="costo" class="col-form-label">Costo:</label>
                                    <input type="text" class="form-control" id="costo"
                                           name="costo" value="${curso.costo}" readonly/>
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <div class="form-group">
                                    <label for="nombre" class="col-form-label">Descripción:</label>
                                    <textarea class="form-control" id="descripcion" rows="4"
                                              name="descripcion" disabled>${curso.descripcion}</textarea>
                                </div>
                            </div>
                        </div>
                        
                        <input type="hidden" name="activo" value="${curso.activo}"/>
                        
                        <input type="submit" class="btn btn-primary btn-block" value="${accion}">
                    </form>
                </div>
            </div>
        </div>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
