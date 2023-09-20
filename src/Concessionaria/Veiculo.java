package Concessionaria;

public class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double preco;

    public Veiculo(String marca, String modelo, int anoFabricacao, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getPreco() {
        return preco;
    }
}
