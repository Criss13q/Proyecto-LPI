package modelos;

import entidades.Usuario;
import utils.MySQLConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioModel {

    public void registrarUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuarios (nombre, correo, telefono, contrasena) VALUES (?, ?, ?, ?)";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getContrasena());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el usuario: " + e.getMessage(), e);
        }
    }

    public Usuario iniciarSesion(String correo, String contrasena) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al iniciar sesión: " + e.getMessage(), e);
        }
        return null;
    }
}
