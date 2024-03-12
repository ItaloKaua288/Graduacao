package model;

public class Proprietario extends Pessoa{
	public String tipoAnimalPreferido;
	public int id;
	public boolean isVoluntario;
	public String disponibilida;
	public boolean whatsapp;
	public boolean contato;
	private int cont;
	
	public Proprietario(String nome, String cpf, String email, String animalPreferido, boolean voluntario) {
		super(nome, cpf, email);
		this.tipoAnimalPreferido = animalPreferido;
		this.isVoluntario = voluntario;
		this.id = cont++;
	}
	
	public Proprietario(String nome, String cpf, String email, String tipoAnimalPreferido) {
		super(nome, cpf, email);
		this.tipoAnimalPreferido = tipoAnimalPreferido;
	}

	public void setDisponibilida(String disponibilida) {
		this.disponibilida = disponibilida;
	}

	@Override
	public String toString() {
		return super.toString() + ", Animal Preferido= " + tipoAnimalPreferido + ", voluntario= " + isVoluntario 
		+ ", disponibilidade= " + disponibilida;
	}
}
