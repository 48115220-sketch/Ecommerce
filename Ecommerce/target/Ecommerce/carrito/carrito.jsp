<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Mi Carrito</title>

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

<script src="<%=request.getContextPath()%>/scripts/carrito.js"></script>

</head>

<body>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

    <div class="container">

        <a class="navbar-brand"
           href="<%=request.getContextPath()%>/home/home.jsp">

            <img src="<%=request.getContextPath()%>/img/logo.png"
                 class="logo-navbar">

        </a>

        <button class="navbar-toggler"
                data-bs-toggle="collapse"
                data-bs-target="#navbar">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse"
             id="navbar">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/home/home.jsp">

                        Inicio

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link active"
                       href="#">

                        <i class="bi bi-cart-fill"></i>
                        Mi carrito

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/misCompras/misCompras.jsp">

                        <i class="bi bi-bag-check"></i>
                        Mis compras

                    </a>

                </li>

            </ul>

        </div>

    </div>

</nav>

<!-- ================= TITULO ================= -->

<section class="hero-mini">

    <div class="container text-center">

        <h1>

            <i class="bi bi-cart4"></i>

            Mi Carrito

        </h1>

        <p>

            Revisá tus productos antes de finalizar la compra.

        </p>

    </div>

</section>

<!-- ================= CONTENIDO ================= -->

<div class="container my-5">

    <div class="card shadow-lg border-0">

        <div class="card-body p-4">

            <div class="table-responsive">

                <table class="table align-middle">

                    <thead class="table-success">

                        <tr>

                            <th>Producto</th>

                            <th width="120">Cantidad</th>

                            <th width="140">Precio</th>

                            <th width="150">Subtotal</th>

                            <th width="80"></th>

                        </tr>

                    </thead>

                    <tbody id="tablaCarrito">

                    </tbody>

                </table>

            </div>

            <hr>

            <div class="row align-items-center">

                <div class="col-md-6">

                    <a href="<%=request.getContextPath()%>/home/home.jsp"
                       class="btn btn-secondary">

                        <i class="bi bi-arrow-left-circle"></i>

                        Seguir comprando

                    </a>

                </div>

                <div class="col-md-6 text-end">

                    <h3 class="mb-3">

                        Total

                        <span class="badge bg-success">

                            $

                            <span id="totalCarrito">

                                0.00

                            </span>

                        </span>

                    </h3>

                    <button
                        id="btnVaciar"
                        class="btn btn-outline-danger me-2">

                        <i class="bi bi-trash"></i>

                        Vaciar

                    </button>

                    <button
                        id="btnComprar"
                        class="btn btn-success">

                        <i class="bi bi-credit-card"></i>

                        Finalizar compra

                    </button>

                </div>

            </div>

        </div>

    </div>

</div>

<!-- ================= BENEFICIOS ================= -->

<div class="container mb-5">

    <div class="row text-center">

        <div class="col-md-4">

            <i class="bi bi-shield-check"
               style="font-size:45px;color:#556a32;"></i>

            <h5 class="mt-3">

                Compra segura

            </h5>

            <p>

                Tus datos están protegidos.

            </p>

        </div>

        <div class="col-md-4">

            <i class="bi bi-truck"
               style="font-size:45px;color:#556a32;"></i>

            <h5 class="mt-3">

                Envíos rápidos

            </h5>

            <p>

                Recibí tus productos en tiempo récord.

            </p>

        </div>

        <div class="col-md-4">

            <i class="bi bi-arrow-repeat"
               style="font-size:45px;color:#556a32;"></i>

            <h5 class="mt-3">

                Cambios garantizados

            </h5>

            <p>

                Si no te gusta, podés devolverlo.

            </p>

        </div>

    </div>

</div>

<!-- ================= FOOTER ================= -->

<footer class="footer">

    <div class="container text-center">

        © 2026 Ecommerce - Todos los derechos reservados

    </div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>