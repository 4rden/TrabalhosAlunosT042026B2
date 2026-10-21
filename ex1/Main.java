class Pessoa {
    String nome;
    int idade;

    void apresentar() {
        System.out.println("Olá, meu nome é " + nome +
                           " e tenho " + idade + " anos.");
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        pessoa.nome = "Arthur";
        pessoa.idade = 18;

        pessoa.apresentar();
    }
}
