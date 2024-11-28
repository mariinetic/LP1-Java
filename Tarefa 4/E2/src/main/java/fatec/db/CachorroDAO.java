package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Cachorro;

public class CachorroDAO {

    public static void inserir(Cachorro cachorro) {
        String sql = "INSERT INTO Cachorro (nome, raca, peso) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cachorro.getNome());
            stmt.setString(2, cachorro.getRaca());
            stmt.setDouble(3, cachorro.getPeso());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Cachorro buscarPorId(int id) {
        String sql = "SELECT * FROM Cachorro WHERE id = ?";
        Cachorro cachorro = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cachorro = new Cachorro(
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getDouble("peso")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cachorro;
    }

    public static List<Cachorro> listar() {
        String sql = "SELECT * FROM Cachorro";
        List<Cachorro> cachorros = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cachorro cachorro = new Cachorro(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getDouble("peso")
                );
                cachorros.add(cachorro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cachorros;
    }

    public static void atualizar(Cachorro cachorro) {
        String sql = "UPDATE Cachorro SET nome = ?, raca = ?, peso = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cachorro.getNome());
            stmt.setString(2, cachorro.getRaca());
            stmt.setDouble(3, cachorro.getPeso());
            stmt.setInt(4, cachorro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM Cachorro WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
