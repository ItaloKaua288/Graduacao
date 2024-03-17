package sistemaBudega.model;

public abstract class Pessoa implements CPFValidadorInterface{
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        if (validarCPF(cpf))
            this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    
}
