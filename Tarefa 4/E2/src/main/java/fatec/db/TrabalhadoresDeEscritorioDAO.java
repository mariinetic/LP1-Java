package fatec.db;

import fatec.classes.TrabalhadoresDeEscritorio;
import fatec.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabalhadoresDeEscritorioDAO {

    public void inserir(TrabalhadoresDeEscritorio trabalhador) {
        String sql = "INSERT INTO TrabalhadoresDeEscritorio (nome, cargo, salario) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trabalhador.getNome());
            stmt.setString(2, trabalhador.getCargo());
            stmt.setDouble(3, trabalhador.getSalario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TrabalhadoresDeEscritorio buscarPorId(int id) {
        String sql = "SELECT * FROM TrabalhadoresDeEscritorio WHERE id = ?";
        TrabalhadoresDeEscritorio trabalhador = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                trabalhador = new TrabalhadoresDeEscritorio(
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabalhador;
    }

    public List<TrabalhadoresDeEscritorio> listar() {
        String sql = "SELECT * FROM TrabalhadoresDeEscritorio";
        List<TrabalhadoresDeEscritorio> trabalhadores = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TrabalhadoresDeEscritorio trabalhador = new TrabalhadoresDeEscritorio(
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                );
                trabalhadores.add(trabalhador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabalhadores;
    }

    public void atualizar(TrabalhadoresDeEscritorio trabalhador) {
        String sql = "UPDATE TrabalhadoresDeEscritorio SET nome = ?, cargo = ?, salario = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trabalhador.getNome());
            stmt.setString(2, trabalhador.getCargo());
            stmt.setDouble(3, trabalhador.getSalario());
            stmt.setInt(4, trabalhador.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM TrabalhadoresDeEscritorio WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
