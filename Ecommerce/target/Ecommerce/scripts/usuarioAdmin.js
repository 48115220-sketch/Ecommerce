$(document).ready(function () {

    cargarUsuarios();

});

function cargarUsuarios() {

    $.ajax({

        type: "GET",

        url: contextPath + "/usuarios",

        dataType: "json",

        success: function (usuarios) {

            mostrarUsuarios(usuarios);

        },

        error: function () {

            Swal.fire({

                icon: "error",

                title: "Error",

                text: "No fue posible cargar los usuarios."

            });

        }

    });

}

function mostrarUsuarios(usuarios) {

    let html = "";

    if (usuarios == null || usuarios.length == 0) {

        html += "<tr>";
        html += "<td colspan='6' class='text-center'>";
        html += "No existen usuarios registrados.";
        html += "</td>";
        html += "</tr>";

    } else {

        $.each(usuarios, function (i, usuario) {

            html += "<tr>";

            html += "<td>" + obtenerValor(usuario.idUsuario, usuario.id) + "</td>";

            html += "<td>";
            html += obtenerValor(usuario.nombre, "") + " ";
            html += obtenerValor(usuario.apellido, "");
            html += "</td>";

            html += "<td>";
            html += obtenerValor(usuario.email, "Sin correo");
            html += "</td>";

            html += "<td>";

            if (usuario.rol != null && usuario.rol != "") {

                html += usuario.rol;

            } else {

                html += "Cliente";

            }

            html += "</td>";

            html += "<td>";

            html += "<span class='badge bg-success'>Activo</span>";

            html += "</td>";

            html += "<td>";

            html += "<button class='btn btn-warning btn-sm me-2' disabled>";

            html += "<i class='bi bi-pencil'></i>";

            html += "</button>";

            html += "<button class='btn btn-danger btn-sm' disabled>";

            html += "<i class='bi bi-trash'></i>";

            html += "</button>";

            html += "</td>";

            html += "</tr>";

        });

    }

    $("#tablaUsuarios").html(html);

}

function obtenerValor(valor, defecto) {

    if (valor == null || valor == undefined || valor == "") {

        return defecto;

    }

    return valor;

}