$(document).ready(function () {

    cargarDashboard();

    $("#btnProductos").click(function () {
        $("#contenidoAdmin").html(crearModuloProductos());
    });

    $("#btnUsuarios").click(function () {
        $("#contenidoAdmin").html(crearModuloUsuarios());
    });

    $("#btnCompras").click(function () {
        $("#contenidoAdmin").html(crearModuloCompras());
    });

});

function cargarDashboard() {

    let html = "";

    html += '<div class="row">';

    html += '<div class="col-md-4 mb-4">';
    html += '<div class="card shadow text-center">';
    html += '<div class="card-body">';
    html += '<i class="bi bi-box-seam display-4 text-success"></i>';
    html += '<h5 class="mt-3">Productos</h5>';
    html += '<h2 id="cantProductos">0</h2>';
    html += '</div>';
    html += '</div>';
    html += '</div>';

    html += '<div class="col-md-4 mb-4">';
    html += '<div class="card shadow text-center">';
    html += '<div class="card-body">';
    html += '<i class="bi bi-people-fill display-4 text-primary"></i>';
    html += '<h5 class="mt-3">Usuarios</h5>';
    html += '<h2 id="cantUsuarios">0</h2>';
    html += '</div>';
    html += '</div>';
    html += '</div>';

    html += '<div class="col-md-4 mb-4">';
    html += '<div class="card shadow text-center">';
    html += '<div class="card-body">';
    html += '<i class="bi bi-cart-check-fill display-4 text-warning"></i>';
    html += '<h5 class="mt-3">Compras</h5>';
    html += '<h2 id="cantCompras">0</h2>';
    html += '</div>';
    html += '</div>';
    html += '</div>';

    html += '</div>';

    html += '<div class="alert alert-success">';
    html += '<h5><i class="bi bi-info-circle"></i> Panel de Administración</h5>';
    html += 'Desde este panel podrás administrar el sistema.';
    html += '</div>';

    $("#contenidoAdmin").html(html);

    obtenerEstadisticas();

}

function obtenerEstadisticas() {

    $("#cantProductos").text("25");
    $("#cantUsuarios").text("14");
    $("#cantCompras").text("31");

}

function crearModuloProductos() {

    let html = "";

    html += '<div class="card shadow">';
    html += '<div class="card-header bg-success text-white">';
    html += '<h4><i class="bi bi-box"></i> Administración de Productos</h4>';
    html += '</div>';

    html += '<div class="card-body">';

    html += '<button class="btn btn-success me-2">';
    html += '<i class="bi bi-plus-circle"></i> Nuevo Producto';
    html += '</button>';

    html += '<button class="btn btn-warning me-2">';
    html += '<i class="bi bi-pencil-square"></i> Editar';
    html += '</button>';

    html += '<button class="btn btn-danger">';
    html += '<i class="bi bi-trash"></i> Eliminar';
    html += '</button>';

    html += '<hr>';

    html += '<p class="text-muted">';
    html += 'Aquí aparecerá la tabla de productos.';
    html += '</p>';

    html += '</div>';
    html += '</div>';

    return html;

}

function crearModuloUsuarios() {

    let html = "";

    html += '<div class="card shadow">';
    html += '<div class="card-header bg-primary text-white">';
    html += '<h4><i class="bi bi-people"></i> Administración de Usuarios</h4>';
    html += '</div>';

    html += '<div class="card-body">';

    html += '<button class="btn btn-success me-2">';
    html += '<i class="bi bi-person-plus"></i> Nuevo Usuario';
    html += '</button>';

    html += '<button class="btn btn-warning me-2">';
    html += '<i class="bi bi-pencil"></i> Editar';
    html += '</button>';

    html += '<button class="btn btn-danger">';
    html += '<i class="bi bi-person-x"></i> Eliminar';
    html += '</button>';

    html += '<hr>';

    html += '<p class="text-muted">';
    html += 'Aquí aparecerá la lista de usuarios.';
    html += '</p>';

    html += '</div>';
    html += '</div>';

    return html;

}

function crearModuloCompras() {

    let html = "";

    html += '<div class="card shadow">';
    html += '<div class="card-header bg-warning">';
    html += '<h4><i class="bi bi-cart-check"></i> Compras Realizadas</h4>';
    html += '</div>';

    html += '<div class="card-body">';

    html += '<button class="btn btn-success">';
    html += '<i class="bi bi-arrow-clockwise"></i> Actualizar';
    html += '</button>';

    html += '<hr>';

    html += '<p class="text-muted">';
    html += 'Aquí se mostrarán todas las compras del sistema.';
    html += '</p>';

    html += '</div>';
    html += '</div>';

    return html;

}