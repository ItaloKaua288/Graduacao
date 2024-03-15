package util;

import java.util.Calendar;

import entidade.Produto;

public class Verificador {
    public static boolean isVencido(Produto produto) {
        Calendar dataAtual = Calendar.getInstance();
        if (produto.getValidade().before(dataAtual))
            return true;
        return false;
    }
}
