package model;

import java.util.Calendar;
import java.util.Date;

public interface Verificador {
    public static boolean verificarValidade(Produto produto) {
        Date dataAtual = new Date(System.currentTimeMillis());
        Calendar calB = Calendar.getInstance();
        dataAtual = calB.getTime();
        if (produto.getValidade().before(dataAtual))
            return true;
        return false;
    }
}
