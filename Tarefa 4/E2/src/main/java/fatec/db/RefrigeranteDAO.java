package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Refrigerante;

public class RefrigeranteDAO {

    public void inserir(Refrigerante refrigerante) {
        String sql = "INSERT INTO refrigerante (nome, sabor, marca, volumeML, diet) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, refrigerante.getNome());
            stmt.setString(2, refrigerante.getSabor());
            stmt.setString(3, refrigerante.getMarca());
            stmt.setInt(4, refrigerante.getVolumeML());
            stmt.setBoolean(5, refrigerante.isDiet());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Refrigerante buscarPorId(int id) {
        String sql = "SELECT * FROM refrigerante WHERE id = ?";
        Refrigerante refrigerante = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                refrigerante = new Refrigerante(
                        rs.getString("nome"),
                        rs.getString("sabor"),
                        rs.getString("marca"),
                        rs.getInt("volumeML"),
                        rs.getBoolean("diet")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return refrigerante;
    }

    public List<Refrigerante> listar() {
        String sql = "SELECT * FROM refrigerante";
        List<Refrigerante> refrigerantes = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Refrigerante refrigerante = new Refrigerante(
                        rs.getString("nome"),
                        rs.getString("sabor"),
                        rs.getString("marca"),
                        rs.getInt("volumeML"),
                        rs.getBoolean("diet")
                );
                refrigerantes.add(refrigerante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return refrigerantes;
    }

    public void atualizar(Refrigerante refrigerante) {
        String sql = "UPDATE refrigerante SET nome = ?, sabor = ?, marca = ?, volumeML = ?, diet = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, refrigerante.getNome());
            stmt.setString(2, refrigerante.getSabor());
            stmt.setString(3, refrigerante.getMarca());
            stmt.setInt(4, refrigerante.getVolumeML());
            stmt.setBoolean(5, refrigerante.isDiet());
            stmt.setInt(6, refrigerante.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM refrigerante WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
