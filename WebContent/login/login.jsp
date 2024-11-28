<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            background-color: #f0f8ff; /* Fondo claro */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-card {
            max-width: 400px;
            padding: 2rem;
            border-radius: 8px;
            background-color: #f8f9fa; /* Fondo blanco para el formulario */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .form-text {
            color: red;
            font-size: 0.875rem;
        }
    </style>
</head>
<body>
    <div class="login-card">
        <h3 class="text-center mb-4">Iniciar Sesión</h3>
        <form id="loginForm" action="LoginServlet" method="POST">
            <!-- Campo Usuario -->
            <div class="mb-3">
                <label for="username" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Ingrese su usuario" required>
                <div class="form-text">Ingrese su usuario</div>
            </div>
            <!-- Campo Contraseña -->
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña" required>
                <div class="form-text">Ingrese su contraseña</div>
            </div>
            <!-- Botón de inicio de sesión -->
            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-lg">Iniciar Sesión</button>
            </div>
        </form>
    </div>

    <!-- Validaciones con jQuery -->
    <script>
        $(document).ready(function () {
            $("#loginForm").on("submit", function (event) {
                let isValid = true;

                // Validación de usuario
                const username = $("#username").val().trim();
                if (username.length === 0) {
                    alert("El campo 'Usuario' es obligatorio.");
                    isValid = false;
                } else if (username.length < 3) {
                    alert("El nombre de usuario debe tener al menos 3 caracteres.");
                    isValid = false;
                }

                // Validación de contraseña
                const password = $("#password").val().trim();
                if (password.length === 0) {
                    alert("El campo 'Contraseña' es obligatorio.");
                    isValid = false;
                } else if (password.length < 6) {
                    alert("La contraseña debe tener al menos 6 caracteres.");
                    isValid = false;
                }

                // Si no es válido, prevenir envío del formulario
                if (!isValid) {
                    event.preventDefault();
                }
            });
        });
    </script>
</body>
</html>
