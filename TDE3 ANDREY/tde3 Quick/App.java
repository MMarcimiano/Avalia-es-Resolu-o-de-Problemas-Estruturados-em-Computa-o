import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        int numTestes = 5;

        for (int tamanho : tamanhos) {
            long tempoExecucaoTotal = 0;
            long totalTrocas = 0;
            long totalIteracoes = 0;

            for (int teste = 0; teste < numTestes; teste++) {
                int[] vetor = gerarVetorAleatorio(tamanho);

                long tempoInicio = System.nanoTime();
                QuickSort.ResultadoQuickSort resultado = QuickSort.quicksort(vetor);
                long tempoFim = System.nanoTime();

                tempoExecucaoTotal += (tempoFim - tempoInicio);
                totalTrocas += resultado.trocas;
                totalIteracoes += resultado.iteracoes;
            }

            double tempoExecucaoMedio = (double) tempoExecucaoTotal / numTestes / 1e6; // milissegundos
            double trocasMedias = (double) totalTrocas / numTestes;
            double iteracoesMedias = (double) totalIteracoes / numTestes;

            System.out.println("Tamanho do Array: " + tamanho);
            System.out.println("Tempo de Execução Médio (ms): " + tempoExecucaoMedio);
            System.out.println("Trocas Médias: " + trocasMedias);
            System.out.println("Iterações Médias: " + iteracoesMedias);
            System.out.println();
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt();
        }
        return vetor;
    }
}
