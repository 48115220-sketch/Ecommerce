<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html>

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Ecommerce</title>

        <link rel="stylesheet" href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Style.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

        <script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <script>
            var contextPath = "<%=request.getContextPath()%>";
        </script>

        <script src="<%=request.getContextPath()%>/scripts/home.js"></script>

    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

            <div class="container">

                <a class="navbar-brand" href="<%=request.getContextPath()%>/home/home.jsp">

                    <img src="<%=request.getContextPath()%>/img/logo.png" class="logo-navbar" alt="Logo">

                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar">

                    <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbar">

                    <ul class="navbar-nav ms-auto">

                        <li class="nav-item">
                            <a class="nav-link active" href="<%=request.getContextPath()%>/home/home.jsp">
                                Inicio
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#contenedorProductos">
                                Productos
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/carrito/carrito.jsp">
                                <i class="bi bi-cart3"></i>
                                Mi carrito
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/misCompras/misCompras.jsp">
                                <i class="bi bi-bag-check"></i>
                                Mis compras
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                Iniciar sesión
                            </a>
                        </li>

                    </ul>

                </div>

            </div>

        </nav>

        <section class="banner-home">

            <div class="container">

                <div class="banner-texto">

                    <h1>Descubrí miles de productos</h1>

                    <p>
                        Comprá fácil, rápido y seguro desde cualquier lugar.
                    </p>

                    <a href="#contenedorProductos" class="btn btn-success btn-lg">

                        Ver productos

                    </a>

                </div>

            </div>

        </section>

        <div class="container buscador-home">

            <div class="card shadow">

                <div class="card-body">

                    <div class="row g-3">

                        <div class="col-lg-4">

                            <input type="text" id="txtBuscar" class="form-control" placeholder="Buscar producto...">

                        </div>

                        <div class="col-lg-2">

                            <input type="number" id="precioMin" class="form-control" placeholder="Precio mín">

                        </div>

                        <div class="col-lg-2">

                            <input type="number" id="precioMax" class="form-control" placeholder="Precio máx">

                        </div>

                        <div class="col-lg-2">

                            <input type="date" id="fechaDesde" class="form-control">

                        </div>

                        <div class="col-lg-2">

                            <input type="date" id="fechaHasta" class="form-control">

                        </div>

                    </div>

                    <div class="text-end mt-3">

                        <button id="btnBuscar" class="btn btn-success">

                            <i class="bi bi-search"></i>
                            Buscar

                        </button>

                        <button id="btnLimpiar" class="btn btn-secondary">

                            Limpiar

                        </button>

                    </div>

                </div>

            </div>

        </div>

        <div class="container mt-5">

            <h2 class="titulo-seccion">

                Productos destacados

            </h2>

        </div>

        <div class="container mt-4 mb-5">

            <div class="row" id="contenedorProductos">

            </div>

        </div>

        <footer class="footer">

            <div class="container text-center">

                <p class="mb-0">

                    © 2026 Ecommerce - Todos los derechos reservados

                </p>

            </div>

        </footer>

        <script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

    </html>