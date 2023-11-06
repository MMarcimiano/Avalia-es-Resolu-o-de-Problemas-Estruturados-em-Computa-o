public class QuickSort {
    public static class ResultadoQuickSort {
        int trocas;
        int iteracoes;

        public ResultadoQuickSort(int trocas, int iteracoes) {
            this.trocas = trocas;
            this.iteracoes = iteracoes;
        }
    }

    public static ResultadoQuickSort quicksort(int[] array) {
        int[] trocasIteracoes = {0, 0}; // [0] - trocas, [1] - iterações
        quicksort(array, 0, array.length - 1, trocasIteracoes);
        return new ResultadoQuickSort(trocasIteracoes[0], trocasIteracoes[1]);
    }

    private static void quicksort(int[] array, int inicio, int fim, int[] trocasIteracoes) {
        if (inicio < fim) {
            int indicePivo = particiona(array, inicio, fim, trocasIteracoes);
            quicksort(array, inicio, indicePivo - 1, trocasIteracoes);
            quicksort(array, indicePivo + 1, fim, trocasIteracoes);
        }
    }

    private static int particiona(int[] array, int inicio, int fim, int[] trocasIteracoes) {
        int pivo = array[inicio];
        int i = inicio;

        for (int j = inicio + 1; j <= fim; j++) {
            trocasIteracoes[1]++; // Incrementa o contador de iterações
            if (array[j] < pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                trocasIteracoes[0]++; // Incrementa o contador de trocas
            }
        }

        int temp = array[i];
        array[i] = array[inicio];
        array[inicio] = temp;
        trocasIteracoes[0]++; // Incrementa o contador de trocas

        return i;
    }
}
