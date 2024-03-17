package sistemaBudega.model;

public class Estoque {
    private int quantidade;

    public Estoque(Produto produto) {
        this.quantidade = 1;
        produto.setEstoque(this);
    }

    public Estoque(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        produto.setEstoque(this);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
