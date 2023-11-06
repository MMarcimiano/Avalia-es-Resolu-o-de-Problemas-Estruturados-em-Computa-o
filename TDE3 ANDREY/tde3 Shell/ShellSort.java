public class ShellSort {
    public static class ResultadoShellSort {
        int trocas;
        int iteracoes;

        public ResultadoShellSort(int trocas, int iteracoes) {
            this.trocas = trocas;
            this.iteracoes = iteracoes;
        }
    }

    public static ResultadoShellSort shellSort(int vetor[]) {
        int n = vetor.length;
        int trocas = 0;
        int iteracoes = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vetor[i];
                int j;
                iteracoes++;

                for (j = i; j >= gap && vetor[j - gap] > temp; j -= gap) {
                    vetor[j] = vetor[j - gap];
                    trocas++;
                }
                vetor[j] = temp;
            }
        }

        return new ResultadoShellSort(trocas, iteracoes);
    }
}
