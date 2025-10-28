# TDE3-RPEC
Este é o TDE 3 de Resolução de Problemas Estruturados na Computação, sobre comparação de algorítmos de ordenação em Java.

Aluna: Christine von Schmalz

# Comparação de Algoritmos de Ordenação

Algorítmos implementados:

### Bubble sort: 
Compara cada par de elementos, e os troca se não estiverem ordenados.

### Selection sort: 
Seleciona um índice, procura o menor item no resto do vetor, e o troca com o elemento de menor índice.

### Cocktail sort: 
Semelhante ao bubble sort, mas bidirecional. Compara cada par de elementos e os troca se não estiverem ordenados, rodando uma vez de esquerda para direita, e outra de direita para esquerda. Também desconsidera índices onde o elemento já foi ordenado.

### Comb sort: 
Compara elementos em distâncias cada vez menores.

### Gnome sort: 
Compara cada par de elementos. Se a ordem estiver certa, vai à direita, se estiver errada, troca e vai à esquerda.

### Bucket sort: 
Não troca elementos. Procura o valor mínimo e o valor máximo, assim como a frequência de cada valor, e monta um vetor ordenado com base nessas informações.

# Resultados

## Vetor 1

### Trocas:
| Posição | Algoritmo      | Trocas |
| ------- | -------------- | ------ |
| 1º      | Selection sort | 18     |
| 2º      | Comb sort      | 22     |
| 3º      | Bubble sort    | 78     |
| 3º      | Gnome sort     | 78     |
| 3º      | Cocktail sort  | 78     |
| --      | Bucket sort    | 0 (desconsiderado)|


### Iterações:
| Posição | Algoritmo      | Iterações |
| ------- | -------------- | --------- |
| 1º      | Bucket sort    | 39        |
| 2º      | Comb sort      | 129       |
| 3º      | Cocktail sort  | 154       |
| 4º      | Gnome sort     | 176       |
| 5º      | Selection sort | 190       |
| 6º      | Bubble sort    | 285       |

### Conclusão: 
O Vetor 1 está desordenado, o que faz com que algoritmos baseados em trocas, como Bubble, Gnome e Cocktail sort, realizem muitas operações. O Selection sort se destacou por precisar de menos trocas, enquanto o Comb sort equilibrou trocas e iterações de forma eficiente. Já o Bucket sort se mostrou muito rápido em termos de iterações, pois não depende de comparações, mostrando a vantagem de algoritmos de ordenação por contagem quando o domínio dos valores é limitado.

## Vetor 2

### Trocas:
| Posição | Algoritmo      | Trocas |
| ------- | -------------- | ------ |
| 1º      | Selection sort | 0     |
| 1º      | Comb sort      | 0     |
| 1º      | Bubble sort    | 0     |
| 1º      | Gnome sort     | 0     |
| 1º      | Cocktail sort  | 0     |
| --      | Bucket sort    | 0 (desconsiderado)|


### Iterações:
| Posição | Algoritmo      | Iterações |
| ------- | -------------- | --------- |
| 1º      | Bubble sort    | 19        |
| 1º      | Cocktail sort  | 19       |
| 3º      | Gnome sort  | 20       |
| 4º      | Bucket sort     | 39       |
| 5º      | Comb sort | 110       |
| 6º      | Selection sort    | 190       |

### Conclusão: 
O vetor 2 está ordenado, então não houve troca alguma em nenhum dos algorítmos. Isso expõe o número mínimo de iterações por algorítmo: Bubble e Cocktail sort iteram por cada elemento uma única vez, então são os mais eficientes nesse caso.

## Vetor 3
### Trocas:
| Posição | Algoritmo      | Trocas |
| ------- | -------------- | ------ |
| 1º      | Selection sort | 10     |
| 2º      | Comb sort      | 18     |
| 3º      | Bubble sort    | 190     |
| 3º      | Gnome sort     | 190     |
| 3º      | Cocktail sort  | 190     |
| --      | Bucket sort    | 0 (desconsiderado)|


### Iterações:
| Posição | Algoritmo      | Iterações |
| ------- | -------------- | --------- |
| 1º      | Bucket sort    | 39        |
| 2º      | Comb sort      | 129       |
| 3º      | Selection sort | 190       |
| 4º      | Cocktail sort  | 190       |
| 5º      | Bubble sort    | 380       |
| 6º      | Gnome sort     | 400       |

### Conclusão: 
O vetor 3 está em ordem decrescente, ou seja, no pior caso para algoritmos que dependem de trocas adjacentes (Bubble, Cocktail e Gnome sort). Por isso, esses algoritmos apresentam o maior número de trocas e iterações. O Selection sort e Comb sort, que minimizam trocas, continuam eficientes mesmo em casos desfavoráveis, enquanto o Bucket sort mantém iterações mínimas, já que seu funcionamento independe da ordem inicial dos elementos.

## Conclusões gerais

### Eficiência de trocas:

Algoritmos que trocam apenas quando necessário (Selection e Comb sort) apresentam menor número de trocas em vetores parcialmente ou totalmente desordenados. Bubble, Cocktail e Gnome sort realizam muitas trocas em vetores desordenados, especialmente no pior caso (Vetor 3).

### Eficiência de iterações:

Bucket sort tem menor número de iterações, pois utiliza contagem e distribuição ao invés de comparar elementos individualmente. Algoritmos bidirecionais (Cocktail sort) ou com pequenas otimizações (Comb sort) reduzem significativamente iterações em comparação com Bubble e Gnome sort.

### Impacto da ordem inicial do vetor:

Vetores já ordenados (Vetor 2) mostram que Bubble e Cocktail sort podem ser extremamente eficientes, pois detectam rapidamente que não há necessidade de trocas. Vetores em ordem decrescente (Vetor 3) representam o pior caso para algoritmos que dependem de trocas adjacentes, evidenciando o impacto da ordem inicial.

