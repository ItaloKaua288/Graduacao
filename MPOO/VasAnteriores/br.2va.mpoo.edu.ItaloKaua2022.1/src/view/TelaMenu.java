package view;

import javax.swing.JButton;

public class TelaMenu extends Tela{
    private JButton addButton, sairButton;

    public TelaMenu() {
        super("Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 75);

        addButton = new JButton("Add");
        sairButton = new JButton("sair");

        add(addButton);
        add(sairButton);

        setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }
}
