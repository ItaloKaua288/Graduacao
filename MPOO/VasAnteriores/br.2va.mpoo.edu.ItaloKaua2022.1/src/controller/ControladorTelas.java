package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import model.BaseDados;
import model.Fornecedor;
import model.Produto;
import model.ProdutoException;
import view.TelaCadastro;
import view.TelaMensagem;
import view.TelaMenu;

public class ControladorTelas implements ActionListener{
    private TelaCadastro telaCadastro;
    private TelaMenu telaMenu;

    public ControladorTelas(TelaCadastro telaCadastro, TelaMenu telaMenu) {
        this.telaCadastro = telaCadastro;
        this.telaMenu = telaMenu;

        controle();
    }

    private void controle() {
        telaMenu.getAddButton().addActionListener(this);
        telaMenu.getSairButton().addActionListener(this);
        telaCadastro.getAddButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaMenu.getSairButton())
            System.exit(0);

        if (e.getSource() == telaMenu.getAddButton())
            telaCadastro.setVisible(true);

        if(e.getSource() == telaCadastro.getAddButton()) {
            String codBarras = telaCadastro.getCodBarrasField().getText();
            String[] validade = telaCadastro.getValidadeField().getText().replace(".", "-").split("-");
            String fornecedor = telaCadastro.getFornecedorField().getText();
            
            if (codBarras.isBlank() || fornecedor.isBlank()) {
                TelaMensagem.exibirMensagem("O preenchimento de todos os campos é obrigatório!");
                return;
            }
            Date validadeTemp = new Date(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]), Integer.parseInt(validade[2]));

            Produto produtoTemp = new Produto("" , codBarras, validadeTemp);
            new Fornecedor(fornecedor, produtoTemp);

            try {
                BaseDados.addProduto(produtoTemp);
                TelaMensagem.exibirMensagem("Produto cadastrado com sucesso!");
            } catch (ProdutoException e1) {
                e1.printStackTrace();
            }
        }
    }
    
}
