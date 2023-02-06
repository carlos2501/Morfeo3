<%@ page import="java.util.Optional" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String nombreusu = (String) request.getSession().getAttribute("nombreusuario");
  Long idusu = (Long) request.getSession().getAttribute("idusuario");
%>
<!doctype html>
<html lang="es_ES">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

  <!-- Estilos personalizados -->
  <link href="../css/login.css" type="text/css" rel="stylesheet">

  <title>Login</title>
</head>
<body>
<div class="container">
  <div class="row p-5">
    <div class="col">
    </div>
    <div class="col-4">
      <form action="acceder" method="POST">
        <!-- Si ya ha accedido, aparece el siguiente mensaje -->
        <%if ( nombreusu != null) {%>
        <div class="alert alert-danger" rol="alert">
          <p class="mb-1">Hola <%=nombreusu%> con id <%=idusu%>. Ya estás dentro del sitio.</p>
          <p class="mb-1">No es necesario que vuelvas a acceder.</p>
          <p>Si quieres dejarnos, pulsa <a href="/salir">aqui</a></p>
        </div>
        <%}%>
        <!-- Email input -->
        <div class="form-outline mb-4">
          <input type="text" id="form2Example1" name="usuario" class="form-control" />
          <label class="form-label" for="form2Example1">Correo electrónico o Usuario</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <input type="password" id="form2Example2" name="clave" class="form-control" />
          <label class="form-label" for="form2Example2">Contraseña</label>
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
          <div class="col d-flex justify-content-center">
            <!-- Checkbox -->
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
              <label class="form-check-label" for="form2Example31"> Recuérdame </label>
            </div>
          </div>

          <div class="col">
            <!-- Simple link -->
            <a href="#!">He olvidado mi contraseña</a>
          </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4 w-100">Acceder</button>

        <!-- Register buttons -->
        <div class="text-center">
          <p>¿Aún no es miembro? <a href="#!">Registrarse</a></p>
          <p>o acceder mediante:</p>
          <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-facebook-f"></i>
          </button>

          <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-google"></i>
          </button>

          <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-twitter"></i>
          </button>

          <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-github"></i>
          </button>
        </div>
      </form>
    </div>
    <div class="col">
    </div>

  </div>
</div>

<!-- Optional JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
</body>
</html>