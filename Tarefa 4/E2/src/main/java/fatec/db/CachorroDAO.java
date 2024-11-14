package fatec.db;

import fatec.classes.Cachorro;
import fatec.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CachorroDAO {

    public void inserir(Cachorro cachorro) {
        String sql = "INSERT INTO Cachorro (nome, raca, peso, idade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cachorro.getNome());
            stmt.setString(2, cachorro.getRaca());
            stmt.setDouble(3, cachorro.getPeso());
            stmt.setInt(4, cachorro.getIdade());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cachorro buscarPorId(int id) {
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
                        rs.getDouble("peso"),
                        rs.getInt("idade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cachorro;
    }

    public List<Cachorro> listar() {
        String sql = "SELECT * FROM Cachorro";
        List<Cachorro> cachorros = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cachorro cachorro = new Cachorro(
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getDouble("peso"),
                        rs.getInt("idade")
                );
                cachorros.add(cachorro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cachorros;
    }

    public void atualizar(Cachorro cachorro) {
        String sql = "UPDATE Cachorro SET nome = ?, raca = ?, peso = ?, idade = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cachorro.getNome());
            stmt.setString(2, cachorro.getRaca());
            stmt.setDouble(3, cachorro.getPeso());
            stmt.setInt(4, cachorro.getIdade());
            stmt.setInt(5, cachorro.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
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
