$(document).ready(function () {

    listarProductos();

    $("#btnBuscar").click(function () {

        let texto = $("#txtBuscar").val().trim();
        let minimo = $("#precioMin").val();
        let maximo = $("#precioMax").val();
        let desde = $("#fechaDesde").val();
        let hasta = $("#fechaHasta").val();

        if (texto !== "") {
            buscarProductos(texto);
        } else if (minimo !== "" && maximo !== "") {
            filtrarPrecio(minimo, maximo);
        } else if (desde !== "" && hasta !== "") {
            filtrarFecha(desde, hasta);
        } else {
            listarProductos();
        }

    });

    $("#btnLimpiar").click(function () {

        $("#txtBuscar").val("");
        $("#precioMin").val("");
        $("#precioMax").val("");
        $("#fechaDesde").val("");
        $("#fechaHasta").val("");

        listarProductos();

    });

    $(document).on("click", ".btnAgregarCarrito", function () {

        agregarCarrito(
            $(this).data("id"),
            $(this).data("precio"),
            $(this).data("titulo"),
            $(this).data("imagen")
        );

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

            cargarProductos(productos);

        },

        error: function () {

            Swal.fire({
                icon: "error",
                title: "Error",
                text: "No se pudieron cargar los productos."
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

            cargarProductos(productos);

        }

    });

}

function filtrarPrecio(minimo, maximo) {

    $.ajax({

        type: "POST",
        url: contextPath + "/producto",
        data: {
            accion: "precio",
            minimo: minimo,
            maximo: maximo
        },

        dataType: "json",

        success: function (productos) {

            cargarProductos(productos);

        }

    });

}

function filtrarFecha(desde, hasta) {

    $.ajax({

        type: "POST",
        url: contextPath + "/producto",
        data: {
            accion: "fecha",
            desde: desde,
            hasta: hasta
        },

        dataType: "json",

        success: function (productos) {

            cargarProductos(productos);

        }

    });

}

function cargarProductos(productos) {

    let html = "";

    if (productos.length === 0) {

        html =
        `
        <div class="col-12 text-center">
            <h4 class="text-secondary">
                No se encontraron productos.
            </h4>
        </div>
        `;

        $("#contenedorProductos").html(html);
        return;
    }

    $.each(productos, function (i, p) {

        let imagen = p.urlImagen;

        if (imagen == null || imagen === "") {

            imagen = contextPath + "/img/sin-imagen.png";

        }

        html += `

        <div class="col-lg-3 col-md-4 col-sm-6 mb-4">

            <div class="card producto-card h-100 shadow-sm">

                <img src="${imagen}" class="card-img-top producto-img">

                <div class="card-body d-flex flex-column">

                    <h5 class="fw-bold text-success">
                        ${p.titulo}
                    </h5>

                    <p class="text-muted small">
                        ${p.descripcion}
                    </p>

                    <p class="small">
                        ${p.caracteristicas}
                    </p>

                    <h4 class="precio-producto">
                        $ ${Number(p.precio).toLocaleString("es-AR")}
                    </h4>

                    <span class="badge bg-success mb-3">
                        Stock: ${p.stock}
                    </span>

                    <button
                        class="btn btn-success mt-auto btnAgregarCarrito"
                        data-id="${p.idProducto}"
                        data-precio="${p.precio}"
                        data-titulo="${p.titulo}"
                        data-imagen="${imagen}">

                        <i class="bi bi-cart-plus-fill"></i>
                        Agregar al carrito

                    </button>

                </div>

            </div>

        </div>

        `;

    });

    $("#contenedorProductos").html(html);

}

function agregarCarrito(idProducto, precio, titulo, urlImagen) {

    console.log("Enviando...");

    console.log({
        idProducto,
        precio,
        titulo,
        urlImagen
    });

    $.ajax({

        type: "POST",
        url: contextPath + "/carrito",
        data: {
            accion: "agregar",
            idProducto: idProducto,
            cantidad: 1,
            precio: precio,
            titulo: titulo,
            urlImagen: urlImagen

        },

        dataType: "json",

        success: function () {

            Swal.fire({

                icon: "success",
                title: "Producto agregado",
                text: "El producto fue agregado correctamente.",
                timer: 1500,
                showConfirmButton: false

            });

        },

        error: function (xhr) {

            console.log(xhr.responseText);

            Swal.fire({

                icon: "error",
                title: "Error",
                text: "No fue posible agregar el producto."
            });

        }

    });

}