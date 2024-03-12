package model;

import java.util.ArrayList;

public class BaseDados implements CampanhaAdocaoInterface {
	private static ArrayList<Pessoa> pessoas;
	public static boolean metaAdocao;

	public static void createBase() throws CadastroException {
		pessoas = new ArrayList<Pessoa>();
		inicializarBase();
	}

	public static void inicializarBase() throws CadastroException {
		addPessoa(new Proprietario("Godofredo Alves", "111.111.111-11", "godofredo@gmail.com", "gato", true));
		new Telefone(BaseDados.buscarPessoa("111.111.111-11"), 55, 81, "99999-0000");

		addPessoa(new Proprietario("Joao Santos", "222.222.222-22", "joaosantos@gmail.com", "Cachorro", false));
		new Telefone(BaseDados.buscarPessoa("222.222.222-22"), 55, 85, "99999-1111");
		
		addPessoa(new Proprietario("Maria Santa", "333.333.333-33", "mariasantinha@gmail.com", "Coelho", true));
		new Telefone(BaseDados.buscarPessoa("333.333.333-33"), 55, 85, "99999-2222");
		
	}

	public static Pessoa buscarPessoa(String cpf) {
		if (cpf.isEmpty())
			return null;
		cpf = cpf.replace(".", "").replace("-", "");
		for (Pessoa currentPessoa : pessoas)
			if (currentPessoa.getCpf().equals(cpf))
				return currentPessoa;
		return null;
	}

	public static Pessoa buscarPessoa(Pessoa pessoa) {
		if (pessoa == null)
			return null;

		for (Pessoa currentPessoa : pessoas)
			if (currentPessoa.getCpf().equals(pessoa.getCpf()))
				return currentPessoa;
		return null;
	}

	public static boolean isPessoa(Pessoa pessoa) {
		boolean contains = false;
		if (BaseDados.buscarPessoa(pessoa) != null)
			contains = true;
		return contains;
	}

	public static boolean addPessoa(Pessoa pessoa) throws CadastroException {
		if(pessoa == null || isPessoa(pessoa))
			throw new CadastroException();

		if(pessoas.add(pessoa))
			return true;
		else
			throw new CadastroException();
	}

	public static boolean removerPessoa(Pessoa pessoa) {
		if (!isPessoa(pessoa))
			return false;

		return pessoas.remove(buscarPessoa(pessoa));
	}

	public static ArrayList<String> listEmailProprietarios() {
		ArrayList<String> listaEmails = new ArrayList<String>();
		
		for (Pessoa currentPessoa : pessoas)
			if (currentPessoa instanceof Proprietario)
				listaEmails.add(currentPessoa.getEmail());
		return listaEmails;
	}

	public static ArrayList<String> listEmailVoluntarios() {
		ArrayList<String> voluntarios = new ArrayList<String>();

		for (Pessoa currentPessoa : pessoas)
			if (currentPessoa instanceof Proprietario)
				if (((Proprietario) currentPessoa).isVoluntario)
					voluntarios.add(currentPessoa.getEmail());
		return voluntarios;
	}

	public static ArrayList<String> listAnimaisPreferidos() {
		ArrayList<String> preferidos = new ArrayList<String>();

		for (Pessoa currentPessoa : pessoas)
			if (currentPessoa instanceof Proprietario)
				preferidos.add(((Proprietario) currentPessoa).tipoAnimalPreferido);
		return preferidos;
	}

	@Override
	public boolean verificarMeta() {
		if (pessoas.size() >= META_PROPRIETARIOS)
			return true;
		return false;
	}

	@Override
	public void atualizarMeta() {
		metaAdocao = verificarMeta();
	}

	@Override
	public boolean cadastrarProprietario(Proprietario proprietario) throws CadastroException {
		if (proprietario == null || isPessoa(proprietario))
			throw new CadastroException();
		return addPessoa(proprietario);
	}
}
