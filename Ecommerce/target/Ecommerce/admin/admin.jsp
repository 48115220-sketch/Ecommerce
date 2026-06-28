<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Panel Administrador</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
href="<%=request.getContextPath()%>/css/Style.css">

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

<script>

    var contextPath = "<%=request.getContextPath()%>";

</script>

<script src="<%=request.getContextPath()%>/scripts/admin.js"></script>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

    <div class="container">

        <a class="navbar-brand"
           href="<%=request.getContextPath()%>/admin/admin.jsp">

            <img src="<%=request.getContextPath()%>/img/logo.png"
                 class="logo-navbar"
                 alt="Logo">

        </a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbar">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse" id="navbar">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">

                    <a class="nav-link active"
                       href="#">

                        Panel Administrador

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/home/home.jsp">

                        Ir a la tienda

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

            <i class="bi bi-speedometer2"></i>

            Panel de Administración

        </h1>

        <p>

            Administrá productos, usuarios y compras desde un único lugar.

        </p>

    </div>

</section>

<!-- PANEL -->

<div class="container my-5">

    <div class="row g-4">

        <!-- PRODUCTOS -->

        <div class="col-md-6 col-lg-3">

            <div class="card shadow h-100 text-center p-4">

                <i class="bi bi-box-seam"
                   style="font-size:60px;color:#556a32;"></i>

                <h4 class="mt-3">

                    Productos

                </h4>

                <p class="text-muted">

                    Crear, editar y eliminar productos.

                </p>

                <a href="<%=request.getContextPath()%>/admin/productosAdmin.jsp"
                   class="btn btn-success">

                    Administrar

                </a>

            </div>

        </div>

        <!-- USUARIOS -->

        <div class="col-md-6 col-lg-3">

            <div class="card shadow h-100 text-center p-4">

                <i class="bi bi-people-fill"
                   style="font-size:60px;color:#556a32;"></i>

                <h4 class="mt-3">

                    Usuarios

                </h4>

                <p class="text-muted">

                    Consultar usuarios registrados.

                </p>

                <a href="<%=request.getContextPath()%>/admin/usuariosAdmin.jsp"
                   class="btn btn-success">

                    Administrar

                </a>

            </div>

        </div>

        <!-- COMPRAS -->

        <div class="col-md-6 col-lg-3">

            <div class="card shadow h-100 text-center p-4">

                <i class="bi bi-bag-check-fill"
                   style="font-size:60px;color:#556a32;"></i>

                <h4 class="mt-3">

                    Compras

                </h4>

                <p class="text-muted">

                    Ver todas las compras realizadas.

                </p>

                <a href="<%=request.getContextPath()%>/admin/comprasAdmin.jsp"
                   class="btn btn-success">

                    Administrar

                </a>

            </div>

        </div>

        <!-- DASHBOARD -->

        <div class="col-md-6 col-lg-3">

            <div class="card shadow h-100 text-center p-4">

                <i class="bi bi-bar-chart-fill"
                   style="font-size:60px;color:#556a32;"></i>

                <h4 class="mt-3">

                    Dashboard

                </h4>

                <p class="text-muted">

                    Visualizar estadísticas del sistema.

                </p>

                <a href="<%=request.getContextPath()%>/admin/dashboard.jsp"
                   class="btn btn-success">

                    Ver panel

                </a>

            </div>

        </div>

    </div>

    <!-- SEGUNDA FILA -->

    <div class="row mt-4">

        <div class="col">

            <div class="card shadow">

                <div class="card-header text-white"
                     style="background:#556a32;">

                    <h5 class="mb-0">

                        Acciones rápidas

                    </h5>

                </div>

                <div class="card-body">

                    <div class="d-flex flex-wrap gap-3 justify-content-center">

                        <a href="<%=request.getContextPath()%>/admin/productoForm.jsp"
                           class="btn btn-success">

                            <i class="bi bi-plus-circle"></i>

                            Nuevo Producto

                        </a>

                        <a href="<%=request.getContextPath()%>/home/home.jsp"
                           class="btn btn-secondary">

                            <i class="bi bi-shop"></i>

                            Ir a la tienda

                        </a>

                        <button class="btn btn-danger"
                                id="btnCerrarSesion">

                            <i class="bi bi-box-arrow-right"></i>

                            Cerrar sesión

                        </button>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>

<footer class="footer">

    <div class="container text-center">

        <p class="mb-0">

            © 2026 Ecommerce | Panel de Administración

        </p>

    </div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>