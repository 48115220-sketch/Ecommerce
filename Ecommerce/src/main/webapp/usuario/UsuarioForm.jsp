<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta de Usuario</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white">
                    <h3 class="text-center">Registro de Usuario</h3>
                </div>

                <div class="card-body">

                    <form id="formUsuario">

                        <div class="mb-3">
                            <label>Nombre</label>
                            <input type="text" class="form-control" name="nombre" required>
                        </div>

                        <div class="mb-3">
                            <label>Apellido</label>
                            <input type="text" class="form-control" name="apellido" required>
                        </div>

                        <div class="mb-3">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label>Contraseña</label>
                            <input type="password" class="form-control" name="password" required>
                        </div>

                        <div class="mb-3">
                            <label>Teléfono</label>
                            <input type="text" class="form-control" name="telefono">
                        </div>

                        <button type="submit" class="btn btn-success w-100">
                            Registrar Usuario
                        </button>
                <a href="<%= request.getContextPath() %>/usuario/index.jsp" class="btn btn-secondary w-100 mt-2">
   Volver al inicio
</a>
                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

<script>

$("#formUsuario").submit(function(e){

    e.preventDefault();

    $.ajax({

        url:"crearUsuario",

        type:"GET",

        data:$(this).serialize(),

        success:function(){

            alert("Usuario registrado correctamente.");

            $("#formUsuario")[0].reset();

        },

        error:function(){

            alert("Ocurrió un error.");

        }

    });

});

</script>

</body>
</html>