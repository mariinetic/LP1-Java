package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Sanrio;

public class SanrioDAO {

    public void inserir(Sanrio sanrio) {
        String sql = "INSERT INTO Sanrio (nome, comida_fav, cor, idade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sanrio.getNome());
            stmt.setString(2, sanrio.getComidaFav());
            stmt.setString(3, sanrio.getCor());
            stmt.setInt(4, sanrio.getIdade());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sanrio buscarPorId(int id) {
        String sql = "SELECT * FROM Sanrio WHERE id = ?";
        Sanrio sanrio = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sanrio = new Sanrio(
                        rs.getString("nome"),
                        rs.getString("comida_fav"),
                        rs.getString("cor"),
                        rs.getInt("idade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanrio;
    }

    public List<Sanrio> listar() {
        String sql = "SELECT * FROM Sanrio";
        List<Sanrio> sanrios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sanrio sanrio = new Sanrio(
                        rs.getString("nome"),
                        rs.getString("comida_fav"),
                        rs.getString("cor"),
                        rs.getInt("idade")
                );
                sanrios.add(sanrio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanrios;
    }

    public void atualizar(Sanrio sanrio) {
        String sql = "UPDATE Sanrio SET nome = ?, comida_fav = ?, cor = ?, idade = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sanrio.getNome());
            stmt.setString(2, sanrio.getComidaFav());
            stmt.setString(3, sanrio.getCor());
            stmt.setInt(4, sanrio.getIdade());
            stmt.setInt(5, sanrio.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Sanrio WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
