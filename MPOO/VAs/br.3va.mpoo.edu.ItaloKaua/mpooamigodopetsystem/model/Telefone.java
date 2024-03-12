package model;

public class Telefone {
	private int ddi;
	private int ddd;
	private String numero;

	public Telefone(Pessoa pessoa) {
		pessoa.setTelefone(this);
	}

	public Telefone(Pessoa pessoa, int ddi, int ddd, String numero) {
		this.ddi = ddi;
		this.ddd = ddd;
		this.numero = numero;
		new Telefone(pessoa);
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
