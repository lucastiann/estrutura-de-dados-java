import java.util.Scanner;

// Cada ponto segue pela esquerda e cada traco segue pela direita.
public class ArvoreBinariaMorse {
    private Nodo raiz;

    public ArvoreBinariaMorse() {
        raiz = new Nodo('\0'); // raiz sem letra
    }

    // Insere automaticamente as letras A-Z e os algarismos 0-9.
    public void inicializar() {
        raiz = new Nodo('\0');

        char[] caracteres = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '0','1','2','3','4','5','6','7','8','9'
        };

        String[] codigos = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
            "---..", "----."
        };

        for (int i = 0; i < caracteres.length; i++) {
            inserir(codigos[i], caracteres[i]);
        }
    }

    // Cria os nodos do caminho, se ainda nao existem.
    public void inserir(String codigo, char simbolo) {
        Nodo atual = raiz;
        Scanner leitor = new Scanner(codigo);
        leitor.useDelimiter(""); // leitura de cada ponto ou traco pelo Scanner

        while (leitor.hasNext()) {
            String passo = leitor.next();
            switch (passo) {
                case ".":
                    if (atual.esquerda == null) {
                        atual.esquerda = new Nodo('\0');
                    }
                    atual = atual.esquerda;
                    break;
                case "-":
                    if (atual.direita == null) {
                        atual.direita = new Nodo('\0');
                    }
                    atual = atual.direita;
                    break;
                default:
                    leitor.close();
                    return; // codigo diferente de ponto/traco
            }
        }
        leitor.close();
        atual.simbolo = simbolo;
    }

    // Recebe um codigo como "..." e devolve o seu caractere.
    public char buscarSimbolo(String codigo) {
        Nodo atual = raiz;
        Scanner leitor = new Scanner(codigo);
        leitor.useDelimiter("");

        while (leitor.hasNext() && atual != null) {
            String passo = leitor.next();
            switch (passo) {
                case ".":
                    atual = atual.esquerda;
                    break;
                case "-":
                    atual = atual.direita;
                    break;
                default:
                    leitor.close();
                    return '?';
            }
        }
        leitor.close();

        if (atual == null || atual.simbolo == '\0') {
            return '?';
        }
        return atual.simbolo;
    }

    // Procura uma letra ou um numero e devolve o caminho em Morse.
    public String buscarCodigo(char simbolo) {
        return procurarCodigo(raiz, simbolo, "");
    }

    private String procurarCodigo(Nodo atual, char simbolo, String caminho) {
        if (atual == null) {
            return null;
        }
        if (atual.simbolo == simbolo) {
            return caminho;
        }

        String esquerda = procurarCodigo(atual.esquerda, simbolo, caminho + ".");
        if (esquerda != null) {
            return esquerda;
        }
        return procurarCodigo(atual.direita, simbolo, caminho + "-");
    }

    // Busca sobrecarregada: recebe letra e retorna Morse.
    public String buscar(char simbolo) {
        return buscarCodigo(simbolo);
    }

    // Busca sobrecarregada: recebe Morse e retorna texto.
    // Separe letras por espacos e palavras com "/".
    public String buscar(String mensagemMorse) {
        String resultado = "";
        Scanner leitor = new Scanner(mensagemMorse);

        while (leitor.hasNext()) {
            String pedaco = leitor.next();
            switch (pedaco) {
                case "/":
                    resultado += " ";
                    break;
                default:
                    resultado += buscarSimbolo(pedaco);
                    break;
            }
        }
        leitor.close();
        return resultado;
    }

    // Traduz um texto para Morse usando a propria arvore.
    public String codificar(String texto) {
        String resultado = "";
        Scanner leitor = new Scanner(texto);
        leitor.useDelimiter("");

        while (leitor.hasNext()) {
            char simbolo = converterCaractere(leitor.next());
            if (simbolo == ' ') {
                if (resultado.length() > 0) {
                    resultado += " /";
                }
            } else {
                String codigo = buscarCodigo(simbolo);
                if (codigo != null) {
                    if (resultado.length() > 0) {
                        resultado += " ";
                    }
                    resultado += codigo;
                }
                // Pontuacao e outros simbolos nao foram definidos no enunciado.
            }
        }
        leitor.close();
        return resultado;
    }

    public char converterCaractere(String texto) {
        switch (texto) {
            case "a": case "A": return 'A';
            case "b": case "B": return 'B';
            case "c": case "C": return 'C';
            case "d": case "D": return 'D';
            case "e": case "E": return 'E';
            case "f": case "F": return 'F';
            case "g": case "G": return 'G';
            case "h": case "H": return 'H';
            case "i": case "I": return 'I';
            case "j": case "J": return 'J';
            case "k": case "K": return 'K';
            case "l": case "L": return 'L';
            case "m": case "M": return 'M';
            case "n": case "N": return 'N';
            case "o": case "O": return 'O';
            case "p": case "P": return 'P';
            case "q": case "Q": return 'Q';
            case "r": case "R": return 'R';
            case "s": case "S": return 'S';
            case "t": case "T": return 'T';
            case "u": case "U": return 'U';
            case "v": case "V": return 'V';
            case "w": case "W": return 'W';
            case "x": case "X": return 'X';
            case "y": case "Y": return 'Y';
            case "z": case "Z": return 'Z';
            case "0": return '0';
            case "1": return '1';
            case "2": return '2';
            case "3": return '3';
            case "4": return '4';
            case "5": return '5';
            case "6": return '6';
            case "7": return '7';
            case "8": return '8';
            case "9": return '9';
            case " ": return ' ';
            default: return '?';
        }
    }

    // Exibe a arvore na horizontal, com a direita primeiro.
    public void exibir() {
        System.out.println("Arvore Morse (ponto = esquerda, traco = direita):");
        exibirNodo(raiz, 0);
    }

    private void exibirNodo(Nodo atual, int nivel) {
        if (atual == null) {
            return;
        }
        exibirNodo(atual.direita, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        if (atual.simbolo == '\0') {
            System.out.println("*"); // nodo intermediario sem simbolo
        } else {
            System.out.println(atual.simbolo);
        }

        exibirNodo(atual.esquerda, nivel + 1);
    }
}
