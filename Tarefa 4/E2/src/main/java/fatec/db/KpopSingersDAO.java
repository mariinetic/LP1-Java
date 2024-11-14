package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.KpopSingers;

public class KpopSingersDAO {

    public void inserir(KpopSingers singer) {
        String sql = "INSERT INTO KpopSingers (nome, idade, grupo, altura) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, singer.getNome());
            stmt.setInt(2, singer.getIdade());
            stmt.setString(3, singer.getGrupo());
            stmt.setDouble(4, singer.getAltura());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public KpopSingers buscarPorId(int id) {
        String sql = "SELECT * FROM KpopSingers WHERE id = ?";
        KpopSingers singer = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                singer = new KpopSingers(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("grupo"),
                        rs.getDouble("altura")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return singer;
    }

    public List<KpopSingers> listar() {
        String sql = "SELECT * FROM KpopSingers";
        List<KpopSingers> singers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                KpopSingers singer = new KpopSingers(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("grupo"),
                        rs.getDouble("altura")
                );
                singers.add(singer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return singers;
    }

    public void atualizar(KpopSingers singer) {
        String sql = "UPDATE KpopSingers SET nome = ?, idade = ?, grupo = ?, altura = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, singer.getNome());
            stmt.setInt(2, singer.getIdade());
            stmt.setString(3, singer.getGrupo());
            stmt.setDouble(4, singer.getAltura());
            stmt.setInt(5, singer.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM KpopSingers WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}