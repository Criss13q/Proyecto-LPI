package servlets;

import entidades.Cita;
import modelos.CitaModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@WebServlet(name = "cita", urlPatterns = {"/cita"})
public class CitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CitaModel citaModel = new CitaModel();

    public CitaServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "registrar":
                    registrarCita(request, response);
                    break;
                case "listar":
                    listarCitas(request, response);
                    break;
                case "listarPorUsuario":
                    listarCitasPorUsuario(request, response);
                    break;
                case "eliminar":
                    eliminarCita(request, response);
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

    private void registrarCita(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        Time hora = Time.valueOf(request.getParameter("hora"));
        String descripcion = request.getParameter("descripcion");

        Cita cita = new Cita(idUsuario, fecha, hora, descripcion);

        try {
            citaModel.registrarCita(cita);
            response.sendRedirect("citas/citas.jsp");
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar la cita: " + e.getMessage());
            request.getRequestDispatcher("citas/citas.jsp").forward(request, response);
        }
    }

    private void listarCitas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<Cita> citas = citaModel.listarCitas();
            request.setAttribute("citas", citas);
            request.getRequestDispatcher("citas/citas.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar las citas: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void listarCitasPorUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        try {
            List<Cita> citas = citaModel.listarCitasPorUsuario(idUsuario);
            request.setAttribute("citas", citas);
            request.getRequestDispatcher("citas/citasUsuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar las citas por usuario: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void eliminarCita(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int idCita = Integer.parseInt(request.getParameter("idCita"));

        try {
            citaModel.eliminarCita(idCita);
            response.sendRedirect("cita?action=listar");
        } catch (Exception e) {
            request.setAttribute("error", "Error al eliminar la cita: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
