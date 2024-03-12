package model;

public class CupomDesconto {
    private double valor;
    private String codigo;

    public CupomDesconto(Cliente cliente) {
        cliente.setCupomDesconto(this);
    }

    public CupomDesconto(String codigo, Cliente cliente) throws ClienteException, CupomException{
        if (!codigo.equals(GerenciadorCupom.CODIGO_CUPOM))
            throw new CupomException();
        if(!BaseDados.isCliente(cliente))
            throw new ClienteException();
        this.codigo = codigo;
        cliente.setCupomDesconto(this);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
