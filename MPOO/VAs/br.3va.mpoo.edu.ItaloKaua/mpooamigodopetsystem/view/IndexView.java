package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IndexView extends JFrame{
	public JLabel logoLabel, textoLabel;
	public JButton participarButton;
	
	public IndexView() {
		setUndecorated(true);
		setSize(300, 205);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.dir"));
		
		logoLabel = new JLabel(new ImageIcon("mpooamigodopet.img\\logo.png"));
		textoLabel = new JLabel("Participe você também, seja um amigo pet!");
		participarButton = new JButton("Participar");
		
		add(logoLabel);
		add(textoLabel);
		add(participarButton);
		
		setVisible(true);
	}
}
