<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h3 class="text-center">Editar Usuario</h3>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/EditarUsuario" method="post">

                        <input type="hidden" name="id" value="${usuario.id}">

                        <div class="mb-3">
                            <label>Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" required>
                        </div>

                        <div class="mb-3">
                            <label>Apellido</label>
                            <input type="text" class="form-control" name="apellido" value="${usuario.apellido}" required>
                        </div>

                        <div class="mb-3">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" value="${usuario.email}" required>
                        </div>

                        <div class="mb-3">
                            <label>Teléfono</label>
                            <input type="text" class="form-control" name="telefono" value="${usuario.telefono}">
                        </div>

                        <button type="submit" class="btn btn-primary w-100 text-white">Guardar Cambios</button>
                        <a href="${pageContext.request.contextPath}/LeerDatosUsuario" class="btn btn-secondary w-100 mt-2">Cancelar</a>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>