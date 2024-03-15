package entidade;

import java.util.ArrayList;

public class Supermercado {
    public String nome;
    public static ArrayList<Funcionario> funcionarios;
    public static ArrayList<Compra> compras;

    public static Funcionario buscarFuncionario(String cpf) {
        if (cpf==null || cpf.isBlank())
            return null;
        
        for (Funcionario currentFuncionario : funcionarios) {
            if (currentFuncionario.getCpf().equals(cpf))
                return currentFuncionario;
        }
        return null;
    }

    public static Vendedor buscarVendedor(String codVendedor) {
        if (codVendedor == null || codVendedor.isBlank())
            return null;

        for (Funcionario currentFuncionario : funcionarios) {
            if(currentFuncionario instanceof Vendedor)
                if (((Vendedor) currentFuncionario).getCodVendedor().equals(codVendedor))
                    return (Vendedor) currentFuncionario;
        }
        return null;
    }

    public static Compra buscarCompra(int id) {
        if (id < 0)
            return null;
        
        for (Compra currentCompra : compras) {
            if (currentCompra.id == id)
                return (Compra) currentCompra;
        }
        return null;
    }
}
