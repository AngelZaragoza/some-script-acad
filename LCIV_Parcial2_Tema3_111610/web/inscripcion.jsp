
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    </head>
    <body onload="saludo();">
        <%@include file="includes/menu.jsp" %>
        <jsp:useBean id="combos" class="Modelo.VMCombosInscripcion" scope="request"></jsp:useBean>
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
                    <form id="inscripciones" method="post" action="Inscripciones">
                        <!-- <input type="hidden" name="idInscripcion" value="${alumno.idAlumno}"/> -->
                        <div class="form-group">                            
                            <label for="curso" class="col-form-label">Curso:</label>
                            <select class="form-control" name="idCurso" id="curso">
                                <option value="0">Seleccione un Curso...</option>
                                <c:forEach var="cur" items="${combos.listaCursos}">
                                    <option value="${cur.idCurso}">${cur.nombreCurso}</option>
                                </c:forEach>
                            </select>
                            <div class="validate"></div>
                        </div>
                        <div class="form-group">
                            <label for="alumno" class="col-form-label">Alumno:</label>                
                            <select class="form-control" name="idAlumno" id="alumno">
                                <option value="0">Seleccione un Alumno...</option>
                                <c:forEach var="alu" items="${combos.listaAlumnos}">
                                    <option value="${alu.idAlumno}">${alu.nombreCompleto}</option>
                                </c:forEach>
                            </select>
                            <div class="validate"></div>
                        </div>
                        
                        <div class="form-group row">
                            <div class="col-sm-8">
                                <label for="descuento" class="col-form-label">Descuento:</label>
                                <select class="form-control" name="idDescuento" id="descuento">
                                    <option value="0">Seleccione un Descuento...</option>
                                    <c:forEach var="desc" items="${combos.listaDescuentos}">
                                        <option value="${desc.idDescuento}">${desc.descripcion}</option>
                                    </c:forEach>
                                </select>
                                <div class="validate"></div>
                            </div>
                            <div class="col-sm-4">
                                <label for="fechaInscripcion" class="col-form-label">Fecha de Inscripción:</label>                
                                <input type="date" class="form-control" id="fechaInscripcion"
                                       name="fechaInscripcion"
                                       required/>
                                <div class="validate"></div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-6">                            
                                <label for="calc-desc" class="col-form-label">Importe a Descontar:</label>
                                <input type="text" class="form-control" id="calc-desc" value="" readonly>
                            </div>
                            <div class="col-sm-6">                            
                                <label for="calc-neto" class="col-form-label">Importe Neto a Cobrar:</label>
                                <input type="text" class="form-control" id="calc-neto" value="" readonly>
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
