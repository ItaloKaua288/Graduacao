package sistemaBudega.app;

import sistemaBudega.controller.AVencerController;
import sistemaBudega.controller.DescontoController;
import sistemaBudega.controller.EstoqueController;
import sistemaBudega.model.BaseDados;
import sistemaBudega.model.Robot;
import sistemaBudega.view.AVencer;
import sistemaBudega.view.DescontoView;
import sistemaBudega.view.EstoqueView;

public class App {
    public static void main(String[] args) {
        BaseDados.createBase();

        EstoqueView estoqueView = new EstoqueView();
        AVencer aVencer = new AVencer();
        DescontoView descontoView = new DescontoView();

        new EstoqueController(estoqueView, descontoView, aVencer);
        new AVencerController(aVencer);
        new DescontoController(descontoView);

        new Robot();
    }
}
