package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.AberturaView;
import view.GanharCupomView;

public class AberturaController {
    private AberturaView aberturaView;
    private GanharCupomView ganharCupomView;
    private RadioHandler radioHandler;
    private ButtonHandler buttonHandler;
    private KeyHandler keyHandler;

    public AberturaController(view.AberturaView aberturaView, GanharCupomView ganharCupomView) {
        this.aberturaView = aberturaView;
        this.ganharCupomView = ganharCupomView;
        this.radioHandler = new RadioHandler();
        this.buttonHandler = new ButtonHandler();
        this.keyHandler = new KeyHandler();

        controle();
    }

    public void controle() {
        aberturaView.getPegarButton().addActionListener(buttonHandler);
        aberturaView.getSimRadioButton().addItemListener(radioHandler);
        aberturaView.getNaoRadioButton().addItemListener(radioHandler);

        aberturaView.getPegarButton().addKeyListener(keyHandler);
        aberturaView.getSimRadioButton().addKeyListener(keyHandler);
        aberturaView.getNaoRadioButton().addKeyListener(keyHandler);
    }

    private class RadioHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource()==aberturaView.getNaoRadioButton() && aberturaView.getNaoRadioButton().isSelected()) {
                JOptionPane.showMessageDialog(null, "Cupom Desconto válido apenas para clientes de MPOOStore!",
                            "MPOO Store", JOptionPane.CLOSED_OPTION, new ImageIcon("mpooStore.img/icone.png"));
            }
        }

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == aberturaView.getPegarButton()) {
                if (aberturaView.getSimRadioButton().isSelected()) {
                    aberturaView.setVisible(false);
                    ganharCupomView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Cupom Desconto válido apenas para clientes de MPOOStore!",
                            "MPOO Store", JOptionPane.CLOSED_OPTION, new ImageIcon("mpooStore.img/icone.png"));
                }
            }
        }

    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                if (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "MPOOStore", 0, 1) == 0);
                    System.exit(0);
            super.keyPressed(e);
        }
    }
}
