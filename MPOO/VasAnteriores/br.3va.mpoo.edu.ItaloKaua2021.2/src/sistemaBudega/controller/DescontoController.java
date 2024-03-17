package sistemaBudega.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import sistemaBudega.model.BaseDados;
import sistemaBudega.model.Produto;
import sistemaBudega.model.ProdutoNaoExisteException;
import sistemaBudega.view.DescontoView;
import sistemaBudega.view.MensagemErroView;
import sistemaBudega.view.MensagemView;

public class DescontoController implements ActionListener {
    private DescontoView descontoView;
    private FieldHandler fieldHandler;

    public DescontoController(DescontoView descontoView) {
        this.descontoView = descontoView;
        this.fieldHandler = new FieldHandler();
        controle();
    }

    private void controle() {
        descontoView.getAplicarButton().addActionListener(this);
        descontoView.getCodBarrasRadioButton().addActionListener(this);
        descontoView.getValidadeRadioButton().addActionListener(this);
        descontoView.getDescontoField().addCaretListener(fieldHandler);
        descontoView.getCodBarrasField().addCaretListener(fieldHandler);
    }

    private class FieldHandler implements CaretListener {
        private void verificarPreenchimentoValidade() {
            boolean codBarras = descontoView.getCodBarrasField().getText().isBlank();
            boolean desconto = descontoView.getDescontoField().getText().isBlank();
            boolean codBarrasOption = descontoView.getCodBarrasRadioButton().isSelected();
            
            if ((codBarrasOption && codBarras) || desconto) {
                descontoView.getAplicarButton().setEnabled(false);
                return;
            }
            descontoView.getAplicarButton().setEnabled(true);
        }

        @Override
        public void caretUpdate(CaretEvent e) {
            if (e.getSource() == descontoView.getDescontoField()) {
                if (!descontoView.getDescontoField().getText().isBlank()) {
                    try {
                        Integer.parseInt(descontoView.getDescontoField().getText());
                    } catch (NumberFormatException e1) {
                        e1.printStackTrace();
                        MensagemErroView.exibirMensagemErro("Preencha o campo desconto com valor válido!");
                    }
                }
            }
            verificarPreenchimentoValidade();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == descontoView.getCodBarrasRadioButton() || e.getSource() == descontoView.getValidadeRadioButton()) {
            if (descontoView.getCodBarrasRadioButton().isSelected()) {
                descontoView.getPrazoLabel().setVisible(false);
                descontoView.getPrazComboBox().setVisible(false);
                descontoView.getCodBarrasField().setVisible(true);
                descontoView.getCodBarrasLabel().setVisible(true);
            } else {
                descontoView.getCodBarrasField().setVisible(false);
                descontoView.getCodBarrasLabel().setVisible(false);
                descontoView.getPrazoLabel().setVisible(true);
                descontoView.getPrazComboBox().setVisible(true);
            }

            descontoView.getDescontoField().setText("");
            descontoView.getCodBarrasField().setText("");
            descontoView.getAplicarButton().setEnabled(false);
        }

        if (e.getSource() == descontoView.getAplicarButton()) {
            String codBarras = descontoView.getCodBarrasField().getText();
            Integer desconto = Integer.parseInt(descontoView.getDescontoField().getText());
            Integer dias = Integer.parseInt(descontoView.getPrazComboBox().getSelectedItem().toString());

            if (desconto < 0) {
                MensagemErroView.exibirMensagemErro("Preencha valor maior que 0");
            }

            if (descontoView.getValidadeRadioButton().isSelected()) {
                ArrayList<Produto> produtosAVencer = BaseDados.buscarProdutoAVencer(dias);

                if (produtosAVencer.size() == 0) {
                    MensagemView.exibirMensagem("Não exite(m) produto(s) a a vencer nesse prazo!");
                    return;
                }

                for (Produto currentProduto : produtosAVencer)
                    currentProduto.aplicarDesconto(desconto);
            } else {
                if (codBarras.isBlank()) {
                    MensagemErroView.exibirMensagemErro("Preencha o código de barras!");
                    return;
                }
                try {
                    BaseDados.buscarProduto(codBarras).aplicarDesconto(desconto);
                } catch (ProdutoNaoExisteException e1) {
                    e1.printStackTrace();
                }
            }
            MensagemView.exibirMensagem("Desconto aplicado com sucesso!");
        }
    }
}
