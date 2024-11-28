<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Agendar Cita</title>
<style>
    body {
        background-color: #f0f8ff; 
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .appointment-card {
        max-width: 600px;
        padding: 2rem;
        border-radius: 8px;
        background-color: #f8f9fa;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 40%;
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
</style>
</head>
<body>
    <div class="appointment-card">
        <h3 class="text-center mb-4">Agendar Cita</h3>
        <form id="appointmentForm" action="CitasServlet" method="POST">
            <!-- Nombre Completo -->
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre Completo</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre completo" required>
            </div>
            <!-- Correo Electrónico -->
            <div class="mb-3">
                <label for="correo" class="form-label">Correo Electrónico</label>
                <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingrese su correo electrónico" required>
            </div>
            <!-- Fecha de la Cita -->
            <div class="mb-3">
                <label for="fecha" class="form-label">Fecha de la Cita</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>
            <!-- Hora de la Cita -->
            <div class="mb-3">
                <label for="hora" class="form-label">Hora de la Cita</label>
                <input type="time" class="form-control" id="hora" name="hora" required>
            </div>
            <!-- Descripción -->
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="4" placeholder="Escriba detalles adicionales"></textarea>
            </div>
            <!-- Botón de Agendar -->
            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-lg">Agendar Cita</button>
            </div>
        </form>
    </div>

    <!-- Validaciones con jQuery -->
    <script>
        $(document).ready(function () {
            $("#appointmentForm").on("submit", function (event) {
                let isValid = true;

                // Validación de nombre
                const nombre = $("#nombre").val().trim();
                if (nombre.length === 0) {
                    alert("El campo 'Nombre Completo' es obligatorio.");
                    isValid = false;
                }

                // Validación de correo
                const correo = $("#correo").val().trim();
                const correoRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (correo.length === 0) {
                    alert("El campo 'Correo Electrónico' es obligatorio.");
                    isValid = false;
                } else if (!correoRegex.test(correo)) {
                    alert("Por favor, ingrese un correo electrónico válido.");
                    isValid = false;
                }

                // Validación de fecha
                const fecha = $("#fecha").val().trim();
                if (fecha.length === 0) {
                    alert("El campo 'Fecha de la Cita' es obligatorio.");
                    isValid = false;
                }

                // Validación de hora
                const hora = $("#hora").val().trim();
                if (hora.length === 0) {
                    alert("El campo 'Hora de la Cita' es obligatorio.");
                    isValid = false;
                }

                // Validación de descripción (opcional)
                const descripcion = $("#descripcion").val().trim();
                if (descripcion.length > 0 && descripcion.length < 10) {
                    alert("Si incluye una descripción, debe tener al menos 10 caracteres.");
                    isValid = false;
                }

                // Si no es válido, se previene el envío del formulario
                if (!isValid) {
                    event.preventDefault();
                }
            });
        });
    </script>
</body>
</html>
