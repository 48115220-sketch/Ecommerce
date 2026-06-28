<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Administrar Productos</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
href="<%=request.getContextPath()%>/css/Style.css">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    var contextPath="<%=request.getContextPath()%>";
</script>

<script src="<%=request.getContextPath()%>/scripts/productosAdmin.js"></script>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

<div class="container">

<a class="navbar-brand"
href="<%=request.getContextPath()%>/home/home.jsp">

<img src="<%=request.getContextPath()%>/img/logo.png"
class="logo-navbar">

</a>

<button class="navbar-toggler"
type="button"
data-bs-toggle="collapse"
data-bs-target="#menu">

<span class="navbar-toggler-icon"></span>

</button>

<div class="collapse navbar-collapse"
id="menu">

<ul class="navbar-nav ms-auto">

<li class="nav-item">

<a class="nav-link"
href="<%=request.getContextPath()%>/admin/admin.jsp">

Panel Admin

</a>

</li>

<li class="nav-item">

<a class="nav-link active"
href="#">

Productos

</a>

</li>

</ul>

</div>

</div>

</nav>

<!-- TITULO -->

<section class="hero">

<div class="container text-center">

<h1>

<i class="bi bi-box-seam"></i>

Administración de Productos

</h1>

<p>

Alta, modificación y eliminación de productos.

</p>

</div>

</section>

<!-- BOTON NUEVO -->

<div class="container mt-5">

<div class="d-flex justify-content-between align-items-center mb-4">

<h3>Listado de Productos</h3>

<button
class="btn btn-success"
id="btnNuevo">

<i class="bi bi-plus-circle"></i>

Nuevo Producto

</button>

</div>

<div class="card shadow">

<div class="card-body">

<div class="table-responsive">

<table class="table table-hover align-middle">

<thead class="table-success">

<tr>

<th>ID</th>

<th>Imagen</th>

<th>Título</th>

<th>Precio</th>

<th>Stock</th>

<th>Acciones</th>

</tr>

</thead>

<tbody id="tablaProductos">

</tbody>

</table>

</div>

</div>

</div>

</div>

<!-- MODAL -->

<div class="modal fade"
id="modalProducto"
tabindex="-1">

<div class="modal-dialog modal-lg">

<div class="modal-content">

<div class="modal-header">

<h4>

Producto

</h4>

<button
type="button"
class="btn-close"
data-bs-dismiss="modal">

</button>

</div>

<div class="modal-body">

<input
type="hidden"
id="idProducto">

<div class="row">

<div class="col-md-6 mb-3">

<label>

Título

</label>

<input
type="text"
id="titulo"
class="form-control">

</div>

<div class="col-md-6 mb-3">

<label>

Precio

</label>

<input
type="number"
id="precio"
class="form-control">

</div>

</div>

<div class="mb-3">

<label>

Descripción

</label>

<textarea
id="descripcion"
rows="4"
class="form-control">

</textarea>

</div>

<div class="row">

<div class="col-md-6 mb-3">

<label>

Stock

</label>

<input
type="number"
id="stock"
class="form-control">

</div>

<div class="col-md-6 mb-3">

<label>

URL Imagen

</label>

<input
type="text"
id="urlImagen"
class="form-control">

</div>

</div>

</div>

<div class="modal-footer">

<button
class="btn btn-secondary"
data-bs-dismiss="modal">

Cancelar

</button>

<button
class="btn btn-success"
id="btnGuardar">

Guardar

</button>

</div>

</div>

</div>

</div>

<footer class="footer mt-5">

<div class="container text-center">

<p class="mb-0">

© 2026 Ecommerce - Panel Administrador

</p>

</div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>