<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h2>Gestión de Usuarios</h2>
                </div>

                <div class="card-body d-flex flex-column gap-3 mt-2">
                    <a href="<%= request.getContextPath() %>/LoadUsuarioForm" 
                       class="btn btn-success btn-lg">
                         Crear Usuario
                    </a>
                    <a href="<%= request.getContextPath() %>/LeerDatosUsuario" 
                       class="btn btn-success btn-lg">
                         Listar Usuarios
                    </a>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>