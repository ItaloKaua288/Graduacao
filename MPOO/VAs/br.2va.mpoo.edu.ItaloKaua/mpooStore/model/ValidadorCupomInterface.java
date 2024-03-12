package model;

public interface ValidadorCupomInterface {
    public static boolean validarCupom(String codigoCupom) {
        if(codigoCupom.equals(GerenciadorCupom.CODIGO_CUPOM))
            return true;
        return false;
    }
}
