package Concessionaria;

import java.util.List;

public interface Armazenamento {
    void adicionarVeiculo(Veiculo veiculo);
    List<Veiculo> obterVeiculos();
}
