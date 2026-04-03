<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Listado de Libros</title>

<link rel="stylesheet" href="css/estilos.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

<div class="container">

<h1>📚 Biblioteca Digital</h1>

<h2>Lista de Libros</h2>

<table>

<tr>
<th>ID</th>
<th>Título</th>
<th>Autor</th>
<th>Disponible</th>
</tr>

<c:forEach var="libro" items="${libros}">

<tr>
<td>${libro.id}</td>
<td>${libro.titulo}</td>
<td>${libro.autor}</td>
<td>${libro.disponible}</td>
</tr>

</c:forEach>

</table>

</div>

</body>
</html>