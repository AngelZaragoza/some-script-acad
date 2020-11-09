<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <a class="navbar-brand" href="index.jsp">Inicio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">        
        <ul class="navbar-nav">            
            <li class="nav-item">
                <a class="nav-link" href="#">Cursos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Programas?modo=listadoPublico">Lista de Descargas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contacto</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Drop Down</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Drop Down 2</a>
                    <a class="dropdown-item" href="#">Drop Down 3</a>
                    <a class="dropdown-item" href="#">Drop Down 4</a>
                </div>
            </li>            
        </ul>

    </div>
    <c:choose>
        <c:when test="${not empty usr}">
            <div class="nav-item justify-content-end">        
                <a class="nav-link btn btn-outline-light justify-content-end" href="MenuAdmin">${usr}: Menú Administrador</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="nav-item justify-content-end">        
                <a class="nav-link btn btn-outline-light justify-content-end" href="Login">Login</a>
            </div>
        </c:otherwise>
    </c:choose>    
</nav>
