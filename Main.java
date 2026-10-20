public class Main {
    public static void main(String[] args) {
        // Valores da figura do enunciado.
        FilaCircular a = new FilaCircular(4);
        FilaCircular b = new FilaCircular(5);
        FilaCircular r = new FilaCircular(9);

        a.insere(12);
        a.insere(35);
        a.insere(52);
        a.insere(64);

        b.insere(5);
        b.insere(15);
        b.insere(23);
        b.insere(55);
        b.insere(75);

        OperacoesFila.merge(a, b, r);

        System.out.println("Resultado do Merge:");
        System.out.println("Primeiro: " + r.primeiro());
        System.out.println("Ultimo: " + r.ultimo());

        while (!r.vazia()) {
            System.out.print(r.remove() + " ");
        }
        System.out.println();

        // Teste para verificar o comportamento circular do array.
        FilaCircular teste = new FilaCircular(3);
        teste.insere(10);
        teste.insere(20);
        teste.insere(30);
        teste.remove();
        teste.insere(40); // Reutiliza uma posicao no inicio do array.

        System.out.println("Teste circular:");
        while (!teste.vazia()) {
            System.out.print(teste.remove() + " ");
        }
        System.out.println();
    }
}
