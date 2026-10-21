class Carro {
    String marca;
    String modelo;
    int ano;

    void exibirDados() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }
}

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.marca = "Ford";
        carro.modelo = "Focus";
        carro.ano = 2013;

        carro.exibirDados();
    }
}
