$(document).ready(function () {

    listarProductos();

    $("#btnBuscar").click(function () {

        let criterio = $("#txtBuscar").val().trim();

        if (criterio == "") {

            listarProductos();

        } else {

            buscarProductos(criterio);

        }

    });

    $("#btnNuevo").click(function () {

        window.location.href = contextPath + "/admin/nuevoProducto.jsp";

    });

});

function listarProductos() {

    $.ajax({

        type: "POST",

        url: contextPath + "/producto",

        data: {

            accion: "listar"

        },

        dataType: "json",

        success: function (productos) {

            cargarTabla(productos);

        },

        error: function () {

            Swal.fire({

                icon: "error",
                title: "Error",
                text: "No fue posible cargar los productos."

            });

        }

    });

}

function buscarProductos(criterio) {

    $.ajax({

        type: "POST",

        url: contextPath + "/producto",

        data: {

            accion: "buscar",
            criterio: criterio

        },

        dataType: "json",

        success: function (productos) {

            cargarTabla(productos);

        },

        error: function () {

            Swal.fire({

                icon: "error",
                title: "Error",
                text: "No fue posible realizar la búsqueda."

            });

        }

    });

}

function cargarTabla(productos) {

    let html = "";

    if (productos == null || productos.length == 0) {

        html += "<tr>";
        html += "<td colspan='7' class='text-center'>";
        html += "No existen productos registrados.";
        html += "</td>";
        html += "</tr>";

    } else {

        $.each(productos, function (i, p) {

            html += "<tr>";

            html += "<td>" + p.idProducto + "</td>";

            html += "<td>";
            html += "<img src='" + p.urlImagen + "' ";
            html += "style='width:70px;height:70px;object-fit:cover;border-radius:10px;'>";
            html += "</td>";

            html += "<td>" + p.titulo + "</td>";

            html += "<td>$ " + p.precio + "</td>";

            html += "<td>" + p.stock + "</td>";

            html += "<td>";

            html += "<button class='btn btn-warning btn-sm me-2' ";
            html += "onclick='editarProducto(" + p.idProducto + ")'>";

            html += "<i class='bi bi-pencil-square'></i>";

            html += "</button>";

            html += "<button class='btn btn-danger btn-sm' ";
            html += "onclick='eliminarProducto(" + p.idProducto + ")'>";

            html += "<i class='bi bi-trash'></i>";

            html += "</button>";

            html += "</td>";

            html += "</tr>";

        });

    }

    $("#tablaProductos").html(html);

}

function editarProducto(idProducto) {

    window.location.href =
        contextPath +
        "/admin/editarProducto.jsp?id=" +
        idProducto;

}

function eliminarProducto(idProducto) {

    Swal.fire({

        title: "¿Eliminar producto?",

        text: "Esta acción no podrá deshacerse.",

        icon: "warning",

        showCancelButton: true,

        confirmButtonColor: "#556a32",

        cancelButtonColor: "#d33",

        confirmButtonText: "Sí, eliminar",

        cancelButtonText: "Cancelar"

    }).then((result) => {

        if (result.isConfirmed) {

            $.ajax({

                type: "POST",

                url: contextPath + "/producto",

                data: {

                    accion: "eliminar",
                    idProducto: idProducto

                },

                success: function () {

                    Swal.fire({

                        icon: "success",

                        title: "Producto eliminado",

                        timer: 1500,

                        showConfirmButton: false

                    });

                    listarProductos();

                },

                error: function () {

                    Swal.fire({

                        icon: "error",

                        title: "Error",

                        text: "No fue posible eliminar el producto."

                    });

                }

            });

        }

    });

}