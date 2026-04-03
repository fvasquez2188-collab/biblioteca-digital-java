<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Biblioteca Digital - Login</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/estilos.css">

    <!-- Responsive -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="container">

    <h1>📚 Biblioteca Digital</h1>
    <h3>Iniciar Sesión</h3>

    <form action="LoginServlet" method="post">

        <input 
            type="text" 
            name="usuario" 
            placeholder="Usuario"
            required
        >

        <input 
            type="password" 
            name="password" 
            placeholder="Contraseña"
            required
        >

        <button type="submit">
            Ingresar
        </button>

    </form>

    <br>

    <% 
        String error = request.getParameter("error");
        if(error != null){
    %>

        <p style="color:red;">
            Usuario o contraseña incorrectos
        </p>

    <% } %>

</div>

</body>
</html>