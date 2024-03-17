package sistemaBudega.model;

import sistemaBudega.view.MensagemView;

public class Robot extends Thread{
    public static boolean isProdutoAVencer;
    public static boolean isProdutoVencido;
    public static final long VERIFICACAO_DIAS = 86400000;
    public static final int PRAZO_DIAS = 2;

    public Robot() {}

    public static void executarVerificarAVencer() {
        if (BaseDados.buscarProdutoAVencer(PRAZO_DIAS).size() > 0)
            MensagemView.exibirMensagem("Existe(m) produto(s) a vencer em 2 dias");
    }

    public static void executarVencido() {
        if (BaseDados.buscarProdutosVencidos().size() > 0)
            MensagemView.exibirMensagem("Existe(m) produto(s) vencido(S)");
    }

    public void run() {
        while (true) {
            try {
                executarVerificarAVencer();
                executarVencido();
                sleep(VERIFICACAO_DIAS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
