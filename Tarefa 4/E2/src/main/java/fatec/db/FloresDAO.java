package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Flores;

public class FloresDAO {

    public void inserir(Flores flores) {
        String sql = "INSERT INTO Flores (nome, cor, tipo) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flores.getNome());
            stmt.setString(2, flores.getCor());
            stmt.setString(3, flores.getTipo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Flores buscarPorId(int id) {
        String sql = "SELECT * FROM Flores WHERE id = ?";
        Flores flores = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                flores = new Flores(
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flores;
    }

    public List<Flores> listar() {
        String sql = "SELECT * FROM Flores";
        List<Flores> floresList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Flores flores = new Flores(
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("tipo")
                );
                floresList.add(flores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return floresList;
    }

    public void atualizar(Flores flores) {
        String sql = "UPDATE Flores SET nome = ?, cor = ?, tipo = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flores.getNome());
            stmt.setString(2, flores.getCor());
            stmt.setString(3, flores.getTipo());
            stmt.setInt(4, flores.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Flores WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
