package sistemaBudega.model;

import java.util.ArrayList;

public class Fornecedor extends Pessoa{
    private String cpnj;
    private String nomeFantasia;

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Fornecedor(String nome, String cpf, String cpnj, String nomeFantasia) {
        super(nome, cpf);
        this.cpnj = cpnj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCpnj() {
        return cpnj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public boolean validarCPF(String cpf) {
        return true;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
}
