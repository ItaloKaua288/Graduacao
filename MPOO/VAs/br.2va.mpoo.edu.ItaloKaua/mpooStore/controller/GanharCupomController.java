package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.BaseDados;
import model.CPFException;
import model.Cliente;
import model.ClienteException;
import view.AberturaView;
import view.GanharCupomView;

public class GanharCupomController implements ActionListener{
    private AberturaView aberturaView;
    private GanharCupomView ganharCupomView;
    private WindowHandler windowHandler;

    public GanharCupomController(AberturaView aberturaView, GanharCupomView ganharCupomView) {
        this.aberturaView = aberturaView;
        this.ganharCupomView = ganharCupomView;
        this.windowHandler = new WindowHandler();
        controle();
    }

    public void controle() {
        ganharCupomView.addWindowListener(windowHandler);
        ganharCupomView.getConfirmarButton().addActionListener(this);
    }

    private class WindowHandler extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getSource()==aberturaView) {
            ganharCupomView.setVisible(false);
            aberturaView.setVisible(true);
        }
        super.windowClosing(e);
    }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ganharCupomView.getConfirmarButton()) {
            String nome = ganharCupomView.getNomeField().getText();
            String cpf = ganharCupomView.getCpfField().getText();
            String email = ganharCupomView.getEmailField().getText();

            if(nome.isBlank() || cpf.replace(".", "").replace("-", "").isBlank() || email.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "MPOOStore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Cliente cliente = new Cliente(nome, cpf, email);
                if(!BaseDados.isCliente(cliente))
                    return;
            } catch (CPFException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "CPF informado é inválido", "MPOOStore Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClienteException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cliente não está na base", "MPOOStore Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
