<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">PV</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Vehículo</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1>Página de Registro de Vehículos</h1>
        <div class="container">
            <form action="<%= request.getContextPath() %>/VehiculoServlet?action=create" method="POST">
               
                <div class="mb-3">
                    <label for="marca" class="form-label">Marca:</label>
                    <input class="form-control" id="marca" placeholder="Introduzca marca" type="text" name="marca">
                </div>
                <br>
                <div class="mb-3">
                    <label for="color" class="form-label">Color:</label>
                    <input class="form-control" id="color" placeholder="Introduzca color" type="text" name="color">
                </div>
                <br>
                <div class="mb-3">
                    <label for="modelo" class="form-label">Modelo:</label>
                    <input class="form-control" id="modelo" placeholder="Introduzca modelo" type="text" name="modelo">
                </div>
                <br>
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo:</label>
                    <input class="form-control" id="tipo" placeholder="Introduzca tipo" type="text" name="tipo">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
    </body>
</html>

