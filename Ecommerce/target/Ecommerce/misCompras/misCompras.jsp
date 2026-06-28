<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Mis Compras</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    var contextPath = "<%=request.getContextPath()%>";
</script>

<script src="<%=request.getContextPath()%>/scripts/misCompras.js"></script>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-light menu-principal shadow-sm">

    <div class="container">

        <a class="navbar-brand"
           href="<%=request.getContextPath()%>/home/home.jsp">

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

                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/home/home.jsp">

                        Inicio

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/carrito/carrito.jsp">

                        <i class="bi bi-cart"></i>
                        Mi carrito

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link active"
                       href="#">

                        <i class="bi bi-bag-check"></i>
                        Mis compras

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

            <i class="bi bi-bag-check-fill"></i>

            Mis Compras

        </h1>

        <p>

            Consultá el historial completo de todas tus compras realizadas.

        </p>

    </div>

</section>

<!-- CONTENIDO -->

<div class="container mt-5 mb-5">

    <div class="card shadow-lg">

        <div class="card-header text-white"
             style="background:#556a32;">

            <h4 class="mb-0">

                Historial de Compras

            </h4>

        </div>

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-hover align-middle">

  <thead class="table-success">

    <tr>

        <th>ID Compra</th>

        <th>Fecha</th>

        <th>Estado</th>

        <th>Total</th>

        <th>Detalle</th>

    </tr>

</thead>

                    <tbody id="tablaCompras">

                        <tr>

                            <td colspan="5" class="text-center text-muted">

                                Cargando compras...

                            </td>

                        </tr>

                    </tbody>

                </table>

            </div>

        </div>

    </div>

    <div class="text-center mt-4">

        <a href="<%=request.getContextPath()%>/home/home.jsp"
           class="btn btn-secondary">

            <i class="bi bi-arrow-left-circle"></i>

            Volver al inicio

        </a>

    </div>

</div>

<!-- FOOTER -->

<footer class="footer">

    <div class="container text-center">

        <p class="mb-0">

            © 2026 Ecommerce | Todos los derechos reservados.

        </p>

    </div>

</footer>

<script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>