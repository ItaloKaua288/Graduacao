package model;

import java.util.ArrayList;

public abstract class Pessoa implements ValidadorCPF{
    protected String nome;
    private String cpf;
    private String sexo;
    private ArrayList<Telefone> telefones;

    public Pessoa() {}
    
    public Pessoa(String nome, String cpf, String sexo) throws CPFException{
        this.nome = nome;
        if(validarCPF(cpf))
            this.cpf = cpf;
        else
            throw new CPFException();
        this.sexo = sexo;
        this.telefones = new ArrayList<Telefone>();
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", telefones=" + telefones.toString() + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }
    
}
