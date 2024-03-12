package model;

public class Cliente extends Pessoa{
	private String email;
	private CupomDesconto cupomDesconto;
	
	public Cliente(String nome, String cpf, String email) throws CPFException {
		super(nome, cpf);
		this.email = email;
		new CupomDesconto(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}
}