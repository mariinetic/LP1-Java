package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Planeta;

public class PlanetaDAO {

    public void inserir(Planeta planeta) {
        String sql = "INSERT INTO planeta (nome, massa, diametro, distanciaDoSol, temAnel) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, planeta.getNome());
            stmt.setDouble(2, planeta.getMassa());
            stmt.setDouble(3, planeta.getDiametro());
            stmt.setDouble(4, planeta.getDistanciaDoSol());
            stmt.setBoolean(5, planeta.isTemAnel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Planeta buscarPorId(int id) {
        String sql = "SELECT * FROM planeta WHERE id = ?";
        Planeta planeta = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                planeta = new Planeta(
                        rs.getString("nome"),
                        rs.getDouble("massa"),
                        rs.getDouble("diametro"),
                        rs.getDouble("distanciaDoSol"),
                        rs.getBoolean("temAnel")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planeta;
    }

    public List<Planeta> listar() {
        String sql = "SELECT * FROM planeta";
        List<Planeta> planetas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Planeta planeta = new Planeta(
                        rs.getString("nome"),
                        rs.getDouble("massa"),
                        rs.getDouble("diametro"),
                        rs.getDouble("distanciaDoSol"),
                        rs.getBoolean("temAnel")
                );
                planetas.add(planeta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planetas;
    }

    public void atualizar(Planeta planeta) {
        String sql = "UPDATE planeta SET nome = ?, massa = ?, diametro = ?, distanciaDoSol = ?, temAnel = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, planeta.getNome());
            stmt.setDouble(2, planeta.getMassa());
            stmt.setDouble(3, planeta.getDiametro());
            stmt.setDouble(4, planeta.getDistanciaDoSol());
            stmt.setBoolean(5, planeta.isTemAnel());
            stmt.setInt(6, planeta.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM planeta WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
