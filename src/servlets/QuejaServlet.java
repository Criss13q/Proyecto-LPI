package servlets;

import entidades.Queja;
import modelos.QuejaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queja", urlPatterns = {"/queja"})
public class QuejaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final QuejaModel quejaModel = new QuejaModel();

    public QuejaServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "registrar":
                    registrarQueja(request, response);
                    break;
                case "listar":
                    listarQuejas(request, response);
                    break;
                case "eliminar":
                    eliminarQueja(request, response);
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

    private void registrarQueja(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nombreCliente = request.getParameter("nombre");
        String correoCliente = request.getParameter("correo");
        String telefonoCliente = request.getParameter("telefono");
        String detalle = request.getParameter("detalle");

        Queja queja = new Queja(nombreCliente, correoCliente, telefonoCliente, detalle);

        try {
            quejaModel.registrarQueja(queja);
            response.sendRedirect("inicio/index.jsp");
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar la queja: " + e.getMessage());
            request.getRequestDispatcher("quejas/quejas.jsp").forward(request, response);
        }
    }

    private void listarQuejas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<Queja> quejas = quejaModel.listarQuejas();
            request.setAttribute("quejas", quejas);
            request.getRequestDispatcher("quejas/quejas.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar las quejas: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void eliminarQueja(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idQueja = Integer.parseInt(request.getParameter("idQueja"));

        try {
            quejaModel.eliminarQueja(idQueja);
            response.sendRedirect("queja?action=listar");
        } catch (Exception e) {
            request.setAttribute("error", "Error al eliminar la queja: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
