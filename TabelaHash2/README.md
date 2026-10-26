# Atividade 2 - Tabela Hash com Rehashing

Exercicio de Estrutura de Dados em Java, utilizando rehashing linear para tratar colisoes.

## Regras

- Tabela com 100 posicoes.
- Geracao de 100 valores pseudoaleatorios com `Random(1090)`, no intervalo de 0 a 100000 (inclusive).
- Posicao inicial: `valor % 100`.
- Em caso de colisao, rehashing linear: `(posicao + 1) % 100`.
- Interrompe as insercoes quando 90 das 100 posicoes estao ocupadas.
- Nao utiliza estruturas prontas da API Java (como HashMap ou listas); somente arrays, if/else, for, while e Random.

## Como executar

No terminal, na pasta do arquivo:

```bash
javac Main.java
java Main
```

## Resultado com seed 1090

- Valores gerados: **100**
- Valores inseridos: **90**
- Insercoes bloqueadas pelo limite de 90%: **10**
- Numero total de colisoes **nas insercoes**: **247**
- Tres valores com mais colisoes na insercao: **55998 (28)**, **52201 (26)** e **19454 (23)**.
- Posicoes livres: **35, 36, 37, 46, 47, 48, 49, 50, 88, 90**.

## Teste de busca

O programa usa a mesma funcao hash e o mesmo rehashing linear para procurar os tres numeros:

- `55998`: encontrado na posicao **26**, apos **28** colisoes na busca.
- `52201`: encontrado na posicao **27**, apos **26** colisoes na busca.
- `19454`: encontrado na posicao **77**, apos **23** colisoes na busca.

**Observacao:** cada acesso a uma posicao ocupada por outro elemento durante a insercao conta como uma colisao. Em caso de empate no ranking, os numeros inseridos primeiro sao priorizados.
