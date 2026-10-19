# RA1 — Fila Circular e Merge em Java

## Integrantes
- Lucas Tian Le Wu
- Eduardo dos Santos Granha
- Thiago Marcos Burtet

## Objetivo
Implementar um Tipo Abstrato de Dados (TAD) Fila Circular usando um array de inteiros e realizar o Merge de duas filas em ordem crescente.

## Arquivos
- `RA1/FilaCircular.java`: implementa as operações `cheia`, `vazia`, `insere`, `remove`, `primeiro` e `ultimo`.
- `RA1/OperacoesFila.java`: implementa o método `merge` com as operações da fila.
- `RA1/Main.java`: cria as filas com os números da figura e testa o funcionamento circular.

## Como executar

É necessário ter o JDK instalado. Dentro da pasta `RA1`, execute:

```bash
javac FilaCircular.java OperacoesFila.java Main.java
java Main
```

## Exemplo de execução

Entrada das filas:
- Fila A: 12, 35, 52, 64
- Fila B: 5, 15, 23, 55, 75

Saída:

```text
Resultado do Merge:
Primeiro: 5
Ultimo: 75
5 12 15 23 35 52 55 64 75
Teste circular:
20 30 40
```

Na figura do enunciado, o valor `5` aparece como `05`. Os dois representam o mesmo inteiro.

## Funcionamento

A fila segue o princípio **FIFO**: o primeiro elemento inserido é o primeiro a sair.

- `inicio` indica a posição do primeiro elemento.
- `fim` indica a posição do último elemento.
- `quantidade` controla quantos elementos existem na fila.
- O operador `%` faz o índice voltar ao começo do array quando alcança o final.

O método `merge` compara os primeiros elementos de A e B. O menor é removido da fila original e inserido em R. Quando uma das filas acaba, os elementos restantes da outra são transferidos para R.

**Observações:** A e B precisam estar previamente ordenadas; o Merge esvazia A e B; e R deve começar vazia e possuir capacidade para todos os elementos. A implementação não utiliza variáveis globais: cada objeto `FilaCircular` guarda seus próprios atributos privados.
