package Concessionaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosArmazenamento implements Armazenamento {
    private List<Veiculo> veiculos = new ArrayList<>();
    private Connection connection;
    public BancoDeDadosArmazenamento() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:veiculos.db");
            String sql = "CREATE TABLE IF NOT EXISTS veiculos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "tipo TEXT," +
                    "marca TEXT," +
                    "modelo TEXT," +
                    "anoFabricacao INTEGER," +
                    "preco REAL," +
                    "numeroPortas INTEGER," +
                    "cilindradas INTEGER" +
                    ")";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        String tipo = (veiculo instanceof Carro) ? "Carro" : "Motocicleta";
        String sql = "INSERT INTO veiculos (tipo, marca, modelo, anoFabricacao, preco, numeroPortas, cilindradas) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tipo);
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getModelo());
            statement.setInt(4, veiculo.getAnoFabricacao());
            statement.setDouble(5, veiculo.getPreco());
            if (veiculo instanceof Carro) {
                statement.setInt(6, ((Carro) veiculo).getNumeroPortas());
                statement.setNull(7, java.sql.Types.INTEGER);
            } else if (veiculo instanceof Motocicleta) {
                statement.setNull(6, java.sql.Types.INTEGER);
                statement.setInt(7, ((Motocicleta) veiculo).getCilindradas());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Veiculo> obterVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int anoFabricacao = resultSet.getInt("anoFabricacao");
                double preco = resultSet.getDouble("preco");
                int numeroPortas = resultSet.getInt("numeroPortas");
                int cilindradas = resultSet.getInt("cilindradas");

                if (tipo.equals("Carro")) {
                    veiculos.add(new Carro(marca, modelo, anoFabricacao, preco, numeroPortas));
                } else if (tipo.equals("Motocicleta")) {
                    veiculos.add(new Motocicleta(marca, modelo, anoFabricacao, preco, cilindradas));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }
}