package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.TiposDeCabelo;

public class TiposDeCabeloDAO {

    public static void inserir(TiposDeCabelo cabelo) {
        String sql = "INSERT INTO TiposDeCabelo (tipo, cor, comprimento, isNatural) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cabelo.getTipo());
            stmt.setString(2, cabelo.getCor());
            stmt.setDouble(3, cabelo.getComprimento());
            stmt.setBoolean(4, cabelo.getIsNatural());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static TiposDeCabelo buscarPorId(int id) {
        String sql = "SELECT * FROM TiposDeCabelo WHERE id = ?";
        TiposDeCabelo cabelo = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cabelo = new TiposDeCabelo(
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDouble("comprimento"),
                        rs.getBoolean("isNatural")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cabelo;
    }

    public static List<TiposDeCabelo> listar() {
        String sql = "SELECT * FROM TiposDeCabelo";
        List<TiposDeCabelo> cabelos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TiposDeCabelo cabelo = new TiposDeCabelo(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDouble("comprimento"),
                        rs.getBoolean("isNatural")
                );
                cabelos.add(cabelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cabelos;
    }

    public static void atualizar(TiposDeCabelo cabelo) {
        String sql = "UPDATE TiposDeCabelo SET tipo = ?, cor = ?, comprimento = ?, isNatural = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cabelo.getTipo());
            stmt.setString(2, cabelo.getCor());
            stmt.setDouble(3, cabelo.getComprimento());
            stmt.setBoolean(4, cabelo.getIsNatural());
            stmt.setInt(5, cabelo.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM TiposDeCabelo WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
