package servlets;

import entidades.Usuario;
import modelos.UsuarioModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "usuario", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final UsuarioModel usuarioModel = new UsuarioModel();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "registrar":
                    registrarUsuario(request, response);
                    break;
                case "iniciarSesion":
                    iniciarSesion(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");

        Usuario usuario = new Usuario(nombre, correo, telefono, contrasena);

        try {
            usuarioModel.registrarUsuario(usuario);
            response.sendRedirect("login/login.jsp");
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar el usuario: " + e.getMessage());
            request.getRequestDispatcher("registro/registro.jsp").forward(request, response);
        }
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        try {
            Usuario usuario = usuarioModel.iniciarSesion(correo, contrasena);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                response.sendRedirect("inicio/index.jsp");
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos.");
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al iniciar sesión: " + e.getMessage());
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }
    }
}
