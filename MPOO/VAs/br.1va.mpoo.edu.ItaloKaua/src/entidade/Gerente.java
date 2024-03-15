package entidade;

import base.BaseDados;
import gui.Mensagem;

public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf) {
        super(nome, cpf);
        calcularSalario();
    }

    /* dar Desconto
        
        public void darDesconto(Produto produto, int desconto)
     
        Este metodo da o desconto em porcentagem a um produto.

        Parameters:
            desconto - Desconto em porcentagem. Ex: Se o preço do produto é de 
            R$ 10,00 e o desconto é de 10%, então o novo preço do produto é de R$ 9,00.
            produto - produto que receberá o desconto.
     */
    public void darDesconto(Produto produto, int desconto) {
        if (produto == null)
            return;

        Produto produtoBase = BaseDados.buscarProduto(produto.codBarras);
        produtoBase.preco -= (produtoBase.preco*(desconto/100));
    }

    /* dar Desconto
        
        public void darDesconto(Compra compra, int desconto)

        Parameters:
            desconto - Desconto em porcentagem. Máximo de 10% para 
            uma compra minima de R$ 100,00 Ex: Se o preço do produto é de R$ 100,00 e 
            o desconto é de 10%, então o novo preço do produto é de R$ 90,00.
            compra - compra que receberá o desconto.
     */
    public void darDesconto(Compra compra, int desconto) {
        if (compra == null)
            return;

        if (compra.getValorTotal() < 100.0)
            Mensagem.exibirMensagem(Mensagem.DESCONTO_VALOR_MINIMO);

        if (compra.getValorTotal()>=100.0 || desconto >= 0)
            compra.setValorTotal(compra.getValorTotal() - (compra.getValorTotal()*desconto));
    }

    @Override
    public void calcularSalario() {
        setSalario(SALARIO_MINIMO*5);
    }
    
}
