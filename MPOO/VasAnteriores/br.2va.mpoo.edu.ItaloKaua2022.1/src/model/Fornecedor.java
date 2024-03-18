package model;

public class Fornecedor {
    private String cnpj;

    public Fornecedor(String cnpj, Produto produto) {
        this.cnpj = cnpj;
        produto.setFornecedor(this);
    }

    public Fornecedor(Produto produto) {
        produto.setFornecedor(this);
    }

    public String getCnpj() {
        return cnpj;
    }
    
}
