package interfaces;

import entidades.Usuario;
import java.util.List;

public interface UsuarioInterface {
	   // Crear un nuevo usuario
    void registrarUsuario(Usuario usuario) throws Exception;

    // Obtener un usuario por ID
    Usuario obtenerUsuarioPorId(int idUsuario) throws Exception;

    // Obtener un usuario por correo
    Usuario obtenerUsuarioPorCorreo(String correo) throws Exception;

    // Listar todos los usuarios
    List<Usuario> listarUsuarios() throws Exception;

    // Actualizar un usuario existente
    void actualizarUsuario(Usuario usuario) throws Exception;

    // Eliminar un usuario por ID
    void eliminarUsuario(int idUsuario) throws Exception;
}
