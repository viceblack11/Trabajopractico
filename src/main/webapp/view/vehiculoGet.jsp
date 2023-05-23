<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Registro de Vehículo</h1>
        <form action="<%= request.getContextPath()%>/VehiculoServlet" method="GET">
            <label>ID:</label>
            <input type="text" name="id">
            <br>
            <label>Marca:</label>
            <input type="text" name="marca">
            <br>
            <label>Color:</label>
            <input type="text" name="color">
            <br>
            <label>Modelo:</label>
            <input type="text" name="modelo">
            <br>
            <label>Tipo:</label>
            <input type="text" name="tipo">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
