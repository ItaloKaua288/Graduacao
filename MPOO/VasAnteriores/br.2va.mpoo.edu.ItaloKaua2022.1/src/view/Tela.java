package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.FlowLayout;

public abstract class Tela extends JFrame{
    
    public Tela(String titulo) {
        super(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());

        try {
            LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (LookAndFeelInfo lookAndFeelInfo : looks)
                if (lookAndFeelInfo.getName().contains("Nimbus"))
                    UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
        } catch (Exception e) {
            e.printStackTrace();
            TelaMensagem.exibirErroNimbus();
        }
    }
}
