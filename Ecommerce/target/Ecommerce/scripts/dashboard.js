$(document).ready(function () {

    cargarDashboard();

});

function cargarDashboard() {

    /*
     * Datos de demostración.
     * Cuando el sistema tenga estadísticas reales,
     * solamente reemplazar estos valores.
     */

    $("#totalProductos").text("125");

    $("#totalUsuarios").text("38");

    $("#totalCompras").text("62");

    $("#totalVentas").text("$24.500");

}