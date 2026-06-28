<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Administrar Usuarios</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
href="<%=request.getContextPath()%>/css/Style.css">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>

var contextPath = "<%=request.getContextPath()%>";

</script>

<script src="<%=request.getContextPath()%>/scripts/usuariosAdmin.js"></script>

</head>

<body>

<!-- NAVBAR -->

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

<i class="bi bi-speedometer2"></i>

Panel

</a>

</li>

<li class="nav-item">

<a class="nav-link"
href="<%=request.getContextPath()%>/admin/productosAdmin.jsp">

<i class="bi bi-box-seam"></i>

Productos

</a>

</li>

<li class="nav-item">

<a class="nav-link active"
href="#">

<i class="bi bi-people-fill"></i>

Usuarios

</a>

</li>

</ul>

</div>

</div>

</nav>

<!-- HERO -->

<section class="hero">

<div class="container text-center">

<h1>

<i class="bi bi-people-fill"></i>

Administración de Usuarios

</h1>

<p>

Visualice todos los usuarios registrados en el sistema.

</p>

</div>

</section>

<!-- TABLA -->

<div class="container my-5">

<div class="card shadow-lg">

<div class="card-header text-white"
style="background:#556a32;">

<div class="d-flex justify-content-between align-items-center">

<h4 class="mb-0">

<i class="bi bi-person-lines-fill"></i>

Usuarios Registrados

</h4>

<span class="badge bg-light text-dark fs-6">

Solo lectura

</span>

</div>

</div>

<div class="card-body">

<div class="table-responsive">

<table class="table table-hover align-middle">

<thead class="table-success">

<tr>

<th width="10%">ID</th>

<th width="30%">Nombre</th>

<th width="30%">Correo</th>

<th width="10%">Rol</th>

<th width="10%">Estado</th>

<th width="10%">Acciones</th>

</tr>

</thead>

<tbody id="tablaUsuarios">

<tr>

<td colspan="6" class="text-center">

Cargando usuarios...

</td>

</tr>

</tbody>

</table>

</div>

</div>

</div>

</div>

<footer class="footer">

<div class="container text-center">

<p class="mb-0">

© 2026 Ecommerce - Panel de Administración

</p>

</div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>