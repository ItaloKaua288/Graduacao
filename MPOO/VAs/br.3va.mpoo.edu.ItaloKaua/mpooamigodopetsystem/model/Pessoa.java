package model;


public abstract class Pessoa {
	public String nome;
	private String cpf;
	protected String email;
	Telefone telefone;

	public Pessoa(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf.replace(".", "").replace("-", "");
		this.email = email;
		new Telefone(this);
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone= (" + telefone.getDdi() + ") "
				+ telefone.getDdd() + " " + telefone.getNumero() + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
