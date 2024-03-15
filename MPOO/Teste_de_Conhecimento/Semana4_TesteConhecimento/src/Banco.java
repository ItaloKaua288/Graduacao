public class Banco {
    public static void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public static boolean sacar(Conta conta, double valor) {
        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            return true;
        }
        return false;
    }

    public static boolean transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        if (contaOrigem.getSaldo() < valor || contaOrigem == null || contaDestino == null)
            return false;
        
        sacar(contaOrigem, valor);
        depositar(contaDestino, valor);
        return true;
    }
}
