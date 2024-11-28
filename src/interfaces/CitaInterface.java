package interfaces;
import entidades.Cita;
import java.util.List;

public interface CitaInterface {
    // Crear una nueva cita
    void registrarCita(Cita cita) throws Exception;

    // Obtener una cita por ID
    Cita obtenerCitaPorId(int idCita) throws Exception;

    // Listar todas las citas
    List<Cita> listarCitas() throws Exception;

    // Listar citas por usuario
    List<Cita> listarCitasPorUsuario(int idUsuario) throws Exception;

    // Actualizar una cita existente
    void actualizarCita(Cita cita) throws Exception;

    // Eliminar una cita por ID
    void eliminarCita(int idCita) throws Exception;
}