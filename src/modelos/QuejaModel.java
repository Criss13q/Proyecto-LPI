package modelos;

import entidades.Queja;
import interfaces.QuejaInterface;
import utils.MySQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuejaModel implements QuejaInterface {

    @Override
    public void registrarQueja(Queja queja) throws Exception {
        String sql = "INSERT INTO quejas (id_usuario, nombre_cliente, correo_cliente, telefono_cliente, detalle) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, queja.getIdUsuario());
            ps.setString(2, queja.getNombreCliente());
            ps.setString(3, queja.getCorreoCliente());
            ps.setString(4, queja.getTelefonoCliente());
            ps.setString(5, queja.getDetalle());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar la queja: " + e.getMessage(), e);
        }
    }

    @Override
    public Queja obtenerQuejaPorId(int idQueja) throws Exception {
        String sql = "SELECT * FROM quejas WHERE id_queja = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idQueja);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Queja(
                        rs.getInt("id_queja"),
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_cliente"),
                        rs.getString("correo_cliente"),
                        rs.getString("telefono_cliente"),
                        rs.getString("detalle"),
                        rs.getTimestamp("fecha_registro")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la queja: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Queja> listarQuejas() throws Exception {
        List<Queja> quejas = new ArrayList<>();
        String sql = "SELECT * FROM quejas";
        try (Connection conn = MySQLConexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                quejas.add(new Queja(
                    rs.getInt("id_queja"),
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_cliente"),
                    rs.getString("correo_cliente"),
                    rs.getString("telefono_cliente"),
                    rs.getString("detalle"),
                    rs.getTimestamp("fecha_registro")
                ));
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar las quejas: " + e.getMessage(), e);
        }
        return quejas;
    }

    @Override
    public List<Queja> listarQuejasPorUsuario(int idUsuario) throws Exception {
        List<Queja> quejas = new ArrayList<>();
        String sql = "SELECT * FROM quejas WHERE id_usuario = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    quejas.add(new Queja(
                        rs.getInt("id_queja"),
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_cliente"),
                        rs.getString("correo_cliente"),
                        rs.getString("telefono_cliente"),
                        rs.getString("detalle"),
                        rs.getTimestamp("fecha_registro")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar quejas por usuario: " + e.getMessage(), e);
        }
        return quejas;
    }

    @Override
    public void actualizarQueja(Queja queja) throws Exception {
        String sql = "UPDATE quejas SET nombre_cliente = ?, correo_cliente = ?, telefono_cliente = ?, detalle = ? WHERE id_queja = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, queja.getNombreCliente());
            ps.setString(2, queja.getCorreoCliente());
            ps.setString(3, queja.getTelefonoCliente());
            ps.setString(4, queja.getDetalle());
            ps.setInt(5, queja.getIdQueja());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la queja: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminarQueja(int idQueja) throws Exception {
        String sql = "DELETE FROM quejas WHERE id_queja = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idQueja);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la queja: " + e.getMessage(), e);
        }
    }
}

