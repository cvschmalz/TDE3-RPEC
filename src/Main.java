public class Main {
    // variáveis globais para manter o número de trocas e iterações
    static int trocas = 0;
    static int iteracoes = 0;

    // função para trocar dois elementos
    public static void trocar(int[] vetor, int primeiro, int segundo) {
//        System.out.println("Trocando " + vetor[primeiro] + " com " + vetor[segundo]);
        int temp = vetor[primeiro];
        vetor[primeiro] = vetor[segundo];
        vetor[segundo] = temp;
        trocas++;
    }

    // bubble sort com flag de parada
    // compara cada par de elementos
    // usa uma flag de parada ("trocou"): se tiver um loop onde não trocou nenhum elemento, não tem mais nada para ordenar, então ele para
    public static void bubble_sort(int[] vetor, int comprimento) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < comprimento - 1; i++) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    trocar(vetor, i, i + 1);
                    trocou = true;
                }
            }
        } while (trocou);
    }

    // selection sort
    // procura o menor item no resto do vetor e o coloca no indice correto
    public static void selection_sort(int[] vetor, int comprimento) {
        for (int i = 0; i < comprimento - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < comprimento; j++) {
                iteracoes++;
                if (vetor[j] < vetor[indice]) {
                    indice = j;
                }
            }
            if (indice != i) {
                trocar(vetor, i, indice);
            }
        }
    }

    // cocktail sort
    // é como um bubble sort bidirecional, roda uma vez de esquerda para direita e depois da direita para esquerda
    // usa uma flag de parada ("trocou"): se tiver um loop onde não trocou nenhum elemento, não tem mais nada para ordenar, então ele para
    public static void cocktail_sort(int[] vetor, int comprimento) {
        boolean trocou = true;
        // grava o começo e final da parte que ainda não foi ordenada
        int comeco_atual = 0;
        int final_atual = comprimento - 1;
        while (trocou) {
            trocou = false;
            for (int i = comeco_atual; i < final_atual; i++) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    trocar(vetor, i, i + 1);
                    trocou = true;
                }
            }
            if (!trocou) break; // se não houve troca, está tudo ordenado

            trocou = false;
            final_atual--;  // desconsidera o último elemento porque já está ordenado

            for (int i = final_atual - 1; i >= comeco_atual; i--) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    trocar(vetor, i, i + 1);
                    trocou = true;
                }
            }
            comeco_atual++;  // desconsidera o primeiro elemento porque já está ordenado
        }
    }

    // comb sort
    // compara elementos com gaps cada vez menores
    public static void comb_sort(int[] vetor, int comprimento) {
        int gap = comprimento;
        boolean trocou = true;
        while (gap > 1 || trocou) {
            if (gap > 1) gap = (gap * 10) / 13; // divide por 1.3
            trocou = false;
            for (int i = 0; i + gap < comprimento; i++) {
                iteracoes++;
                if (vetor[i] > vetor[i + gap]) {
                    trocar(vetor, i, i + gap);
                    trocou = true;
                }
            }
        }
    }

    // gnome sort
    // se a ordem estiver certa, vai à direita, se estiver errada, troca e vai à esquerda
    public static void gnome_sort(int[] vetor, int comprimento) {
        int i = 0;
        while (i < comprimento) {
            iteracoes++;
            if (i == 0 || vetor[i] >= vetor[i - 1]) {
                i++;
            } else {
                trocar(vetor, i, i - 1);
                i--;
            }
        }
    }

    // bucket sort
    // esse algorítmo não usa trocas!
    // procura o valor mínimo e o valor máximo, assim como a frequência de cada valor, e monta um vetor ordenado com base nessas informações
    public static void bucket_sort(int[] vetor, int comprimento) {
        // procura valor mínimo e máximo:
        int min = vetor[0], max = vetor[0];
        for (int i = 1; i < comprimento; i++) {
            iteracoes++;
            if (vetor[i] < min) min = vetor[i];
            if (vetor[i] > max) max = vetor[i];
        }

        // contar frequência de cada valor
        int range = max - min + 1;
        int[] frequencia = new int[range];
        for (int i = 0; i < comprimento; i++) {
            iteracoes++;
            frequencia[vetor[i] - min]++;
        }

        // montar um vetor ordenado baseado nas informações achadas
        int indice = 0;
        for (int i = 0; i < range; i++) {
            while (frequencia[i] > 0) {
                vetor[indice++] = i + min;
                frequencia[i]--;
            }
        }
    }

    // testar e imprimir os resultados
    public static void testar(String nome, int[] vetor, int comprimento) {
        // copiar cada vetor para rodar o teste
        int[] copia = new int[comprimento];
        for (int i = 0; i < comprimento; i++) copia[i] = vetor[i];

        trocas = 0;
        iteracoes = 0;

        switch (nome) {
            case "bubble" -> bubble_sort(copia, comprimento);
            case "selection" -> selection_sort(copia, comprimento);
            case "cocktail" -> cocktail_sort(copia, comprimento);
            case "comb" -> comb_sort(copia, comprimento);
            case "gnome" -> gnome_sort(copia, comprimento);
            case "bucket" -> bucket_sort(copia, comprimento);
        }

        System.out.println("[" + nome + "] trocas: " + trocas + ", iterações: " + iteracoes);
    }

    public static void main(String[] args) {
        int[] vetor1 = {12,18,9,25,17,31,22,27,16,13,19,23,20,30,14,11,15,24,26,28};
        int[] vetor2 = {5,7,9,10,12,14,15,17,19,21,22,23,24,25,27,28,29,30,31,32};
        int[] vetor3 = {99,85,73,60,50,40,35,30,25,20,15,14,13,12,11,10,9,8,7,6};

        int comprimento = 20;

        int[][] vetores = {vetor1, vetor2, vetor3};
        String[] algoritmos = {"bubble", "selection", "cocktail", "comb", "gnome", "bucket"};

        for (int i = 0; i < 3; i++) {
            System.out.println("\n---- VETOR " + (i + 1) + " ---");
            for (int j = 0; j < 6; j++) {
                testar(algoritmos[j], vetores[i], comprimento);
            }
        }

    }
}
