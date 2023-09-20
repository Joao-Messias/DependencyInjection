package Concessionaria;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ArquivoArmazenamento implements Armazenamento {
    private List<Veiculo> veiculos = new ArrayList<>();
    private String nomeArquivo;

    public ArquivoArmazenamento(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        salvarNoArquivo();
    }

    @Override
    public List<Veiculo> obterVeiculos() {
        return veiculos;
    }

    private void salvarNoArquivo() {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Veiculo veiculo : veiculos) {
                String tipo = (veiculo instanceof Carro) ? "Carro" : "Motocicleta";
                bufferedWriter.write("Tipo: " + tipo + ", ");
                bufferedWriter.write("Marca: " + veiculo.getMarca() + ", ");
                bufferedWriter.write("Modelo: " + veiculo.getModelo() + ", ");
                bufferedWriter.write("Ano de Fabricação: " + veiculo.getAnoFabricacao() + ", ");
                bufferedWriter.write("Preço: " + veiculo.getPreco());
                if (veiculo instanceof Carro) {
                    bufferedWriter.write(", Número de Portas: " + ((Carro) veiculo).getNumeroPortas());
                } else if (veiculo instanceof Motocicleta) {
                    bufferedWriter.write(", Cilindradas: " + ((Motocicleta) veiculo).getCilindradas());
                }
                bufferedWriter.newLine();
            }

            veiculos.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
