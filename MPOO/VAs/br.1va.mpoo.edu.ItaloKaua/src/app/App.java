package app;

import base.BaseDados;
import entidade.*;

public class App {
    private static Supermercado supermercado;
    public static void main(String[] args) {
        supermercado = new Supermercado("MPOO SuperMarket");
        BaseDados.createBase();

        Gerente gerente = new Gerente("Maria Silva", "111.111.111-11");
        Vendedor vendedor1 = new Vendedor("João Santos", "222.222.222-22", "vend01");
        Vendedor vendedor2 = new Vendedor("Godofredo Sá", "333.333.333-33", "vend002");
        Caixa caixa = new Caixa("José Lima", "444.444.444-44");
        Supermercado.funcionarios.add(gerente);
        Supermercado.funcionarios.add(vendedor1);
        Supermercado.funcionarios.add(vendedor2);
        Supermercado.funcionarios.add(caixa);

        caixa.registrarVenda(null, BaseDados.buscarProduto("PROD001"), null);

        Compra compra1 = new Compra();
        for (int i=0; i<10; i++)
            compra1.adicionarProduto(BaseDados.buscarProduto("PROD001"));
        caixa.registrarVenda(compra1, null, null);

        caixa.registrarVenda(compra1, BaseDados.buscarProduto("PROD002"), "vend003");

        Compra compra2 = new Compra();
        for (int i=0; i<10; i++) {
            compra2.adicionarProduto(BaseDados.buscarProduto("PROD001"));
            compra2.adicionarProduto(BaseDados.buscarProduto("PROD002"));
        }
        caixa.registrarVenda(compra2, null, null);
        gerente.darDesconto(compra2, 10);

        gerente.darDesconto(BaseDados.buscarProduto("PROD004"), 50);
        Compra compra3 = new Compra();
        for (int i=0; i<10; i++)
            compra3.adicionarProduto(BaseDados.buscarProduto("PROD004"));
        caixa.registrarVenda(compra3, null, null);

    }
}
