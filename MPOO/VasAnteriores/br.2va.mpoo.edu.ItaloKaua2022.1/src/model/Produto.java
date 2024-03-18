package model;

import java.util.Date;

public class Produto {
    private String nome;
    private String codBarras;
    private Date validade;
    private Fornecedor fornecedor;
    private int quantidade;

    public Produto(String nome, String codBarras, Date validade, int quantidade) {
        this.nome = nome;
        this.codBarras = codBarras;
        this.validade = validade;
        this.quantidade = quantidade;
        new Fornecedor(this);
    }

    public Produto(String nome, String codBarras, Date validade) {
        this.nome = nome;
        this.codBarras = codBarras;
        this.validade = validade;
        new Fornecedor(this);
    }

    public String getCodBarras() {
        return codBarras;
    }

    public Date getValidade() {
        return validade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String toString() {
        return "Produto [codBarras=" + codBarras + ", validade=" + validade.getDate() + "/" + 
        validade.getMonth() + "/" + validade.getYear() + ", fornecedor=" + fornecedor.getCnpj() + "]\n";
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

}
