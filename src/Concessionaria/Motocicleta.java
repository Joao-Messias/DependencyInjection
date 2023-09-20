package Concessionaria;

public class Motocicleta extends Veiculo {
    private int cilindradas;

    public Motocicleta(String marca, String modelo, int anoFabricacao, double preco, int cilindradas) {
        super(marca, modelo, anoFabricacao, preco);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }
}
