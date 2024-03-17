package sistemaBudega.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface AVencerInterface {
    public static long diasAVencer(Produto produto) {
        LocalDateTime atual = LocalDateTime.now();
        @SuppressWarnings("deprecation")
        LocalDateTime produtoDate = LocalDateTime.of(produto.getValidade().getYear(), produto.getValidade().getMonth(), produto.getValidade().getDate(), 0, 0);
        long diasAVencer = ChronoUnit.DAYS.between(atual.toLocalDate(), produtoDate.toLocalDate());
        return diasAVencer;
    }
}
