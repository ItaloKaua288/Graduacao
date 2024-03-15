public class BaseDados {
    private static Cliente cliente1 = new Cliente("1", "111.111.111-11",18);
    private static Cliente cliente2 = new Cliente("2", "222.222.222-22", 19);
    
    public static Cliente getCliente1() {
        return cliente1;
    }
    public static Cliente getCliente2() {
        return cliente2;
    }
    
}
