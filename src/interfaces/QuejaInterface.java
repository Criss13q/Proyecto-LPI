package interfaces;

import entidades.Queja;
import java.util.List;
public interface QuejaInterface {

    // Crear una nueva queja
    void registrarQueja(Queja queja) throws Exception;

    // Obtener una queja por ID
    Queja obtenerQuejaPorId(int idQueja) throws Exception;

    // Listar todas las quejas
    List<Queja> listarQuejas() throws Exception;

    // Listar quejas por usuario
    List<Queja> listarQuejasPorUsuario(int idUsuario) throws Exception;

    // Actualizar una queja existente
    void actualizarQueja(Queja queja) throws Exception;

    // Eliminar una queja por ID
    void eliminarQueja(int idQueja) throws Exception;
}