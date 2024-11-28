package modelos;

import entidades.Cita;
import interfaces.CitaInterface;
import utils.MySQLConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaModel implements CitaInterface {

    @Override
    public void registrarCita(Cita cita) throws Exception {
        String sql = "INSERT INTO citas (id_usuario, fecha, hora, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cita.getIdUsuario());
            ps.setDate(2, cita.getFecha());
            ps.setTime(3, cita.getHora());
            ps.setString(4, cita.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar la cita: " + e.getMessage(), e);
        }
    }

    @Override
    public Cita obtenerCitaPorId(int idCita) throws Exception {
        String sql = "SELECT * FROM citas WHERE id_cita = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCita);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cita(
                        rs.getInt("id_cita"),
                        rs.getInt("id_usuario"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("descripcion"),
                        rs.getTimestamp("fecha_creacion")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la cita: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Cita> listarCitas() throws Exception {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Connection conn = MySQLConexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                citas.add(new Cita(
                    rs.getInt("id_cita"),
                    rs.getInt("id_usuario"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("descripcion"),
                    rs.getTimestamp("fecha_creacion")
                ));
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar las citas: " + e.getMessage(), e);
        }
        return citas;
    }

    @Override
    public List<Cita> listarCitasPorUsuario(int idUsuario) throws Exception {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas WHERE id_usuario = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    citas.add(new Cita(
                        rs.getInt("id_cita"),
                        rs.getInt("id_usuario"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("descripcion"),
                        rs.getTimestamp("fecha_creacion")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar citas por usuario: " + e.getMessage(), e);
        }
        return citas;
    }

    @Override
    public void actualizarCita(Cita cita) throws Exception {
        String sql = "UPDATE citas SET fecha = ?, hora = ?, descripcion = ? WHERE id_cita = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, cita.getFecha());
            ps.setTime(2, cita.getHora());
            ps.setString(3, cita.getDescripcion());
            ps.setInt(4, cita.getIdCita());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la cita: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminarCita(int idCita) throws Exception {
        String sql = "DELETE FROM citas WHERE id_cita = ?";
        try (Connection conn = MySQLConexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCita);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la cita: " + e.getMessage(), e);
        }
    }
}
