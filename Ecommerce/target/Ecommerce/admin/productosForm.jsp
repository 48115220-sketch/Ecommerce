<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Producto</title>

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

<script src="<%=request.getContextPath()%>/scripts/productoForm.js"></script>

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

<div class="container">

<a class="navbar-brand"
href="<%=request.getContextPath()%>/admin/admin.jsp">

<img src="<%=request.getContextPath()%>/img/logo.png"
class="logo-navbar">

</a>

<button class="navbar-toggler"
type="button"
data-bs-toggle="collapse"
data-bs-target="#navbar">

<span class="navbar-toggler-icon"></span>

</button>

<div class="collapse navbar-collapse"
id="navbar">

<ul class="navbar-nav ms-auto">

<li class="nav-item">
<a class="nav-link"
href="<%=request.getContextPath()%>/admin/admin.jsp">
Panel
</a>
</li>

<li class="nav-item">
<a class="nav-link"
href="<%=request.getContextPath()%>/admin/productosAdmin.jsp">
Productos
</a>
</li>

<li class="nav-item">
<a class="nav-link active" href="#">
Producto
</a>
</li>

</ul>

</div>

</div>

</nav>

<section class="hero">

<div class="container text-center">

<h1>

<i class="bi bi-box-seam"></i>

Producto

</h1>

<p>

Registrar o modificar un producto.

</p>

</div>

</section>

<div class="container my-5">

<div class="card shadow-lg">

<div class="card-header text-white"
style="background:#556a32;">

<h4 class="mb-0">

<i class="bi bi-pencil-square"></i>

Datos del Producto

</h4>

</div>

<div class="card-body">

<form id="frmProducto">

<input
type="hidden"
id="idProducto">

<div class="row">

<div class="col-md-6 mb-3">

<label class="form-label">

Título

</label>

<input
type="text"
id="titulo"
class="form-control">

</div>

<div class="col-md-6 mb-3">

<label class="form-label">

Precio

</label>

<input
type="number"
step="0.01"
id="precio"
class="form-control">

</div>

</div>

<div class="mb-3">

<label class="form-label">

Descripción

</label>

<textarea
id="descripcion"
rows="4"
class="form-control">

</textarea>

</div>

<div class="mb-3">

<label class="form-label">

Características

</label>

<textarea
id="caracteristicas"
rows="3"
class="form-control">

</textarea>

</div>

<div class="row">

<div class="col-md-6 mb-3">

<label class="form-label">

Stock

</label>

<input
type="number"
id="stock"
class="form-control">

</div>

<div class="col-md-6 mb-3">

<label class="form-label">

Fecha publicación

</label>

<input
type="date"
id="fechaPublic"
class="form-control">

</div>

</div>

<div class="mb-4">

<label class="form-label">

URL Imagen

</label>

<input
type="text"
id="urlImagen"
class="form-control"
placeholder="https://...">

</div>

<div class="text-center">

<button
type="button"
id="btnGuardar"
class="btn btn-success btn-lg me-3">

<i class="bi bi-floppy"></i>

Guardar

</button>

<a
href="<%=request.getContextPath()%>/admin/productosAdmin.jsp"
class="btn btn-secondary btn-lg">

<i class="bi bi-arrow-left-circle"></i>

Cancelar

</a>

</div>

</form>

</div>

</div>

</div>

<footer class="footer">

<div class="container text-center">

<p class="mb-0">

© 2026 Ecommerce - Administración

</p>

</div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>