import Concessionaria.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Volkswagen", "Jetta", 2022, 120000.0, 4);
        Veiculo moto = new Motocicleta("Kawazaki", "Ninja", 2021, 75000.0, 1000);

        Armazenamento arquivoArmazenamento = new ArquivoArmazenamento("veiculos.txt");
        Armazenamento bancoDeDadosArmazenamento = new BancoDeDadosArmazenamento();
        Concessionaria concessionariaArquivo = new Concessionaria(arquivoArmazenamento);
        Concessionaria concessionariaBanco = new Concessionaria(bancoDeDadosArmazenamento);


        concessionariaArquivo.adicionarVeiculo(carro);
        concessionariaArquivo.adicionarVeiculo(moto);

        concessionariaBanco.adicionarVeiculo(carro);
        concessionariaBanco.adicionarVeiculo(moto);

        List<Veiculo> veiculosArquivo = concessionariaArquivo.obterVeiculos();
        List<Veiculo> veiculosBanco = concessionariaBanco.obterVeiculos();
    }
}
