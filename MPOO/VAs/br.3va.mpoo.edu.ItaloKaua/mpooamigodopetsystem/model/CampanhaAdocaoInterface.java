package model;

public interface CampanhaAdocaoInterface {
	public static final int META_PROPRIETARIOS = 5;
	
	public abstract boolean verificarMeta();
	
	public abstract void atualizarMeta();
	
	public abstract boolean cadastrarProprietario(Proprietario proprietario) throws CadastroException;
}
