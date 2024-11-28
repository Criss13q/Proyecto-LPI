<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Centro Médico Dental</title>
    <style>
        /* Fondo general */
        body {
            background-color: #E6F7F7; /* Azul claro asociado al ámbito médico */
            color: #004d4d; /* Verde oscuro para las letras */
        }

        /* Encabezado */
        header {
            background-color: #009999; /* Verde turquesa médico */
            color: white; /* Letras blancas */
        }

        header h1, header p {
            color: white;
        }

        /* Botones */
        .btn-light {
            background-color: #ffffff; /* Botón blanco */
            color: #009999; /* Letras en turquesa */
        }

        .btn-outline-light {
            border-color: #ffffff;
            color: #ffffff;
        }

        /* Secciones */
        section h2 {
            color: #004d4d; /* Verde oscuro para títulos de sección */
        }

        .btn-outline-primary {
            border-color: #004d4d; /* Borde de los botones */
            color: #004d4d;
        }

        .btn-outline-primary:hover {
            background-color: #004d4d; /* Fondo verde oscuro al pasar el mouse */
            color: white;
        }

        /* Footer */
        footer {
            background-color: #004d4d;
            color: white;
        }
        
        @media (min-width: 768px) {
            .col-md-8 {
                flex: 0 0 auto;
                width: 40%;
            }
        }
    </style>
</head>
<body>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0d6efd;">
        <div class="container">
            <a class="navbar-brand" href="#" style="color: white;">
                <img src="../img/logo.jpg" alt="Centro Médico Dental" style="height: 50px;"> Centro Médico Dental
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Menú">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="../login/login.jsp" style="color: white;">Iniciar Sesión</a></li>
                    <li class="nav-item"><a class="nav-link" href="../registro/registro.jsp" style="color: white;">Registrarse</a></li>
                    <li class="nav-item"><a class="nav-link" href="../citas/citas.jsp" style="color: white;">Agendar Cita</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Encabezado -->
    <header class="text-center py-5">
        <div class="container">
            <h1>Bienvenido al Centro Médico Dental</h1>
            <p class="lead">Cuidamos tu sonrisa con atención profesional y personalizada.</p>
            <a href="../registro/registro.jsp" class="btn btn-light">Regístrate Ahora</a>
            <a href="#" class="btn btn-outline-light ms-3">Contáctanos</a>
        </div>
    </header>

    <!-- Sección de Servicios -->
    <section class="container my-5">
        <h2 class="text-center mb-4">Nuestros Servicios</h2>
        <div class="row">
            <div class="col-md-4 text-center">
                <img src="../img/Nuestros Servicios.jpg" alt="Nuestros Servicios" class="img-fluid rounded-circle">
                <h3 class="mt-3">Tratamientos Dentales</h3>
                <p>Descubre servicios como ortodoncia, limpieza, y más.</p>
                <a href="#" class="btn btn-outline-primary">Ver Más</a>
            </div>
            <div class="col-md-4 text-center">
                <img src="../img/Agendar Cita.jpg" alt="Agendar Cita" class="img-fluid rounded-circle">
                <h3 class="mt-3">Agendar Cita</h3>
                <p>Reserva tu cita en línea de forma rápida y sencilla.</p>
                <a href="#" class="btn btn-outline-primary">Agendar</a>
            </div>
            <div class="col-md-4 text-center">
                <img src="../img/Contáctanos.jpg" alt="Contáctanos" class="img-fluid rounded-circle">
                <h3 class="mt-3">Contáctanos</h3>
                <p>¿Tienes dudas o necesitas información? Estamos para ayudarte.</p>
                <a href="#" class="btn btn-outline-primary">Escríbenos</a>
            </div>
        </div>
    </section>

    <!-- Sección: ¿Por qué elegirnos? -->
    <section class="container my-5">
        <h2 class="text-center mb-4">¿Por qué elegirnos?</h2>
        <div class="row text-center">
            <div class="col-md-4">
                <i class="bi bi-award-fill" style="font-size: 3rem; color: #009999;"></i>
                <h4 class="mt-3">Experiencia</h4>
                <p>Más de 10 años ofreciendo servicios odontológicos de calidad.</p>
            </div>
            <div class="col-md-4">
                <i class="bi bi-heart-fill" style="font-size: 3rem; color: #009999;"></i>
                <h4 class="mt-3">Atención Personalizada</h4>
                <p>Recibe un trato amable y profesional en cada consulta.</p>
            </div>
            <div class="col-md-4">
                <i class="bi bi-building" style="font-size: 3rem; color: #009999;"></i>
                <h4 class="mt-3">Instalaciones Modernas</h4>
                <p>Disponemos de tecnología avanzada y un ambiente cómodo.</p>
            </div>
        </div>
    </section>

<!-- Testimonios -->
<section class="bg-light py-5">
    <div class="container text-center">
        <h2 class="mb-4">Lo que dicen nuestros pacientes</h2>
        <div class="row">
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"El mejor servicio dental que he recibido. Muy profesionales y atentos."</p>
                    <footer class="blockquote-footer">Juan Pérez</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Los odontólogos son muy amables y explican todo claramente."</p>
                    <footer class="blockquote-footer">María Gómez</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Excelentes instalaciones y atención personalizada. Muy recomendados."</p>
                    <footer class="blockquote-footer">Carlos López</footer>
                </blockquote>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Me sentí muy cómodo durante mi tratamiento. Definitivamente volveré."</p>
                    <footer class="blockquote-footer">Laura Sánchez</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"La limpieza del lugar y la profesionalidad del personal me encantaron."</p>
                    <footer class="blockquote-footer">Miguel Torres</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Nunca pensé que una visita al dentista podría ser tan agradable. ¡Gracias!"</p>
                    <footer class="blockquote-footer">Ana Morales</footer>
                </blockquote>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Desde que empecé a atenderme aquí, mi salud dental ha mejorado enormemente."</p>
                    <footer class="blockquote-footer">Luis Fernández</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Los tratamientos son rápidos, efectivos y el personal siempre es amable."</p>
                    <footer class="blockquote-footer">Sofía Castillo</footer>
                </blockquote>
            </div>
            <div class="col-md-4">
                <blockquote class="blockquote">
                    <p>"Recomendaría esta clínica a todos mis amigos y familiares."</p>
                    <footer class="blockquote-footer">Ricardo Ortega</footer>
                </blockquote>
            </div>
        </div>
    </div>
