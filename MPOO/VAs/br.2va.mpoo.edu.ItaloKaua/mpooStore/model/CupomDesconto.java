package model;

public class CupomDesconto implements ValidadorCupomInterface{
    private int valor;
    private String codigo;
    private GerenciadorCupom gerenciadorCupom;

    public CupomDesconto(Cliente cliente){
        cliente.setCupomDesconto(this);
    }

    public CupomDesconto(String codigo, Cliente cliente) throws ClienteException, CupomException{
        if (!ValidadorCupomInterface.validarCupom(codigo))
            throw new CupomException();
        if(!BaseDados.isCliente(cliente))
            throw new ClienteException();
            
        this.codigo = codigo;
        this.gerenciadorCupom = new GerenciadorCupom();
        this.valor = gerenciadorCupom.getValorCupomAtual();
        cliente.setCupomDesconto(this);
        //new TempoOferta(this).start();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public GerenciadorCupom getGerenciadorCupom() {
        return gerenciadorCupom;
    }
    
}
