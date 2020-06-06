<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear usuario</title>
 <link rel="stylesheet" type="text/css" href="style.css"><!-- HOJA DE ESTILOS-->
</head>
<body>
<section>
<h2 id="sectionTitle">Crear nuevo usuario</h2>
            <div id="formulario" style="display: block;">
                <form action="CrearUsuario">
                	<s:textfield name="idUsuario" placeholder="Usuario" label="Usuario"/> 
                    <br>
                    <br>
                    <s:password name="password" placeholder="Contraseña" label="Contraseña"/> 
                    <br>
                    <br>
                    <s:password name="passwordConf" placeholder="Confirmar contraseña"/> 
                    <br>
                    <br>
                    <s:textfield name="nombre" placeholder="Nombre" label="Nombre"/>
                    <br>
                    <br>
                    <s:textfield name="apellidos" placeholder="Apellidos" label="Apellidos"/>
                    <br>
                    <br>

                    <s:textfield name="email" placeholder="Email" label="Email"/>
                    <br>
                    <br>
                    <s:textfield name="telefono" placeholder="Teléfono" label="Teléfono"/>
                    <br>
                    <br>
                    <s:select name="rol" label="Tipo de usuario" list="{'Empleado', 'Jefe de Proyecto', 'Admin'}"/>
                    <br>
                    <br>
                    <s:submit value="Crear"/>
                </form>
            </div>
</section>	
</body>
</html>