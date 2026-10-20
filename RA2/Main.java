import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();

        Scanner teclado = new Scanner(System.in);
        String opcao;
        boolean executando = true;
        while (executando) {
            System.out.println("\n==== ARVORE BINARIA - CODIGO MORSE ====");
            System.out.println("1 - Exibir arvore");
            System.out.println("2 - Buscar Morse de uma letra ou numero");
            System.out.println("3 - Transformar texto em Morse");
            System.out.println("4 - Transformar Morse em texto");
            System.out.println("5 - Testar exemplo SOS");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    arvore.exibir();
                    break;
                case "2":
                    System.out.print("Digite UMA letra ou numero: ");
                    char letra = arvore.converterCaractere(teclado.nextLine());
                    String morse = arvore.buscar(letra);
                    if (morse == null) {
                        System.out.println("Caractere nao encontrado.");
                    } else {
                        System.out.println("Morse: " + morse);
                    }
                    break;
                case "3":
                    System.out.print("Digite um texto (A-Z, 0-9 e espacos): ");
                    String texto = teclado.nextLine();
                    System.out.println("Em Morse: " + arvore.codificar(texto));
                    break;
                case "4":
                    System.out.println("Separe letras por espacos e palavras por /.");
                    System.out.print("Digite o codigo Morse: ");
                    String mensagemMorse = teclado.nextLine();
                    System.out.println("Mensagem: " + arvore.buscar(mensagemMorse));
                    break;
                case "5":
                    System.out.println("S -> " + arvore.buscar('S'));
                    System.out.println("O -> " + arvore.buscar('O'));
                    System.out.println("... --- ... -> " + arvore.buscar("... --- ..."));
                    System.out.println("SOS -> " + arvore.codificar("SOS"));
                    break;
                case "0":
                    executando = false;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }

        teclado.close();
    }
}
