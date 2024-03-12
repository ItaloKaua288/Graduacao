package model;

public class Pessoa implements ValidadorCPFInterface{
	private String nome;
	private String cpf;
	
	public Pessoa(String nome, String cpf) throws CPFException{
		this.nome = nome;
		if (validarCPF(cpf))
			this.cpf = cpf;
		else
			throw new CPFException();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}