</section>


    <!-- Horarios de Atención -->
    <section class="container my-5">
        <h2 class="text-center mb-4">Horarios de Atención</h2>
        <div class="row text-center">
            <div class="col-md-6">
                <h4>Consultorio Principal</h4>
                <p>Lunes a Viernes: 8:00 AM - 6:00 PM</p>
                <p>Sábado: 9:00 AM - 1:00 PM</p>
            </div>
            <div class="col-md-6">
                <h4>Urgencias Dentales</h4>
                <p>Disponible 24/7 llamando al: <strong>+123 456 789</strong></p>
            </div>
        </div>
    </section>

    <!-- Equipo Médico -->
    <section class="container my-5">
        <h2 class="text-center mb-4">Nuestro Equipo Médico</h2>
        <div class="row text-center">
            <div class="col-md-4">
                <img src="../img/Dr. Juan Pérez.jpg" alt="Dr. Juan Pérez" class="img-fluid rounded-circle mb-3" style="width: 150px;">
                <h5>Dr. Juan Pérez</h5>
                <p>Especialista en Ortodoncia</p>
            </div>
            <div class="col-md-4">
                <img src="../img/Dra. María Gómez.jpg" alt="Dra. María Gómez" class="img-fluid rounded-circle mb-3" style="width: 150px;">
                <h5>Dra. María Gómez</h5>
                <p>Especialista en Endodoncia</p>
            </div>
            <div class="col-md-4">
                <img src="../img/Dr. Carlos López.jpg" alt="Dr. Carlos López" class="img-fluid rounded-circle mb-3" style="width: 150px;">
                <h5>Dr. Carlos López</h5>
                <p>Especialista en Implantología</p>
            </div>
        </div>
    </section>
    
    <!-- Formulario de Quejas -->
    <section class="container my-5">
        <h2 class="text-center mb-4">Registra tu Queja</h2>
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-lg border-0">
                    <div class="card-header bg-primary text-white text-center">
                        <h4>Formulario de Registro</h4>
                    </div>
                    <div class="card-body">
                        <form action="quejas?type=registrar" method="post">
                            <!-- Nombre -->
                            <div class="mb-4">
                                <label for="nombre" class="form-label">Nombre Completo <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-light"><i class="bi bi-person-fill"></i></span>
                                    <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese su nombre completo" required>
                                </div>
                            </div>
                            <!-- Correo -->
                            <div class="mb-4">
                                <label for="correo" class="form-label">Correo Electrónico <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-light"><i class="bi bi-envelope-fill"></i></span>
                                    <input type="email" id="correo" name="correo" class="form-control" placeholder="Ingrese su correo electrónico" required>
                                </div>
                            </div>
                            <!-- Teléfono -->
                            <div class="mb-4">
                                <label for="telefono" class="form-label">Teléfono <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-light"><i class="bi bi-telephone-fill"></i></span>
                                    <input type="text" id="telefono" name="telefono" class="form-control" placeholder="Ingrese su número de teléfono" required>
                                </div>
                            </div>
                            <!-- Detalles -->
                            <div class="mb-4">
                                <label for="detalle" class="form-label">Detalles de la Queja <span class="text-danger">*</span></label>
                                <textarea id="detalle" name="detalle" class="form-control" rows="5" placeholder="Describa su queja" required></textarea>
                            </div>
                            <!-- Botón de envío -->
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-lg w-100">
                                    <i class="bi bi-send-fill"></i> Registrar Queja
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer text-muted text-center">
                        <small>Nos esforzamos por brindarte el mejor servicio.</small>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Validaciones con jQuery -->
    <script>
        $(document).ready(function () {
            $("form").on("submit", function (event) {
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

                // Validación de teléfono
                const telefono = $("#telefono").val().trim();
                const telefonoRegex = /^[0-9]{10}$/;
                if (telefono.length === 0) {
                    alert("El campo 'Teléfono' es obligatorio.");
                    isValid = false;
                } else if (!telefonoRegex.test(telefono)) {
                    alert("Por favor, ingrese un número de teléfono válido (10 dígitos).");
                    isValid = false;
                }

                // Validación de detalles
                const detalle = $("#detalle").val().trim();
                if (detalle.length === 0) {
                    alert("El campo 'Detalles de la Queja' es obligatorio.");
                    isValid = false;
                }

                // Si no es válido, se previene el envío del formulario
                if (!isValid) {
                    event.preventDefault();
                }
            });
        });
    </script>

    <!-- Pie de página -->
    <footer class="text-center py-4">
        <p>&copy;  2024 Centro Médico Dental | Todos los derechos reservados.</p>
    </footer>

    <!-- Botón flotante de WhatsApp -->
    <a href="https://wa.me/123456789" class="btn btn-success position-fixed" style="bottom: 20px; right: 20px; z-index: 1000;" target="_blank">
        <img src="../img/WhatsApp.jpg" alt="WhatsApp" style="width: 24px; height: 24px;">
        Contáctanos
    </a>
</body>
</html>
