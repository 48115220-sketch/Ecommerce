<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h3 class="text-center">Gestión de Usuarios</h3>
        </div>
        <div class="card-body">
            <table class="table table-hover table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Rol</th>
<th> </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${usuarios}">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.nombre}</td>
                            <td>${u.apellido}</td>
                            <td>${u.email}</td>
                            <td>${u.telefono}</td>
                            <td>${u.rol}</td>
                         <td>
    <a href="${pageContext.request.contextPath}/EditarUsuario?id=${u.id}" 
       class="btn btn-warning btn-sm">Editar</a>
    <a href="${pageContext.request.contextPath}/EliminarUsuario?id=${u.id}"
       class="btn btn-danger btn-sm"
>Eliminar</a>
</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/usuario/index.jsp" class="btn btn-secondary">Volver</a>
        </div>
    </div>
</div>

</body>
</html>