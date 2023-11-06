/**
 *
 * @author mateu
 */
import java.util.Random;

public class Main {
	
	public static void test(HashMap h, String name, long seed, int times) {
		long startTime, endTime;
		Registro[] keys = new Registro[times];
		Registro[] values = new Registro[times];
		Random rand = new Random(seed);
		
		int size = 9;
		int[] digits = new int[size];
		
		for (int i = 0; i < times; i++) {
			for (int j = 0; j < size; j++) {
				digits[j] = (int) Math.floor(rand.nextDouble() * 9);
			}
			keys[i] = new Registro(size);
			keys[i].setDigits(digits);

			for (int j = 0; j < size; j++) {
				digits[j] = (int) Math.floor(rand.nextDouble() * 9);
			}
			values[i] = new Registro(size);
			values[i].setDigits(digits);
		}

		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			h.put(keys[i].getValue(), values[i].getValue());
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Teste insercao do hash " + name + "\n" + "\tOperacoes: " + times + "\tTamanho: " + h.getSize() + "\tTempoMs: " + (endTime - startTime) + "ms" + "\tColisoes: " + h.getCollisions() + " (" + (Math.round(100 * (double) h.getCollisions() / times)) + "%)");
	}
	
	public static void main(String[] args) {
		long seed = (new Random()).nextLong();
		int[] testSizes = {40000, 200000, 1000000, 2000000, 10000000 };
		int[] testTimes = {20000, 100000, 500000, 1000000, 5000000 };
		
		for (int i = 0; i < 5; i++) {
			HashMap hSimpleMult = new HashMapMultiplicao(testSizes[i]);
			test(hSimpleMult, "Multiplicacao", seed, testTimes[i]);
		}
                System.out.println();
                
                 for (int i = 0; i < 5; i++) {
                    HashMap hFNV1 = new HashMapFNV1(testSizes[i]); // Crie uma instância da classe HashMapFNV1
                    test(hFNV1, "FNV1", seed, testTimes[i]);
                }
                System.out.println();
                 
                for (int i = 0; i < 5; i++) {
                    HashMap hMurmurHash3 = new HashMapMurmurHash3(testSizes[i]);
                    test(hMurmurHash3, "MurmurHash3", seed, testTimes[i]);
                }
                System.out.println();
                
                for (int i = 0; i < 5; i++) {
                    HashMap hDivisionHash = new HashMapDivisionHash(testSizes[i]);
                    test(hDivisionHash, "Division Hash", seed, testTimes[i]);
                }
		System.out.println();
		
		System.out.println("Encerrado.");
	}

}

