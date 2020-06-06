<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
    <link rel="stylesheet" type="text/css" href="/webapp/style.css"><!-- HOJA DE ESTILOS-->
</head>
<body>
    
    <section id="login">
        <h1>Formulario de autenticación</h1>
        <form action="Login">
            <label>Usuario:</label>
            <s:textfield name="idUsuario" placeholder="Usuario"/> 
            <br>
            <br>
            <label>Contraseña:</label>
            <s:password name="password" placeholder="Contraseña"/> 
            <br>
            <br>
            <s:submit value="Validar"/>
         </form>
    </section>
    
    
</body>
</html>