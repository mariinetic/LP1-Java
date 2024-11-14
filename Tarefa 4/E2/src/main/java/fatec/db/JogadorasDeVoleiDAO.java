package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.JogadorasDeVolei;

public class JogadorasDeVoleiDAO {

    public void inserir(JogadorasDeVolei jogadora) {
        String sql = "INSERT INTO JogadorasDeVolei (nome, posicao, altura, numeroCamisa) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jogadora.getNome());
            stmt.setString(2, jogadora.getPosicao());
            stmt.setDouble(3, jogadora.getAltura());
            stmt.setInt(4, jogadora.getNumeroCamisa());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JogadorasDeVolei buscarPorId(int id) {
        String sql = "SELECT * FROM JogadorasDeVolei WHERE id = ?";
        JogadorasDeVolei jogadora = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                jogadora = new JogadorasDeVolei(
                        rs.getString("nome"),
                        rs.getString("posicao"),
                        rs.getDouble("altura"),
                        rs.getInt("numeroCamisa")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jogadora;
    }

    public List<JogadorasDeVolei> listar() {
        String sql = "SELECT * FROM JogadorasDeVolei";
        List<JogadorasDeVolei> jogadoras = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                JogadorasDeVolei jogadora = new JogadorasDeVolei(
                        rs.getString("nome"),
                        rs.getString("posicao"),
                        rs.getDouble("altura"),
                        rs.getInt("numeroCamisa")
                );
                jogadoras.add(jogadora);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jogadoras;
    }

    public void atualizar(JogadorasDeVolei jogadora) {
        String sql = "UPDATE JogadorasDeVolei SET nome = ?, posicao = ?, altura = ?, numeroCamisa = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jogadora.getNome());
            stmt.setString(2, jogadora.getPosicao());
            stmt.setDouble(3, jogadora.getAltura());
            stmt.setInt(4, jogadora.getNumeroCamisa());
            stmt.setInt(5, jogadora.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM JogadorasDeVolei WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
