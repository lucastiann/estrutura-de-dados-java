import java.util.Random;

public class Main {

    // Calcula a posicao inicial na tabela (0 ate 99).
    public static int funcaoHash(int valor) {
        return valor % 100;
    }

    // Rehashing linear: tenta a proxima posicao e volta ao inicio apos a 99.
    public static int rehash(int posicao) {
        return (posicao + 1) % 100;
    }

    // Procura um valor usando o mesmo caminho percorrido na insercao.
    public static void testarBusca(int[] tabela, int valor) {
        int posicao = funcaoHash(valor);
        int colisoesNaBusca = 0;
        int posicoesVerificadas = 0;

        while (posicoesVerificadas < 100) {
            if (tabela[posicao] == -1) {
                System.out.println("Valor " + valor + " nao encontrado.");
                return;
            } else if (tabela[posicao] == valor) {
                System.out.println("Valor " + valor + " encontrado na posicao "
                        + posicao + " (colisoes na busca: " + colisoesNaBusca + ").");
                return;
            } else {
                colisoesNaBusca++;
                posicoesVerificadas++;
                posicao = rehash(posicao);
            }
        }

        System.out.println("Valor " + valor + " nao encontrado.");
    }

    public static void main(String[] args) {
        int[] tabela = new int[100];
        Random random = new Random(1090);

        // -1 representa uma posicao vazia (os numeros gerados sao >= 0).
        for (int i = 0; i < 100; i++) {
            tabela[i] = -1;
        }

        int ocupacao = 0;
        int totalColisoes = 0;
        int bloqueados = 0;

        // Guarda os tres valores com mais colisoes e a contagem de cada um.
        int[] topValores = {-1, -1, -1};
        int[] topColisoes = {-1, -1, -1};

        // Gera 100 valores, mas so insere enquanto a ocupacao for menor que 90%.
        for (int i = 0; i < 100; i++) {
            int valor = random.nextInt(100001); // intervalo: 0 a 100000, inclusive

            if (ocupacao >= 90) {
                bloqueados++;
            } else {
                int posicao = funcaoHash(valor);
                int colisoesDoValor = 0;

                // Se estiver ocupada, tenta a proxima posicao (rehash linear).
                while (tabela[posicao] != -1) {
                    colisoesDoValor++;
                    posicao = rehash(posicao);
                }

                tabela[posicao] = valor;
                ocupacao++;
                totalColisoes += colisoesDoValor;

                // Atualiza o ranking. Nos empates, o inserido antes fica na frente.
                if (colisoesDoValor > topColisoes[0]) {
                    topColisoes[2] = topColisoes[1];
                    topValores[2] = topValores[1];
                    topColisoes[1] = topColisoes[0];
                    topValores[1] = topValores[0];
                    topColisoes[0] = colisoesDoValor;
                    topValores[0] = valor;
                } else if (colisoesDoValor > topColisoes[1]) {
                    topColisoes[2] = topColisoes[1];
                    topValores[2] = topValores[1];
                    topColisoes[1] = colisoesDoValor;
                    topValores[1] = valor;
                } else if (colisoesDoValor > topColisoes[2]) {
                    topColisoes[2] = colisoesDoValor;
                    topValores[2] = valor;
                }
            }
        }

        System.out.println("=== ATIVIDADE 2 - TABELA HASH (REHASHING) ===");
        System.out.println("Numeros gerados: 100");
        System.out.println("Elementos inseridos: " + ocupacao);
        System.out.println("Elementos bloqueados apos 90%: " + bloqueados);
        System.out.println("Total de colisoes durante as insercoes: " + totalColisoes);

        System.out.println("\n=== TRES ELEMENTOS COM MAIS COLISOES ===");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "o: " + topValores[i]
                    + " - " + topColisoes[i] + " colisoes na insercao");
        }

        System.out.println("\n=== POSICOES LIVRES ===");
        for (int i = 0; i < 100; i++) {
            if (tabela[i] == -1) {
                System.out.println("Posicao " + i);
            }
        }

        System.out.println("\n=== TESTE DE BUSCA DOS TRES ELEMENTOS ===");
        for (int i = 0; i < 3; i++) {
            testarBusca(tabela, topValores[i]);
        }
    }
}
