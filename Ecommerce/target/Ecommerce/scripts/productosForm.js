$(document).ready(function () {

    const parametros = new URLSearchParams(window.location.search);

    const idProducto = parametros.get("idProducto");

    if (idProducto != null && idProducto !== "") {
        cargarProducto(idProducto);
    }

    $("#btnGuardar").click(function () {
        guardarProducto();
    });

});

function cargarProducto(idProducto) {

    $.ajax({

        type: "POST",

        url: contextPath + "/producto",

        data: {

            accion: "obtener",
            idProducto: idProducto

        },

        dataType: "json",

        success: function (producto) {

            $("#idProducto").val(producto.idProducto);
            $("#titulo").val(producto.titulo);
            $("#descripcion").val(producto.descripcion);
            $("#caracteristicas").val(producto.caracteristicas);
            $("#precio").val(producto.precio);
            $("#stock").val(producto.stock);

            if (producto.fechaPublic != null) {

                let fecha = producto.fechaPublic;

                if (fecha.length >= 10) {
                    fecha = fecha.substring(0, 10);
                }

                $("#fechaPublic").val(fecha);

            }

            $("#urlImagen").val(producto.urlImagen);

        },

        error: function () {

            Swal.fire({

                icon: "error",
                title: "Error",
                text: "No fue posible cargar el producto."

            });

        }

    });

}

function guardarProducto() {

    if ($("#titulo").val().trim() === "") {

        Swal.fire({
            icon: "warning",
            title: "Título obligatorio"
        });

        return;
    }

    if ($("#precio").val() === "") {

        Swal.fire({
            icon: "warning",
            title: "Ingrese el precio"
        });

        return;
    }

    if ($("#stock").val() === "") {

        Swal.fire({
            icon: "warning",
            title: "Ingrese el stock"
        });

        return;
    }

    if ($("#fechaPublic").val() === "") {

        Swal.fire({
            icon: "warning",
            title: "Seleccione la fecha"
        });

        return;
    }

    let accion = "insertar";

    if ($("#idProducto").val() !== "") {

        accion = "actualizar";

    }

    $.ajax({

        type: "POST",

        url: contextPath + "/producto",

        data: {

            accion: accion,

            idProducto: $("#idProducto").val(),

            titulo: $("#titulo").val(),

            descripcion: $("#descripcion").val(),

            caracteristicas: $("#caracteristicas").val(),

            precio: $("#precio").val(),

            stock: $("#stock").val(),

            fechaPublic: $("#fechaPublic").val(),

            urlImagen: $("#urlImagen").val()

        },

        dataType: "json",

        success: function (mensaje) {

            Swal.fire({

                icon: "success",

                title: "Correcto",

                text: mensaje,

                confirmButtonColor: "#556a32"

            }).then(function () {

                window.location.href =
                    contextPath + "/admin/productosAdmin.jsp";

            });

        },

        error: function (xhr) {

            let mensaje = "No fue posible guardar el producto.";

            if (xhr.responseText != null && xhr.responseText !== "") {
                mensaje = xhr.responseText;
            }

            Swal.fire({

                icon: "error",

                title: "Error",

                text: mensaje

            });

        }

    });

}