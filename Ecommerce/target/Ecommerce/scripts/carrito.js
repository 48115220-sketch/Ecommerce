$(document).ready(function () {

    cargarCarrito();

    // Vaciar carrito
    $("#btnVaciar").click(function () {

        Swal.fire({
            title: "¿Vaciar carrito?",
            text: "Se eliminarán todos los productos.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#556a32",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, vaciar",
            cancelButtonText: "Cancelar"
        }).then((result) => {

            if (result.isConfirmed) {

                $.ajax({

                    type: "POST",

                    url: contextPath + "/carrito",

                    data: {
                        accion: "vaciar"
                    },

                    dataType: "json",

                    success: function () {

                        Swal.fire({
                            icon: "success",
                            title: "Carrito vaciado",
                            text: "Todos los productos fueron eliminados.",
                            timer: 1500,
                            showConfirmButton: false
                        });

                        cargarCarrito();

                    },

                    error: function () {

                        Swal.fire({
                            icon: "error",
                            title: "Error",
                            text: "No fue posible vaciar el carrito."
                        });

                    }

                });

            }

        });

    });


    // Comprar
    $("#btnComprar").click(function () {

        let idUsuario = prompt("Ingrese el ID del usuario:");

        if (idUsuario == null || idUsuario.trim() == "") {
            return;
        }

        Swal.fire({
            title: "¿Confirmar compra?",
            text: "Se registrará la compra.",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#556a32",
            cancelButtonColor: "#d33",
            confirmButtonText: "Comprar",
            cancelButtonText: "Cancelar"
        }).then((result) => {

            if (result.isConfirmed) {

                $.ajax({

                    type: "POST",

                    url: contextPath + "/compra",

                    data: {

                        accion: "registrar",

                        idUsuario: idUsuario

                    },

                    dataType: "json",

                    success: function () {

                        Swal.fire({
                            icon: "success",
                            title: "Compra realizada",
                            text: "Gracias por tu compra."
                        });

                        cargarCarrito();

                    },

                    error: function (xhr) {

                        Swal.fire({
                            icon: "error",
                            title: "Error",
                            text: xhr.responseText
                        });

                    }

                });

            }

        });

    });

});


//============================================

function cargarCarrito() {

    $.ajax({

        type: "POST",

        url: contextPath + "/carrito",

        data: {
            accion: "listar"
        },

        dataType: "json",

        success: function (carrito) {

            mostrarCarrito(carrito);

        },

        error: function () {

            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No fue posible cargar el carrito."
            });

        }

    });

}


//============================================

function mostrarCarrito(carrito) {

    let html = "";

    let total = 0;

    if (carrito.detalles == null || carrito.detalles.length == 0) {

        html += `
            <tr>
                <td colspan="5" class="text-center py-5">
                    <i class="bi bi-cart-x" style="font-size:60px;color:#97a756;"></i>
                    <br><br>
                    <h5>Tu carrito está vacío</h5>
                    <small class="text-muted">
                        Agregá algunos productos para comenzar.
                    </small>
                </td>
            </tr>
        `;

    } else {

        $.each(carrito.detalles, function (i, detalle) {

            let subtotal = detalle.cantidad * detalle.precioUnitario;

            total += subtotal;

            html += `

                <tr>

                    <td>

                        <strong>${detalle.producto.titulo}</strong>

                    </td>

                    <td>

                        ${detalle.cantidad}

                    </td>

                    <td>

                        $ ${detalle.precioUnitario.toFixed(2)}

                    </td>

                    <td>

                        <strong>$ ${subtotal.toFixed(2)}</strong>

                    </td>

                    <td class="text-center">

                        <button
                            class="btn btn-danger btn-sm"
                            onclick="eliminarProducto(${i})">

                            <i class="bi bi-trash"></i>

                        </button>

                    </td>

                </tr>

            `;

        });

    }

    $("#tablaCarrito").html(html);

    $("#totalCarrito").text(total.toFixed(2));

}


//============================================

function eliminarProducto(indice) {

    Swal.fire({

        title: "¿Eliminar producto?",

        text: "Se quitará del carrito.",

        icon: "warning",

        showCancelButton: true,

        confirmButtonColor: "#556a32",

        cancelButtonColor: "#d33",

        confirmButtonText: "Eliminar",

        cancelButtonText: "Cancelar"

    }).then((result) => {

        if (result.isConfirmed) {

            $.ajax({

                type: "POST",

                url: contextPath + "/carrito",

                data: {

                    accion: "eliminar",

                    indice: indice

                },

                dataType: "json",

                success: function () {

                    Swal.fire({

                        icon: "success",

                        title: "Producto eliminado",

                        timer: 1200,

                        showConfirmButton: false

                    });

                    cargarCarrito();

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