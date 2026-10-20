public class OperacoesFila {

    // Junta duas filas ordenadas em uma terceira fila tambem ordenada.
    // As filas A e B sao consumidas durante a operacao.
    // A fila R deve estar vazia e ter espaco para todos os elementos.
    public static void merge(FilaCircular a, FilaCircular b, FilaCircular r) {
        while (!a.vazia() && !b.vazia()) {
            if (a.primeiro() <= b.primeiro()) {
                r.insere(a.remove());
            } else {
                r.insere(b.remove());
            }
        }

        // Se sobraram elementos em A, passa todos para R.
        while (!a.vazia()) {
            r.insere(a.remove());
        }

        // Se sobraram elementos em B, passa todos para R.
        while (!b.vazia()) {
            r.insere(b.remove());
        }
    }
}
