$(document).ready(function () {

    solicitarUsuario();

});

function solicitarUsuario() {

    Swal.fire({

        title: "Mis Compras",

        text: "Ingrese su ID de usuario",

        input: "number",

        inputPlaceholder: "ID Usuario",

        confirmButtonText: "Consultar",

        confirmButtonColor: "#556a32",

        allowOutsideClick: false,

        allowEscapeKey: false,

        inputValidator: (value) => {

            if (!value) {
                return "Debe ingresar un ID.";
            }

        }

    }).then((result) => {

        if (result.isConfirmed) {

            cargarCompras(result.value);

        }

    });

}

function cargarCompras(idUsuario) {

    Swal.fire({

        title: "Cargando compras...",

        allowOutsideClick: false,

        didOpen: () => {

            Swal.showLoading();

        }

    });

    $.ajax({

        type: "POST",

        url: contextPath + "/compra",

        data: {

            accion: "listar",

            idUsuario: idUsuario

        },

        dataType: "json",

        success: function (compras) {

            Swal.close();

            mostrarCompras(compras);

        },

        error: function () {

            Swal.fire({

                icon: "error",

                title: "Error",

                text: "No fue posible cargar las compras."

            });

        }

    });

}

function mostrarCompras(compras) {

    let html = "";

    if (!compras || compras.length === 0) {

        html +=
            "<tr>" +
                "<td colspan='5' class='text-center py-5'>" +
                    "<i class='bi bi-bag-x fs-1 text-secondary'></i><br><br>" +
                    "<strong>No existen compras registradas.</strong>" +
                "</td>" +
            "</tr>";

    } else {

        $.each(compras, function (i, compra) {

            let estado = "";

            if (compra.estado === "PENDIENTE") {

                estado = "<span class='badge bg-warning text-dark'>Pendiente</span>";

            } else if (compra.estado === "ENTREGADO") {

                estado = "<span class='badge bg-success'>Entregado</span>";

            } else if (compra.estado === "CANCELADO") {

                estado = "<span class='badge bg-danger'>Cancelado</span>";

            } else {

                estado = "<span class='badge bg-secondary'>" + compra.estado + "</span>";

            }

            let total = compra.total != null ? "$ " + Number(compra.total).toFixed(2) : "-";

            html +=

            "<tr>" +

                "<td><strong>#"+ compra.idCompra +"</strong></td>" +

                "<td>"+ formatearFecha(compra.fechaCompra) +"</td>" +

                "<td>"+ estado +"</td>" +

                "<td>"+ total +"</td>" +

                "<td>" +

                    "<button class='btn btn-outline-success btn-sm'>" +

                        "<i class='bi bi-eye'></i>" +

                    "</button>" +

                "</td>" +

            "</tr>";

        });

    }

    $("#tablaCompras").html(html);

}

function formatearFecha(fecha) {

    if (!fecha) {

        return "-";

    }

    let d = new Date(fecha);

    return d.toLocaleDateString("es-AR", {

        day: "2-digit",

        month: "2-digit",

        year: "numeric"

    });

}