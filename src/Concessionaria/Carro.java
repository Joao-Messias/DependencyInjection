package Concessionaria;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int anoFabricacao, double preco, int numeroPortas) {
        super(marca, modelo, anoFabricacao, preco);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }
}