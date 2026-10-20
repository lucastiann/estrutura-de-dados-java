// Representa um nodo da arvore binaria do codigo Morse.
public class Nodo {
    char simbolo;
    Nodo esquerda;
    Nodo direita;

    public Nodo(char simbolo) {
        this.simbolo = simbolo;
        this.esquerda = null;
        this.direita = null;
    }
}
