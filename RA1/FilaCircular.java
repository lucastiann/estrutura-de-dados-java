public class FilaCircular {
    private int[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;

    public FilaCircular(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        elementos = new int[capacidade];
        inicio = 0;
        fim = -1;
        quantidade = 0;
    }

    // Verifica se todos os espacos estao ocupados.
    public boolean cheia() {
        return quantidade == elementos.length;
    }

    // Verifica se nao existe nenhum elemento na fila.
    public boolean vazia() {
        return quantidade == 0;
    }

    // Coloca um elemento no fim da fila.
    public void insere(int valor) {
        if (cheia()) {
            throw new IllegalStateException("A fila esta cheia.");
        }

        fim = (fim + 1) % elementos.length;
        elementos[fim] = valor;
        quantidade++;
    }

    // Retira e retorna o elemento que esta no inicio.
    public int remove() {
        if (vazia()) {
            throw new IllegalStateException("A fila esta vazia.");
        }

        int valor = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        quantidade--;
        return valor;
    }

    // Consulta o primeiro elemento sem retira-lo.
    public int primeiro() {
        if (vazia()) {
            throw new IllegalStateException("A fila esta vazia.");
        }

        return elementos[inicio];
    }

    // Consulta o ultimo elemento sem retira-lo.
    public int ultimo() {
        if (vazia()) {
            throw new IllegalStateException("A fila esta vazia.");
        }

        return elementos[fim];
    }
}
