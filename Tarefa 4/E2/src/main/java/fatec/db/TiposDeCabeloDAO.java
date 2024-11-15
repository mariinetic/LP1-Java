package fatec.db;

import fatec.classes.TiposDeCabelo;
import fatec.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiposDeCabeloDAO {

    public void inserir(TiposDeCabelo cabelo) {
        String sql = "INSERT INTO TiposDeCabelo (tipo, cor, comprimento, is_natural) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cabelo.getTipo());
            stmt.setString(2, cabelo.getCor());
            stmt.setDouble(3, cabelo.getComprimento());
            stmt.setBoolean(4, cabelo.isNatural());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TiposDeCabelo buscarPorId(int id) {
        String sql = "SELECT * FROM TiposDeCabelo WHERE id = ?";
        TiposDeCabelo cabelo = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cabelo = new TiposDeCabelo(
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDouble("comprimento"),
                        rs.getBoolean("is_natural")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cabelo;
    }

    public List<TiposDeCabelo> listar() {
        String sql = "SELECT * FROM TiposDeCabelo";
        List<TiposDeCabelo> cabelos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TiposDeCabelo cabelo = new TiposDeCabelo(
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDouble("comprimento"),
                        rs.getBoolean("is_natural")
                );
                cabelos.add(cabelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cabelos;
    }

    public void atualizar(TiposDeCabelo cabelo) {
        String sql = "UPDATE TiposDeCabelo SET tipo = ?, cor = ?, comprimento = ?, is_natural = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cabelo.getTipo());
            stmt.setString(2, cabelo.getCor());
            stmt.setDouble(3, cabelo.getComprimento());
            stmt.setBoolean(4, cabelo.isNatural());
            stmt.setInt(5, cabelo.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM TiposDeCabelo WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
