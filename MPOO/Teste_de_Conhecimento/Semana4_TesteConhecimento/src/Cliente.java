public class Cliente {
    private String nome;
    public String cpf;
    private int idade;
    private Conta conta = new Conta();

    public Cliente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Conta getConta() {
        return conta;
    }
    
}
