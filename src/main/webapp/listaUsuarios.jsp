<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org_cpl_cursos.java.modelos.Usuario" %>
<%--
  Created by CPL.
  User: Carlos
  Date: 01/02/2023
  Time: 12:05
  To change this template use File | Settings | File Templates | JSP Bootstrap 5.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Usuario> usus = (List<Usuario>)request.getAttribute("usuarios");
%>
<!doctype html>
<html lang="es_ES">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Estilos personalizados -->
    <link href="custom.css" type="text/css" rel="stylesheet">

    <title>Lista de Usuarios</title>
  </head>
  <body>
    <h1> Listado de Usuarios</h1>
    <div>Hola, bienvenido</div>
    <p>
        <a href="<%=request.getContextPath()%>/usuarios/nuevo">Nuevo Usuario</a>
    </p>

    <table>
        <tr>
            <td>id</td>
            <td>Nombre</td>
            <td></td>
            <td></td>
        </tr>
        <%for(Usuario u: usus) {%>
        <tr>
            <td><%=u.getId()%></td>
            <td><%=u.getNombre()%></td>
            <td><a href="<%=request.getContextPath()%>/usuarios/edita?id=<%=u.getId()%>">Editar</a></td>
            <td><a onclick="return confirm('¿Esta seguro de que queire eliminar este producto?');"
                    href="<%=request.getContextPath()%>/usuarios/borrar?id=<%=u.getId()%>">Borrar</a></td>
        </tr>
        <%}%>
    </table>

    <!-- Optional JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>