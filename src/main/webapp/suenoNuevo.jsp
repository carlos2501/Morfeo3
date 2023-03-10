<%@ page import="org_cpl_cursos.java.modelos.Categoria" %>
<%@ page import="java.util.List" %><%--
  Created by CPL.
  User: Carlos
  Date: 05/02/2023
  Time: 12:28
  To change this template use File | Settings | File Templates | JSP Bootstrap 5.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categoria> categs = (List<Categoria>)request.getAttribute("categorias");
%>
<!doctype html>
<html lang="es_ES">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Estilos personalizados -->
    <link href="custom.css" type="text/css" rel="stylesheet">

    <title>Nuevo sueño</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <form action="">
                <div class="my-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input type="text" id="titulo" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea name="descripcion" id="descripcion" cols="50" rows="5" class="formcontrol"></textarea>
                </div>
                <div class="mb-3">
                    <label for="fecha">Fecha</label>
                    <input type="date" class="form-control" id="fecha" name="fecha">
                </div>
                <select name="categoria" id="categoria" class="form-select">
                    <%for(Categoria c: categs) {%>>
                    <option value="<%=c.getId()%>"><%=c.getCategoria()%></option>
                    <%}%>
                </select>
            </form>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>