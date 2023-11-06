/**
 *
 * @author mateu
 */
public class HashMapDivisionHash extends HashMap {

    public HashMapDivisionHash(int size) {
        super(size);
    }

    @Override
    public int hash(int value) {
        // Implementação simples de hash da divisão.
        return value % getSize();
    }
}
