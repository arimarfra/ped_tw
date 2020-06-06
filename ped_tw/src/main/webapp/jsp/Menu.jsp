<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<!-- HOJA DE ESTILOS-->
</head>

<body>
	<!-- CABECERA SALUDO USUARIO -->
	<header>
		<h1>
		  Hola, <s:property value="#session.usuario.nombre"/>
		</h1>
	</header>
	<!-- CABECERA SALUDO USUARIO: END -->

	<!-- MENU -->
	<nav>
		<ul id="menu">
			<li><a href="<s:url action='MostrarUsuario'/>">Mis datos</a></li>
			<li><a href="">Mis eventos</a></li>
			<li><a href="<s:url action='BuscarUsuarios'/>">Buscar usuarios</a></li>
		</ul>
	</nav>
	<!-- MENU: END -->
</body>
</html>