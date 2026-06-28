<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Dashboard</title>

        <link rel="stylesheet" href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Style.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

        <script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

        <script>

            var contextPath = "<%=request.getContextPath()%>";

        </script>

        <script src="<%=request.getContextPath()%>/scripts/dashboard.js"></script>

    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

            <div class="container">

                <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/admin.jsp">

                    <img src="<%=request.getContextPath()%>/img/logo.png" class="logo-navbar">

                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar">

                    <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbar">

                    <ul class="navbar-nav ms-auto">

                        <li class="nav-item">

                            <a class="nav-link" href="<%=request.getContextPath()%>/admin/admin.jsp">

                                Panel

                            </a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link" href="<%=request.getContextPath()%>/admin/productosAdmin.jsp">

                                Productos

                            </a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link" href="<%=request.getContextPath()%>/admin/usuariosAdmin.jsp">

                                Usuarios

                            </a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link" href="<%=request.getContextPath()%>/admin/comprasAdmin.jsp">

                                Compras

                            </a>

                        </li>

                        <li class="nav-item">

                            <a class="nav-link active" href="#">

                                Dashboard

                            </a>

                        </li>

                    </ul>

                </div>

            </div>

        </nav>

        <section class="hero">

            <div class="container text-center">

                <h1>

                    <i class="bi bi-speedometer2"></i>

                    Dashboard

                </h1>

                <p>

                    Resumen general del sistema Ecommerce.

                </p>

            </div>

        </section>

        <div class="container my-5">

            <div class="row g-4">

                <div class="col-md-3">

                    <div class="card shadow text-center h-100">

                        <div class="card-body">

                            <i class="bi bi-box-seam display-3 text-success"></i>

                            <h5 class="mt-3">

                                Productos

                            </h5>

                            <h2 id="totalProductos">

                                0

                            </h2>

                        </div>

                    </div>

                </div>

                <div class="col-md-3">

                    <div class="card shadow text-center h-100">

                        <div class="card-body">

                            <i class="bi bi-people-fill display-3 text-primary"></i>

                            <h5 class="mt-3">

                                Usuarios

                            </h5>

                            <h2 id="totalUsuarios">

                                0

                            </h2>

                        </div>

                    </div>

                </div>

                <div class="col-md-3">

                    <div class="card shadow text-center h-100">

                        <div class="card-body">

                            <i class="bi bi-cart-check-fill display-3 text-warning"></i>

                            <h5 class="mt-3">

                                Compras

                            </h5>

                            <h2 id="totalCompras">

                                0

                            </h2>

                        </div>

                    </div>

                </div>

                <div class="col-md-3">

                    <div class="card shadow text-center h-100">

                        <div class="card-body">

                            <i class="bi bi-currency-dollar display-3 text-danger"></i>

                            <h5 class="mt-3">

                                Ventas

                            </h5>

                            <h2 id="totalVentas">

                                $0

                            </h2>

                        </div>

                    </div>

                </div>

            </div>

            <div class="card shadow mt-5">

                <div class="card-header text-white" style="background:#556a32;">

                    <h4 class="mb-0">

                        <i class="bi bi-bar-chart-line-fill"></i>

                        Información General

                    </h4>

                </div>

                <div class="card-body text-center">

                    <p class="fs-5">

                        Este panel muestra un resumen general del estado del sistema.

                    </p>

                    <p class="text-muted">

                        En futuras versiones podrá visualizar estadísticas detalladas,
                        productos más vendidos, ingresos y comportamiento de los usuarios.

                    </p>

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