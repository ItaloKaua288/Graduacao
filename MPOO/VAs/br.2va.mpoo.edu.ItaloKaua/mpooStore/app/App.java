package app;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.AberturaController;
import controller.GanharCupomController;
import model.BaseDados;
import model.GeradorCupom;
import model.TempoOferta;
import view.AberturaView;
import view.GanharCupomView;

public class App {
    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (LookAndFeelInfo currentLook : looks) {
                if (currentLook.getName().contains("Nimbus"))
                    UIManager.setLookAndFeel(currentLook.getClassName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BaseDados.createBase();

        //new TempoOferta();
        //new GeradorCupom()

        AberturaView aberturaView = new AberturaView();
        GanharCupomView ganharCupomView = new GanharCupomView();
        
        new AberturaController(aberturaView, ganharCupomView);
        new GanharCupomController(aberturaView, ganharCupomView);
    }
}
