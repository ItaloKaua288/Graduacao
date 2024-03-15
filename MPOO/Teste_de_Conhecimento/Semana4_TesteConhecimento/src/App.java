public class App {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        Cliente cliente3 = new Cliente("3", "333.333.333-33", 25);

        Banco.depositar(BaseDados.getCliente1().getConta(), 100);
        Banco.depositar(BaseDados.getCliente2().getConta(), 100);
        System.out.println("Conta 1: " + BaseDados.getCliente1().getConta().getSaldo());
        System.out.println("Conta 2: " + BaseDados.getCliente2().getConta().getSaldo());

        Banco.sacar(BaseDados.getCliente1().getConta(), 10);
        System.out.println("Conta 1: " + BaseDados.getCliente1().getConta().getSaldo());
        System.out.println("Conta 2: " + BaseDados.getCliente2().getConta().getSaldo());

        Banco.transferir(BaseDados.getCliente2().getConta(), BaseDados.getCliente1().getConta(), 10);
        System.out.println("Conta 1: " + BaseDados.getCliente1().getConta().getSaldo());
        System.out.println("Conta 2: " + BaseDados.getCliente2().getConta().getSaldo());

    }
}
