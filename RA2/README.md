# RA2 - Arvore Binaria de Codigo Morse (material de estudo)

## Integrantes informados
- Lucas Tian Le Wu
- Eduardo dos Santos Granha
- Thiago Marcos Burtet

> **Atencao:** o enunciado do professor proibe expressamente uso de IA generativa na realizacao da atividade. Este material e um exemplo de referencia para estudo, nao uma entrega que atenda a essa regra. Desenvolvam sua propria implementacao conforme as orientacoes do professor.

## Objetivo
Representar o alfabeto A-Z e os digitos 0-9 em uma arvore binaria Morse:
- ponto (`.`) leva ao filho esquerdo;
- traco (`-`) leva ao filho direito;
- a raiz nao possui simbolo.

## Arquivos
- `Nodo.java`: char do simbolo + referencias para esquerda/direita.
- `ArvoreBinariaMorse.java`: inicializacao, insercao, buscas, codificacao, decodificacao e exibicao.
- `Main.java`: menu no terminal e demonstracao do exemplo SOS.

## Como compilar e rodar
Abra o terminal na pasta `RA2` e execute:

```bash
javac Nodo.java ArvoreBinariaMorse.java Main.java
java Main
```

## Exemplo

Entrada em texto: `SOS`

Saida em Morse: `... --- ...`

Entrada em Morse: `... --- ...`

Saida em texto: `SOS`

Entrada em texto: `OLA 2026`

Saida em Morse: `--- .-.. .- / ..--- ----- ..--- -....`

## Como funciona
1. `inicializar()` cadastra as 26 letras e 10 numeros.
2. `inserir()` segue o codigo Morse e cria nodos faltantes.
3. `buscarSimbolo()` desce esquerda/direita ate encontrar um caractere.
4. `buscarCodigo()` pesquisa a arvore recursivamente e devolve o caminho de pontos/tracos.
5. `codificar()` varre o texto e busca o codigo de cada letra ou numero.
6. `buscar(String)` separa os codigos por espacos, traduz cada grupo e usa `/` como espaco entre palavras.
7. `exibir()` mostra a arvore hierarquicamente deitada para o lado.

## Restricoes observadas
- Nao sao usados `charAt`, `substring`, `toUpperCase`, `equals`, `split`, `StringBuilder` ou colecoes.
- Ha uso de `java.util.Scanner` (`nextLine`, `next`, `hasNext`, `useDelimiter`, `close`) e `String.length()`; `System.out` e usado para exibir as informacoes.
- **Confirme com o professor se `Scanner.useDelimiter("")` e permitido.** O enunciado permite Scanner, mas restringe fortemente outros recursos da API Java. Sem uma forma permitida de ler os caracteres de uma `String`, nao e possivel percorrer uma mensagem caractere por caractere.
- Este exemplo nao converte acentos nem pontuacao, que nao constam da tabela solicitada.
