package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Planeta;

public class PlanetaDAO {

    public static void inserir(Planeta planeta) {
        String sql = "INSERT INTO planeta (nome, diametro, distanciaDoSol, temAnel) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, planeta.getNome());
            stmt.setDouble(2, planeta.getDiametro());
            stmt.setDouble(3, planeta.getDistanciaDoSol());
            stmt.setBoolean(4, planeta.getIsTemAnel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Planeta buscarPorId(int id) {
        String sql = "SELECT * FROM planeta WHERE id = ?";
        Planeta planeta = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                planeta = new Planeta(
                        rs.getInt("id"),
                        rs.getString("nome"),
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

    public static List<Planeta> listar() {
        String sql = "SELECT * FROM planeta";
        List<Planeta> planetas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Planeta planeta = new Planeta(
                        rs.getInt("id"),
                        rs.getString("nome"),
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

    public static void atualizar(Planeta planeta) {
        String sql = "UPDATE planeta SET nome = ?, diametro = ?, distanciaDoSol = ?, temAnel = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, planeta.getNome());
            stmt.setDouble(2, planeta.getDiametro());
            stmt.setDouble(3, planeta.getDistanciaDoSol());
            stmt.setBoolean(4, planeta.getIsTemAnel());
            stmt.setInt(5, planeta.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM planeta WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
