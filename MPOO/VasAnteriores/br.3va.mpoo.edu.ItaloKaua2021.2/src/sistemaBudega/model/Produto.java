package sistemaBudega.model;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class Produto implements VencidoInterface{
    public int id;
    private static int ultimo;
    private String nome;
    private String codBarras;
    private double preco;
    private int quantidade;
    private Date validade;

    private Estoque estoque;
    private Fornecedor fornecedor;

    public Produto(String nome, String codBarras, double preco, int quantidade, Date validade) {
        this.id = ultimo++;
        this.nome = nome;
        this.codBarras = codBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.validade = validade;
        new Estoque(this);
    }

    public Produto(String nome, String codBarras, double preco, int quantidade, Date validade, Fornecedor fornecedor) {
        this.id = ultimo++;
        this.nome = nome;
        this.codBarras = codBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.validade = validade;
        this.fornecedor = fornecedor;
        new Estoque(this);
    }

    public boolean aplicarDesconto(double desconto) {
        DecimalFormat df = new DecimalFormat("#.00");
        double valor = preco - preco*(desconto/100);
        if (desconto > 0) {
            this.preco = Double.parseDouble(df.format(valor).replace(",", "."));
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getValidade() {
        return validade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isVencido() {
        Calendar c = Calendar.getInstance();
        c.set(this.validade.getYear(), this.validade.getMonth(), this.validade.getDate());
        Date validadeProduto = c.getTime();
        if (validadeProduto.before(new Date()))
            return true;
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", codBarras=" + codBarras + ", preco=" + preco + ", quantidade=" + quantidade
                + ", validade=" + validade.getDate() + "/" + validade.getMonth() + "/" + validade.getYear() + ", estoque=" 
                + estoque + ", fornecedor=" + fornecedor + "]\n";
    }
    
}
