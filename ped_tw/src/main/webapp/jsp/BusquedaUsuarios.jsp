<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css"><!-- HOJA DE ESTILOS-->
</head>
<body>
            <h2 id="sectionTitle">Usuarios</h2>
            <div id="tabla" style="display: block;">
                <form id="buscador">
                    <select name="transporte">
                        <option>Id</option>
                        <option>Nombre</option>
                        <option>Apellido</option>
                        <option>Email</option>
                        <option>Tel&eacute;fono</option>
                    </select>
                    <input type="text" id="textField" name="textField" placeholder="introducir texto">
                    <input type="submit" value="Buscar">
                </form>
                <br>
                <br>
                <table>
                    <thead>
                        <td>Id</td>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>Email</td>
                        <td>Teléfono</td>
                    </thead>
                    <tr>
                        <td id="">arimarfra</td>
                        <td id="">Ariana</td>
                        <td id="">Martinez</td>
                        <td id="">666778899</td>
                        <td id="">arimm@gmail.com</td>
                    </tr>
                </table>
            </div>
            <!-- modulo tabla: end -->
</body>
</html>