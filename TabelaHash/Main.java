import java.util.Random;

public class Main {

    // Cada no representa um valor que entrou por colisao.
    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public static void main(String[] args) {
        int[] tabela = new int[100];
        boolean[] ocupada = new boolean[100];
        No[] listas = new No[100];

        Random random = new Random(1090);
        int[] ultimos = new int[3];
        int totalColisoes = 0;

        // Inserir 1000 numeros na tabela hash.
        for (int i = 0; i < 1000; i++) {
            int valor = random.nextInt(100001); // De 0 ate 100000, inclusive.
            int posicao = valor % 100;           // Funcao hash.

            if (!ocupada[posicao]) {
                // Primeira insercao: guarda diretamente na tabela.
                tabela[posicao] = valor;
                ocupada[posicao] = true;
            } else {
                // Colisao: guarda o valor em uma lista encadeada.
                totalColisoes++;

                ultimos[0] = ultimos[1];
                ultimos[1] = ultimos[2];
                ultimos[2] = valor;

                No novo = new No(valor);

                if (listas[posicao] == null) {
                    listas[posicao] = novo;
                } else {
                    if (valor < listas[posicao].valor) {
                        // Coloca antes do primeiro no da lista.
                        novo.proximo = listas[posicao];
                        listas[posicao] = novo;
                    } else {
                        // Encontra o lugar correto para manter a lista ordenada.
                        No atual = listas[posicao];
                        while (atual.proximo != null && atual.proximo.valor <= valor) {
                            atual = atual.proximo;
                        }
                        novo.proximo = atual.proximo;
                        atual.proximo = novo;
                    }
                }
            }
        }

        // Verificar a maior lista, a quantidade de listas e posicoes vazias.
        int quantidadeListas = 0;
        int posicoesVazias = 0;
        int tamanhoMaior = 0;
        int posicaoMaior = -1;

        for (int i = 0; i < 100; i++) {
            if (!ocupada[i]) {
                posicoesVazias++;
            } else {
                int tamanho = 0;
                No atual = listas[i];

                while (atual != null) {
                    tamanho++;
                    atual = atual.proximo;
                }

                if (tamanho > 0) {
                    quantidadeListas++;
                }
                if (tamanho > tamanhoMaior) {
                    tamanhoMaior = tamanho;
                    posicaoMaior = i;
                }
            }
        }

        System.out.println("RESULTADO DA TABELA HASH");
        System.out.println("Elementos inseridos: 1000");
        System.out.println("Quantidade de listas encadeadas: " + quantidadeListas);
        System.out.println("Posicoes vazias: " + posicoesVazias);
        System.out.println("Total de colisoes: " + totalColisoes);
        System.out.println("Maior lista encadeada na posicao: " + posicaoMaior);
        System.out.println("Quantidade de nos da maior lista: " + tamanhoMaior);

        if (posicaoMaior != -1) {
            System.out.println("Valor principal da posicao: " + tabela[posicaoMaior]);
            System.out.print("Valores da maior lista: ");

            No atual = listas[posicaoMaior];
            while (atual != null) {
                System.out.print(atual.valor);
                if (atual.proximo != null) {
                    System.out.print(" -> ");
                }
                atual = atual.proximo;
            }
            System.out.println();
        }

        System.out.println("Tres ultimos valores inseridos por colisao:");
        if (totalColisoes >= 3) {
            System.out.println(ultimos[0] + ", " + ultimos[1] + ", " + ultimos[2]);
        } else {
            System.out.println("Ocorreram menos de tres colisoes.");
        }
    }
}
