<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Listado de Usuarios</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3 class="text-center">
                Gestión de Usuarios
            </h3>

        </div>

        <div class="card-body">

            <table class="table table-hover table-bordered">

                <thead class="table-dark">

                    <tr>

                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Rol</th>

                    </tr>

                </thead>

                <tbody id="tablaUsuarios">

                </tbody>

            </table>

        </div>

    </div>

</div>

<script>

$(document).ready(function(){

    cargarUsuarios();

});

function cargarUsuarios(){

    $.ajax({

        url:"usuarios",

        type:"GET",

        dataType:"json",

        success:function(datos){

            let filas = "";

            $.each(datos,function(i,u){

                filas += "<tr>";

                filas += "<td>"+u.id+"</td>";
                filas += "<td>"+u.nombre+"</td>";
                filas += "<td>"+u.apellido+"</td>";
                filas += "<td>"+u.email+"</td>";
                filas += "<td>"+u.telefono+"</td>";
                filas += "<td>"+u.rol+"</td>";

                filas += "</tr>";

            });

            $("#tablaUsuarios").html(filas);

        },

        error:function(){

            alert("No fue posible cargar los usuarios.");

        }

    });

}

</script>

</body>
</html>