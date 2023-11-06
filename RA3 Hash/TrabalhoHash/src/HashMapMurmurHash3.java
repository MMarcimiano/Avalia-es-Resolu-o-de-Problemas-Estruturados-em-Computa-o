/**
 *
 * @author mateu
 */
public class HashMapMurmurHash3 extends HashMap {

    public HashMapMurmurHash3(int size) {
        super(size);
    }

    @Override
    public int hash(int value) {
        int seed = 0;  // Escolha um valor adequado para a semente, se necessário.
        int c1 = 0xcc9e2d51;
        int c2 = 0x1b873593;
        int r1 = 15;
        int r2 = 13;
        int m = 5;
        int n = 0xe6546b64;

        int hash = seed;
        int k = value;

        k *= c1;
        k = (k << r1) | (k >>> (32 - r1));
        k *= c2;

        hash ^= k;
        hash = (hash << r2) | (hash >>> (32 - r2));
        hash = hash * m + n;

        hash ^= (4 * getSize());  // Usando o método para obter o tamanho da tabela.

        return hash;
    }
}


