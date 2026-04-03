<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Prestamo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Préstamos</title>

    <link rel="stylesheet" href="css/estilos.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>

<h1>📚 Gestión de Préstamos</h1>

<!-- 📝 FORMULARIO -->
<form action="../PrestamoServlet" method="post">

    <label>ID Usuario:</label>
    <input type="number" name="idUsuario" required>

    <label>ID Libro:</label>
    <input type="number" name="idLibro" required>

    <label>Fecha Préstamo:</label>
    <input type="date" name="fechaPrestamo" required>

    <label>Fecha Devolución:</label>
    <input type="date" name="fechaDevolucion" required>

    <button type="submit">Registrar Préstamo</button>
</form>

<!-- 📋 TABLA -->
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Usuario</th>
            <th>Libro</th>
            <th>Fecha Préstamo</th>
            <th>Fecha Devolución</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>

    <%
        List<Prestamo> lista = (List<Prestamo>) request.getAttribute("lista");
        if (lista != null) {
            for (Prestamo p : lista) {
    %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getIdUsuario() %></td>
            <td><%= p.getIdLibro() %></td>
            <td><%= p.getFechaPrestamo() %></td>
            <td><%= p.getFechaDevolucion() %></td>
            <td>
                <a href="../PrestamoServlet?accion=eliminar&id=<%= p.getId() %>"
                   onclick="return confirm('¿Eliminar este préstamo?')">
                   Eliminar
                </a>
            </td>
        </tr>
    <%
            }
        }
    %>

    </tbody>
</table>

</body>
</html>