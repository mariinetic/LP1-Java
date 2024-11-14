package fatec.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.classes.Salgadinhos;

public class SalgadinhosDAO {

    public void inserir(Salgadinhos salgadinho) {
        String sql = "INSERT INTO salgadinhos (sabor, peso, qtnde) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salgadinho.getSabor());
            stmt.setDouble(2, salgadinho.getPeso());
            stmt.setInt(3, salgadinho.getQtnde());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Salgadinhos buscarPorId(int id) {
        String sql = "SELECT * FROM salgadinhos WHERE id = ?";
        Salgadinhos salgadinho = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                salgadinho = new Salgadinhos(
                        rs.getString("sabor"),
                        rs.getDouble("peso"),
                        rs.getInt("qtnde")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salgadinho;
    }

    public List<Salgadinhos> listar() {
        String sql = "SELECT * FROM salgadinhos";
        List<Salgadinhos> salgadinhoList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Salgadinhos salgadinho = new Salgadinhos(
                        rs.getString("sabor"),
                        rs.getDouble("peso"),
                        rs.getInt("qtnde")
                );
                salgadinhoList.add(salgadinho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salgadinhoList;
    }

    public void atualizar(Salgadinhos salgadinho) {
        String sql = "UPDATE salgadinhos SET sabor = ?, peso = ?, qtnde = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, salgadinho.getSabor());
            stmt.setDouble(2, salgadinho.getPeso());
            stmt.setInt(3, salgadinho.getQtnde());
            stmt.setInt(4, salgadinho.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM salgadinhos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
