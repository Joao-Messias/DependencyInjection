package Concessionaria;

import java.util.List;

public class Concessionaria {
    private Armazenamento armazenamento;

    public Concessionaria(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        armazenamento.adicionarVeiculo(veiculo);
    }

    public List<Veiculo> obterVeiculos() {
        return armazenamento.obterVeiculos();
    }
}

