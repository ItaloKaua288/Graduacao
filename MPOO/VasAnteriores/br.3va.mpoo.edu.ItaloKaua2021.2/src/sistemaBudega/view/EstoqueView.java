package sistemaBudega.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EstoqueView extends JFrame{
    private JLabel logoLabel;
    private JButton verProdutosButton, promocaButton, sairButton;

    public EstoqueView() {
        setUndecorated(true);
        setSize(450, 110);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logoLabel = new JLabel(new ImageIcon("img//logoBudega.png"));
        verProdutosButton = new JButton("Ver Produtos");
        promocaButton = new JButton("Definir Promoção");
        sairButton = new JButton("Sair");

        add(logoLabel);
        add(verProdutosButton);
        add(promocaButton);
        add(sairButton);

        setVisible(true);
    }

    public JButton getVerProdutosButton() {
        return verProdutosButton;
    }

    public JButton getPromocaButton() {
        return promocaButton;
    }

    public JButton getSairButton() {
        return sairButton;
    }
    
}
