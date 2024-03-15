package model;

import java.util.ArrayList;

import view.MensagemView;

public class BaseDados {
    private static ArrayList<Pessoa> pessoas;

    public static void createBase() {
        pessoas = new ArrayList<Pessoa>();
        inicializarBase();
    }

    public static void inicializarBase() {
    }

    public static boolean isPessoa(Pessoa pessoa) {
        if (pessoa == null)
            return false;
        
        for (Pessoa currentPessoa : pessoas) {
            if (currentPessoa.getCpf().equals(pessoa.getCpf()))
                return true;
        }
        return false;
    }

    public static boolean isUsuario(String login, String senha) {
        if (login.isBlank() || senha.isBlank())
            return false;
        
        for (Pessoa currentPessoa : pessoas) {
            if (currentPessoa instanceof Usuario)
                if(((Usuario) currentPessoa).login.equals(login) && ((Usuario) currentPessoa).getSenha().equals(senha))
                    return true;
        }
        return false;
    }

    public static boolean adicionarPessoa(Pessoa pessoa) {
        if (isPessoa(pessoa) || pessoa == null) {
            MensagemView.exibirMensagemErro(Mensagem.USUARIO_ERROR);
            return false;
        }
        
        MensagemView.exibirMensagem(Mensagem.USUARIO_SUCESS);
        return pessoas.add(pessoa);
    }

    public static ArrayList<String> listPessoas() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Pessoa currentPessoa : pessoas)
            lista.add(currentPessoa.getNome());
        
        return lista;
    }

    public static ArrayList<String> listUsuarios() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Pessoa currentPessoa : pessoas)
            if (currentPessoa instanceof Usuario)
                lista.add(((Usuario) currentPessoa).login);
        return lista;
    }
}
